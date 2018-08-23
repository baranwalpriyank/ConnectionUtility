package postgresDetails;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class SchemaDetailsTest {
   public static void main(String args[]) throws Exception {
     String databaseName = "xyz";
     String userName = "xyz";
     String password = "xyz";
     String mySQLPort = "xyz";
     String hostUrl = "localhost";
     // Setup the connection with the DB
     Class.forName("org.postgresql.Driver");
     Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostUrl
         + ":" + mySQLPort+"/"+databaseName, userName, password);
     // --- LISTING DATABASE SCHEMA NAMES ---
     ResultSet resultSet = conn.getMetaData().getCatalogs();
     ResultSet resultSet1 = conn.getMetaData().getCatalogs();
     while (resultSet.next()) {
       System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
     }
     resultSet.close();
     // --- LISTING DATABASE TABLE NAMES ---
     String[] types = { "TABLE" };
     resultSet = conn.getMetaData()
         .getTables(databaseName, null, "%", types);
     DatabaseMetaData meta = conn.getMetaData();
     String tableName = "";
     while (resultSet.next()) {
         tableName = resultSet.getString(3);
         System.out.println("Table Name = " + tableName);
         resultSet1 = meta.getColumns(databaseName, null, tableName, "%");
         while (resultSet1.next()) {
        	 System.out.println("Column Name of table " + tableName + " = "
               + resultSet1.getString(4));
         }
       }
    
     // --- LISTING DATABASE COLUMN NAMES ---
     /*DatabaseMetaData meta = conn.getMetaData();
     resultSet = meta.getColumns(databaseName, null, tableName, "%");
     while (resultSet.next()) {
    	 System.out.println("Column Name of table " + tableName + " = "
           + resultSet.getString(4));
     }*/
     resultSet.close();
     resultSet1.close();
   }
}