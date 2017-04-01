package View;

import Controller.Controller;
import Model.DataLayer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Mikkel is primary contributor for this class
 */
public class Main extends Application{
   public DataLayer d;
   public Controller c;

   public static void main(String[] args) {
      launch();
   }

   public void start(Stage primaryStage) {
      //testMethod();
      d = new DataLayer();
      c = new Controller(d);
      d.connectToDb();

      View view = new View(primaryStage);
   }

   public void testMethod() {
      DataLayer d = new DataLayer();
      d.connectToDb();
      Controller c = new Controller(d);

      System.out.println(c.verifyUser("mikk7506", "12345"));
      System.out.println(c.verifyUser("mikk7506","1234"));
   }
}
