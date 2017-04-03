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
      //System.out.println(c.updateItem(d.fetchItem(1)));
      /*ObservableList<Item> list = c.getItems();

      for (Item i : list) {
         System.out.println(i.getName());
      }

      for (int i = 1; i < 20; i++) {
         Item item = c.dataFetch(i);
         System.out.println(item);
      }*/
   }
}
