package Model;

import java.sql.*;

/**
 *         ralle drengen arbejder her
 */
public class DataLayer {

   public void connectToDb(){
      String dbURL = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8166696?useSSL=false";
      String username = "sql8166696";
      String password = "Lp7AZi7fVf";

      try {
         Connection connection = DriverManager.getConnection(dbURL, username, password);

         Statement stmt = connection.createStatement();

      } catch (SQLException e) {
         System.out.println(e);
      }
   }


}
