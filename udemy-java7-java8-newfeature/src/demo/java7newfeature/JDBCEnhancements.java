package demo.java7newfeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCEnhancements {
  public static void main(String[] args) throws Exception {
    viewResults();
    createJdbcRowset();
  }

  private static void viewResults() throws Exception {
    final String url = "jdbc:postgresql://localhost:5432/comado";
    final String user = "comado";
    final String password = "comado";
    try {
      Class.forName("org.postgresql.Driver");
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM \"PUBLIC\".r_instructors");
      while (rs.next()) {

      }
    } catch (Exception e) {
      throw e;
    }
  }

  private static void createJdbcRowset() {
  }
}
