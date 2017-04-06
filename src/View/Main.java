package View;

import Controller.Controller;
import Model.DataLayer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Mikkel is primary contributor for this class
 */
public class Main extends Application{
   private DataLayer d;
   private Controller c;
   private View v;

   public static void main(String[] args) {
      launch();
   }

   public void start(Stage primaryStage) {
      d = new DataLayer();
      c = new Controller(d);
      v = new View(c, primaryStage);
      c.connectDb();
   }
}
