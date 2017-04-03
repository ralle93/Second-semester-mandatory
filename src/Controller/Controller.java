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

   public void dataFetch(int index){
      d.fetchItem(index);
   }

   public boolean updateItem(Item item){
      if(item != null) {
         d.update(item);
         return true;
      }
      return false;
   }

   public ObservableList<Item> getItems() {
      Item temp = new Item();
      ObservableList<Item> list = FXCollections.observableArrayList();
      int i = 1;

      while (temp != null) {
         temp = dataFetch(i);
      }

      return list;
   }
}