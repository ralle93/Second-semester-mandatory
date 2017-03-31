package Model;

import java.sql.*;

/**
 * Created by rasmusthrane on 31/03/17.
 */
public class DataLayer {

   public void connectToDb(){
      String dbURL = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8166696?useSSL=false";
      String username = "sql8166696";
      String password = "Lp7AZi7fVf";

      String query = "SELECT * FROM  loginform";

      try {
         Connection connection = DriverManager.getConnection(dbURL, username, password);


         System.out.println(connection);
      } catch (SQLException e) {
         System.out.println(e);
      }
   }
}
