package Controller;

import Model.DataLayer;

/**
 * Mikkel is primary contributor for this class
 */
public class Controller {
   private DataLayer d;

   public boolean verifyUser(String user, String pass) {
      return d.fetchUser(user, pass);
   }
}