import Controller.Controller;
import Model.DataLayer;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Mikkel is primary contributor for this class
 */
public class Main extends Application{

   public static void main(String[] args) {
      launch();
   }

   public void start(Stage primaryStage) {
      //testShit();
      DataLayer d = new DataLayer();
      Controller c = new Controller(d);
      d.connectToDb();

      primaryStage.setTitle("Inventory Management version. 0.01");
      primaryStage.setScene(View.mainView());
      primaryStage.show();
   }

   public void testShit() {
      DataLayer d = new DataLayer();
      d.connectToDb();
      Controller c = new Controller(d);

      System.out.println(c.verifyUser("mikk7506", "12345"));
      System.out.println(c.verifyUser("mikk7506","1234"));
   }
}
