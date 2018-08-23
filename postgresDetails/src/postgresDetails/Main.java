package postgresDetails;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {
  private static final String DRIVER = "org.postgresql.Driver";

  private static final String URL = "jdbc:postgresql://localhost:5432/rapidhana";

  private static final String USERNAME = "rapidhana";

  private static final String PASSWORD = "Rolta2k14";

  public static void main(String[] args) throws Exception {
    Class.forName(DRIVER);
    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

   /* DatabaseMetaData metadata = connection.getMetaData();
    
  //  ResultSet resultSet = metadata.getColumns(null, null, "users", null);
    ResultSet resultSet = metadata.getTables(null, null, "ac", null);
    while (resultSet.next()) {
      String name = resultSet.getString("COLUMN_NAME");
      String type = resultSet.getString("TYPE_NAME");
      int size = resultSet.getInt("COLUMN_SIZE");

      System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
    }*/
    connection.close();
  }
}