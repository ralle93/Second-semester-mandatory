package Model;

import Controller.Item;

import java.sql.*;
/**
 *         ralle drengen arbejder her
 */
public class DataLayer {

   public void connectToDb(){
      final String dbURL = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8166696?useSSL=false";
      final String username = "sql8166696";
      final String password = "Lp7AZi7fVf";

      try {
         Connection connection = DriverManager.getConnection(dbURL, username, password);

      } catch (SQLException e) {
         System.out.println(e);
      }
   }

   public void update(Item item){

   }

   public Item fetch(){
      Item t = new Item();


      return t;

   }


}
