package Controller;

import Model.DataLayer;

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

   public void connectdb(){
      d.connectToDb();
   }

   public void dataFetch(int index){
      d.fetchItem(index);
   }
}