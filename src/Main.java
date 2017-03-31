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
      DataLayer d = new DataLayer();

      d.connectToDb();

      primaryStage.setTitle("Inventory");
      primaryStage.setScene(View.loginView());
      primaryStage.show();
   }
}
