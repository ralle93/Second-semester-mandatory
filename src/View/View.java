package View;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Tommy is primary contributor for this class.
 */
public class View {

    public static Scene loginView() {
        VBox vbox = new VBox();
        Scene loginScene = new Scene(vbox, 1000, 800);
        return loginScene;
    }

    public static Scene mainView() {
        BorderPane borderpane = new BorderPane();
        Scene mainScene = new Scene(borderpane, 1000, 800);
        return mainScene;
    }

    public static void inventoryView() {

    }



}
