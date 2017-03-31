package Model;

import Controller.Item;

import java.sql.*;
/**
 *         ralle drengen arbejder her
 */
public class DataLayer {
   private Connection connection;

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

   public static boolean fetchUser(String user, String pass) {
      return true;
   }


}

/*
package mysqlPractice;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.*;
import java.util.Calendar;

/**
 * Created by rasmusthrane on 12/01/17.

public class sqltest {


   public static void main(String[] args) {
      String dbURL = "jdbc:mysql://localhost:3306/database?useSSL=false";
      String username = "root";
      String password = "kun4cj";

      String query = "SELECT * FROM  loginform";

      try {
         Connection connection = DriverManager.getConnection(dbURL, username, password);

         Calendar calender = Calendar.getInstance();
         java.sql.Date startDate = new java.sql.Date(calender.getTime().getTime());

         Statement stmt = connection.createStatement();

         ResultSet rs = stmt.executeQuery(query);
         System.out.println(rs.toString());
         while(rs.next()){
            String usern = rs.getObject(1).toString();
            String pass = rs.getObject(2).toString();

            System.out.println("username = " + usern + "  password = " + pass);

         }

         connection.close();

      } catch (SQLException e) {
         System.out.println(e);
      }
   }
}



 */