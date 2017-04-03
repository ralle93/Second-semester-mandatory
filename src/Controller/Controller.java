package Controller;

import Model.DataLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Mikkel is primary contributor for this class
 */
public class Controller {
   private DataLayer d;
   private User loggedUser;

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

   public void connectDb(){
      d.connectToDb();
   }

   public Item dataFetch(int index){
      return d.fetchItem(index);
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

   public ObservableList<Item> getItems() {
      ObservableList<Item> list = FXCollections.observableArrayList();
      int i = 1;
      Item temp = dataFetch(i);

      while (temp != null) {
         list.add(temp);
         i++;
         temp = dataFetch(i);
      }

      return list;
   }
}