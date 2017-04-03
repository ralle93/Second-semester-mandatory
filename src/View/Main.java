package View;

import Controller.Controller;
import Controller.Item;
import Model.DataLayer;
import javafx.application.Application;
import javafx.collections.ObservableList;
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
     // testMethod();
      d = new DataLayer();
      c = new Controller(d);
      v = new View(c, primaryStage);
      c.connectDb();
      rasmusTest();

   }

   public void rasmusTest(){
      Item t = new Item(8,200, "Macbook", "Den er dyr");
      c.removeItemFromDb(t);

   }
}
