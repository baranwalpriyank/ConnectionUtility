package com.rolta.rapidhana.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class TestRandom {

	String str = "2016-11-06 01:01:03.298";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Timestamp ts= oracleValue();
		Timestamp ts1=hanaValue();
		
		System.out.println(ts.equals(ts1));
		System.out.println(ts.getTime()==ts1.getTime());
		
		
		
		
	}
	
	private static Timestamp oracleValue() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Timestamp ts=null;
		List<Timestamp> list = new LinkedList<Timestamp>();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@172.16.91.232:1521:orcl1", "sfv4", "SFV4");

		String query = "select TESTCOLUMN from SFV4_ACEQA94_S1.TESTTIMESTAMPTINSERTION";
		PreparedStatement stmnt = conn.prepareStatement(query);
		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			ts = rs.getTimestamp("TESTCOLUMN");
			list.add(ts);
			System.out.println("Oracle: " + ts);
			System.out.println("Value of timeStamp.getTime() oracle: "
					+ ts.getTime());

		}
		return ts;
	}
	
	private static Timestamp hanaValue() throws ClassNotFoundException, SQLException{
		Connection connHana=null;
		Timestamp tsHana=null;
		List<Timestamp> list = new LinkedList<Timestamp>();
		
		Class.forName("com.sap.db.jdbc.Driver");

		connHana = DriverManager.getConnection("jdbc:sap://172.16.11.114:31015", "smhdev", "Rolta@123");

		//String query = "select 1 from dummy";
		String queryHana = "select TESTCOLUMN from TESTP2_1.TESTTIMESTAMPTINSERTION";
		PreparedStatement stmntHana = connHana.prepareStatement(queryHana);

		ResultSet rsHana = stmntHana.executeQuery();
		while(rsHana.next()){
			tsHana = rsHana.getTimestamp("TESTCOLUMN");
			list.add(tsHana);
			System.out.println("Hana "+tsHana);
			System.out.println("Value of timeStamp.getTime() Hana: "+tsHana.getTime());	
		}
		return tsHana;
	}
}
