package com.rolta.rapidhana.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilityClass {

	public static void connectionMethod() {

		List<String> str = new ArrayList<String>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.16.91.232:1521:orcl1", "sfv4",
					"Rolta123");

			try {
				ps = conn
						.prepareStatement("select table_name from all_tables where owner = ? order by table_name");
				ps.setString(1, "SFV4_AVIVACANADAQA");
				rs = ps.executeQuery();

				System.out.println("table name retrival started");
				
				while (rs.next()) {
					str.add(rs.getString("table_name"));
				}
				
				
				System.out.println("Size of the list is: "+str.size());

			} catch (SQLException e) {

			} finally {
				/*try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("table name retrieval completed successfully ");
		
		Long beforeTime = System.currentTimeMillis();
		System.out.println("Changing table access to read only");
		PreparedStatement ps1= null;
		try {
		for (String obj : str) {
			
			String name = "SFV4_AVIVACANADAQA";
				ps1 = conn.prepareStatement("alter table "+name+"."+ obj + " read write");
				//ps1.setString(1, "SFV4_QAAUTOEC2_TEST9");
				ps1.executeQuery();
				ps1.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		Long afterTime = System.currentTimeMillis();
		System.out.println("Total time taken for changing table access to read only: " + (afterTime - beforeTime)
				+ " ms");
			
		

	}

	private static void changeAccessMethod(List<String> str) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.16.91.232:1521:orcl1", "sfv4",
					"Rolta123");
			Long beforeTime = System.currentTimeMillis();
			try {

				System.out.println("Changing table access to read only");

				for (String obj : str) {
					ps = conn.prepareStatement("alter table SFV4_QAAUTOEC2_TEST9."+ obj + " read only");
					ps.executeUpdate();
					ps.close();

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			Long afterTime = System.currentTimeMillis();
			System.out.println("Total time taken for changing table access to read only: " + (afterTime - beforeTime)
					+ " ms");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		validateTable();
	}

	private static void validateTable() {

		List<String> str = new ArrayList<String>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.16.91.232:1521:orcl1", "sfv4",
					"Rolta123");

			try {
				ps = conn
						.prepareStatement("select table_name from all_tables where owner = 'SFV4_QAAUTOEC2_TEST9' and read_only='NO' order by table_name");
				rs = ps.executeQuery();

				
				Long beforeTime = System.currentTimeMillis();
				
				while (rs.next()) {
					str.add(rs.getString("table_name"));
				}
				
				Long afterTime = System.currentTimeMillis();
				System.out.println("Total time taken for validation : " + (afterTime - beforeTime)
						+ " ms");
				if(str.size()>0){
					System.out.println("tables names with read only acccess is : "+ str);
				}
				

			} catch (SQLException e) {

			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

	public static void main(String[] args) {
		connectionMethod();
		
	}

}
