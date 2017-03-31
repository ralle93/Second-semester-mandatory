package Controller;

import Model.DataLayer;

/**
 * Mikkel is primary contributor for this class
 */
public class Controller {
   boolean verifyUser(String user, String pass) {
      return DataLayer.fetchUser(user, pass);
   }
}