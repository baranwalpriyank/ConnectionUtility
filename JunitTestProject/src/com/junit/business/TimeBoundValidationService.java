package com.junit.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class TimeBoundValidationService {

	private static List<String> tableList = null;

	

	private final static String SELECT_TIME_BOUND_VALIDATION_TABLES = "SELECT UPPER(table_name)AS tableName, number_of_rows FROM time_bound_validation_table order by priority_order asc";

	/**
	 * get List of table names from postgres table time_bound_validation_table
	 * and return *return a list of table. Can be null or empty
	 */
/*	public static List<String> getTableList(Connection sourceConn,
			Connection psgresConn, String schemaName) {

		if (tableList != null) {
			return tableList;
		} else {
			loadTables(sourceConn, psgresConn, schemaName);
			return tableList;
		}

	}*/

	/**
	 * get table list from postgres table depeding on number of rows in oracle
	 * table
	 */
	public void loadTables(Connection sourceCon, Connection psgresConn,
			String schemaName) {
		System.out.println("Loading tables for time bound validation, Query: "
				+ SELECT_TIME_BOUND_VALIDATION_TABLES);

		Statement statement = null;
		ResultSet resultSet = null;

		try {

			statement = psgresConn.createStatement();
			resultSet = statement
					.executeQuery(SELECT_TIME_BOUND_VALIDATION_TABLES);

			// StringBuffer tableNames = new StringBuffer();
			Map<String, Integer> map = new LinkedHashMap<String, Integer>();
			while (resultSet.next()) {
				String tableName = resultSet.getString("tableName");
				int numberOfRows = resultSet.getInt("number_of_rows");
				map.put(tableName, numberOfRows);

			}
			System.out.println("value of map before: " + map);
			map = getRowBasedTableSorted(map, schemaName, sourceCon);// <--Need
																		// to
																		// check
																		// this
																		// method
			System.out.println("value of map after: " + map);

			tableList = new LinkedList<String>();
			for (String s : map.keySet()) {
				tableList.add(s);
			}
			// System.out.println(" tableName List: "+tableList);

			System.out.println("Tables List for time bound validation: " + tableList);

		} catch (SQLException e) {
			System.out.println(
					"Exception while getting tables from  time_bound_validation_tables table in postgres");
		} finally {
			try {

				if (resultSet != null)
					resultSet.close();

				if (statement != null)
					statement.close();

			} catch (Exception e) {
				System.out.println("Exception while closing connection");
			}
		}

	}

	/**
	 * Accepts map of table name and row count limit for each table queries
	 * oracle and finds table which exceed limit and hence should have timebound
	 * validation
	 * 
	 * @param map
	 *            map of table name and row count limit
	 * @param schemaName
	 * @param sourceAdaptor
	 * @return
	 */
	public Map<String, Integer> getRowBasedTableSorted(
			Map<String, Integer> map, String schemaName,
			Connection sourceConnection) {

		PreparedStatement statement1 = null;
		ResultSet resultSet1 = null;

		Map<String, Integer> updatedMap = new LinkedHashMap<String, Integer>();

		try {
			for (String tableName : map.keySet()) {
				System.out.println("getTableSortedAsPerColumn tableName: "
						+ tableName + " number of rows value: "
						+ map.get(tableName));
				System.out.println("getTableSortedAsPerColumn schemaName: "
						+ schemaName);

				statement1 = sourceConnection
						.prepareStatement("select num_rows from dba_tables where owner ='"
								+ schemaName
								+ "' AND TABLE_NAME ='"
								+ tableName + "'");

				System.out.println("select num_rows from dba_tables where owner ='"
						+ schemaName + "'AND TABLE_NAME ='" + tableName + "'");
				resultSet1 = statement1.executeQuery();
				boolean result = resultSet1.next();
				if (!result) {
					System.out.println("table not present in oracle: " + tableName);
				} else {
					int tableRows = resultSet1.getInt("NUM_ROWS");

					System.out.println("total number of rows : " + tableRows
							+ " for table: " + tableName);

					if (map.get(tableName) == 0) {
						// if row limit is 0 then table is always put in list
						updatedMap.put(tableName, map.get(tableName));
					} else if (tableRows <= map.get(tableName)) {
						// if table crosses row count limit then added to list
						updatedMap.put(tableName, map.get(tableName));
					}

				}
			}
			System.out.println("updatedTableName : " + updatedMap);
		} catch (SQLException e) {
			System.out.println(
					"Exception while getting tables from  time_bound_validation_tables table in postgres");
		} finally {

			try {
				if (resultSet1 != null)
					resultSet1.close();

				if (statement1 != null)
					statement1.close();

			} catch (Exception e) {
				System.out.println("Exception while closing connection");
			}

		}

		return updatedMap;
	}
}
