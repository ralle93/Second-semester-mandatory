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
   public View v;

   public static void main(String[] args) {
      launch();
   }

   public void start(Stage primaryStage) {
      d = new DataLayer();
      c = new Controller(d);
      v = new View(c, primaryStage);
      c.connectDb();
      rasmusTest();
   }

   // TODO This has to be removed on completion
   public void testMethod() {
      DataLayer d = new DataLayer();
      d.connectToDb();
      Controller c = new Controller(d);

      System.out.println(c.verifyUser("mikk7506", "12345"));
      System.out.println(c.verifyUser("mikk7506","1234"));
   }

   // TODO This has to be removed on completion
   public void rasmusTest(){
   }
}
