package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Tommy is primary contributor for this class.
 */
public class View {

    public static Scene loginView() {
        Label loginLabel = new Label("LOGIN");
        Label userIdLabel = new Label("User ID:");
        Label userPassword = new Label("User Password");
        Button quitButton = new Button("Quit");
        Button loginButton = new Button("Login");

        TextField userIdField = new TextField();
        PasswordField passwordField = new PasswordField();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(userIdLabel, 0, 0);
        gridPane.add(userIdField, 1, 0);
        gridPane.add(userPassword, 0,1);
        gridPane.add(passwordField, 1,1);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(quitButton);
        hbox.getChildren().add(loginButton);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(25);
        vbox.getChildren().add(loginLabel);
        vbox.getChildren().add(gridPane);
        vbox.getChildren().add(hbox);
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
