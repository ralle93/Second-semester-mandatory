package Model;

import Controller.Item;
import Controller.User;

import java.sql.*;
import java.util.ArrayList;

/**
 *         ralle drengen arbejder her
 */
public class DataLayer {
   private Connection connection;
   private Statement stmt;
   private ResultSet rs;
   private final String dbURL = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8166696?useSSL=false";
   private final String username = "sql8166696";
   private final String password = "Lp7AZi7fVf";

   public DataLayer(){}

   public void connectToDb(){
      try {
         connection = DriverManager.getConnection(dbURL, username, password);
         if(connection != null){
            System.out.println("Database is now connected!");
         }
      } catch (SQLException e) {
         System.out.println(e);
      }
   }

   public void addItemToDB(Item item){
      String query ="INSERT INTO inventory (quantity, name, description) \n";
      query += "VALUES (" + item.getQuantity() + ", '" + item.getName() + "', '" + item.getDescription() + "');";
      try{
         stmt = connection.createStatement();
         stmt.executeUpdate(query);

      }catch(SQLException e){
         System.out.println(e);
      }
   }

   public void removeItemFromDb(Item item){
      String query = "DELETE FROM inventory \n";
      query += "WHERE id = " + item.getId() +";";
      try{
         stmt = connection.createStatement();
         stmt.executeUpdate(query);

      }catch(SQLException e){
         System.out.println(e);
      }
   }

   public void update(Item item){
      String query = "UPDATE inventory ";
      query += "SET quantity = " + item.getQuantity() + ", ";
      query += "name = '" + item.getName() + "', ";
      query += "description = '" + item.getDescription() + "' \n";
      query += "WHERE id = " + item.getId() + ";";
      try{
         stmt = connection.createStatement();
         stmt.executeUpdate(query);

      }catch(SQLException e){
         System.out.println(e);
      }
   }

   public ArrayList<Item> fetchItems(){
      ArrayList<Item> items = new ArrayList<>();
      String query = "SELECT * from sql8166696.inventory";
      String name;
      int id;
      String description;
      int quantity;
      Item t;
      try{
         stmt = connection.createStatement();
         rs = stmt.executeQuery(query);

         while(rs.next()){
            id = rs.getInt(1);
            quantity = rs.getInt(2);
            name = rs.getString(3);
            description = rs.getString(4);
            t = new Item(id,quantity,name,description);
            items.add(t);
         }
      }catch(SQLException e){
         System.out.println(e);
      }
      return items;
   }

   public void cleanUpEnviroment(){
     try{
        if(connection!= null){
           connection.close();
        }
        if(stmt != null){
           stmt.close();
        }
        if(rs!=null){
           rs.close();
        }
     }catch(SQLException e){
        System.out.println(e);
     }
   }

   public User fetchUser(String user, String pass) {
      String query = "SELECT * FROM  login_data";

      try {
         stmt = connection.createStatement();
         rs = stmt.executeQuery(query);

         while(rs.next()){
            if (rs.getString(1).equals(user)) {
               if (rs.getString(2).equals(pass)) {
                  User temp = new User();

                  temp.setAccessLevel(rs.getInt(3));
                  temp.setUsername(rs.getString(1));
                  temp.setPassword(rs.getString(2));
                  temp.setEmail(rs.getString(4));

                  return temp;
               }
            }
         }
      }
      catch (SQLException e) {
         System.out.println(e);
      }

      return null;
   }
}