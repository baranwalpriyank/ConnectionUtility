package com.rolta.rapidhana.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;

/*Thread to check oracle connectivity*/

public class OracleConnectionClass implements Runnable {

	/*private static Logger infoLogger = Logger
			.getLogger("infologger."+OracleConnectionClass.class.getName());*/
			private static Logger debugLogger = Logger
			.getLogger("debuglogger");
	private static Logger logger = Logger
			.getLogger(OracleConnectionClass.class);

	@Override
	public void run() {
		while (true) {
			System.out.println("in class OracleConnectionClass");
			logger.info("Thread to check oracle connection running");
			InputStream ios = OracleConnectionClass.class.getClassLoader()
					.getResourceAsStream("attribute.properties");
			Properties prop = new Properties();
			Connection conn = null;
			long sleepTime = 0;

			try {
				prop.load(ios);

				String connString = prop.getProperty("oracleConnString");
				String user = prop.getProperty("oracleUser");
				String password = prop.getProperty("oraclePassword");
				String time = prop.getProperty("sleepTime");
				sleepTime = Long.parseLong(time);

				// loading Driver
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection(connString, user, password);

				String query = "select 1 from dual";
				//String query ="select END_TIME from SFV4_ACEQA94_S1.SYS_UPGRADE_DETAIL";
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String beforeTime = dateFormat.format(cal.getTime());

				PreparedStatement stmnt = conn.prepareStatement(query);
				
				ResultSet rs = stmnt.executeQuery();
				System.out.println("Query executed: "+rs.next());
				
				/*while(rs.next()){
					System.out.println("rs.next(): "+rs.next());
					Timestamp ts = rs.getTimestamp("END_TIME");
					
					System.out.println("Value of timeStamp: "+ts);
					System.out.println("Value of timeStamp.getTime(): "+ts.getTime());	
				}*/
				
				String afterTime = dateFormat.format(cal.getTime());

				logger.debug("Before Time:- " + beforeTime
						+ " and After Time:- " + afterTime
						+ " for Oracle Connection");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				logger.error("SQL Exception occured " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					logger.info("Connection closing");
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
