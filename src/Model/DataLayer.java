package Model;

import Controller.Item;

import java.sql.*;
/**
 *         ralle drengen arbejder her
 */
public class DataLayer {
   private Connection connection;
   private Statement stmt;
   private ResultSet rs;

   public void connectToDb(){
      final String dbURL = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8166696?useSSL=false";
      final String username = "sql8166696";
      final String password = "Lp7AZi7fVf";

      try {
         connection = DriverManager.getConnection(dbURL, username, password);

      } catch (SQLException e) {
         System.out.println(e);
      }
   }

   public void update(Item item){

   }

   public Item fetchItem(){
      Item t = new Item();


      return t;
   }

   public void cleanUpEnviroment(){}

   public boolean fetchUser(String user, String pass) {
      String query = "SELECT * FROM  login_data";

      try {
         stmt = connection.createStatement();

          rs = stmt.executeQuery(query);

         while(rs.next()){
            if (rs.getString(1).equals(user)) {
               if (rs.getString(2).equals(pass)) {
                  return true;
               }
            }
         }

      } catch (SQLException e) {
         System.out.println(e);
      }

      return false;
   }
}