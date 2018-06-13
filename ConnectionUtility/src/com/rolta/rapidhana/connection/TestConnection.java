package com.rolta.rapidhana.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

import com.rolta.rapidhana.connection.OracleConnectionClass;

public class TestConnection {

	
	
	public static void main(String[] args) {
		
		InputStream ios = HanaConnectionClass.class.getClassLoader()
				.getResourceAsStream("attribute.properties");
		Properties prop = new Properties();
		
		try {
			prop.load(ios);
			
			Boolean testCon1 = Boolean.parseBoolean(prop.getProperty("testCon1"));
			System.out.println("testCon1: "+testCon1);
			Boolean testCon2 = Boolean.parseBoolean(prop.getProperty("testCon2"));
			System.out.println("testCon2: "+testCon2);
		

		
		OracleConnectionClass orcl = new OracleConnectionClass();
		HanaConnectionClass hana = new HanaConnectionClass();

		if(testCon1){
			Thread thread1 = new Thread(orcl);
			thread1.start();
		}
		if(testCon2){
			
		Thread thread2 = new Thread(hana);
		thread2.start();
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
