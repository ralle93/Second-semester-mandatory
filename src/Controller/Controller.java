package Controller;

import Model.DataLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Mikkel is primary contributor for this class
 */
public class Controller {
   private DataLayer d;
   private User loggedUser;

   public User getLoggedUser() {
      return loggedUser;
   }

   public void setLoggedUser(User user) {
      loggedUser = user;
   }

   public Controller(DataLayer dataLayer) {
      this.d = dataLayer;
   }

   public boolean verifyUser(String user, String pass) {
      User temp = d.fetchUser(user, pass);

      if (temp != null) {
         loggedUser = temp;
         return true;
      }

      return false;
   }
   public boolean createUser(User user){
      if(user != null){
         d.createUser(user);
         return true;
      }
      return false;
   }

   public boolean updateUser(User user){
      if(user!= null){
         d.updateUser(user);
         return true;
      }
      return false;
   }

   public boolean deleteUser(User user){
      if(user!= null){
         d.deleteUser(user);
         return true;
      }
      return false;
   }

   public void connectDb(){
      d.connectToDb();
   }

   public boolean updateItem(Item item){
      if(item != null) {
         d.update(item);
         return true;
      }
      return false;
   }

   public boolean addItemToDb(Item item){
      if(item != null){
         d.addItemToDB(item);
         return true;
      }
      return false;
   }

   public boolean removeItemFromDb(Item item){
      if(item != null){
         d.removeItemFromDb(item);
         return true;
      }
      return false;
   }

   public void closeConnection(){
      d.cleanUpEnviroment();
   }

   public ObservableList<Item> getItems() {
      ObservableList<Item> list = FXCollections.observableArrayList();
      list.addAll(d.fetchItems());

      return list;
   }
}