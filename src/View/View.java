package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Tommy is primary contributor for this class.
 */
public class View {
   private Controller c;

   View(Controller c) {
      this.c = c;
   }

    Stage primaryStage = new Stage();

    // Constructer for View
    public View(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Inventory Management version. 0.01");
        primaryStage.setScene(mainView());
        primaryStage.show();
    }

    // GUI for login Screen.
    public Scene loginView() {
        Label loginLabel = new Label("LOGIN");
        Label userIdLabel = new Label("User ID:");
        Label userPassword = new Label("User Password");
        Button quitButton = new Button("Quit");
        Button loginButton = new Button("Login");

        TextField userNameField = new TextField();
        userNameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();

        // TODO burde laves om til noget med bedre kode konvention
        loginButton.setOnAction(e -> {
           String user = userNameField.getText();
           String pass = passwordField.getText();

           if (c.verifyUser(user, pass)) {
              // TODO
           }
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(userIdLabel, 0, 0);
        gridPane.add(userNameField, 1, 0);
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

        Style.styleLoginVBox(vbox);

        Scene loginScene = new Scene(vbox, 1000, 800);
        return loginScene;
    }

    // GUI for main program view.
    public Scene mainView() {
        Button logoutButton = new Button("Logout");
        Button quitButton = new Button("Quit");
        Button addButton = new Button("Add");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button inventoryButton = new Button("Inventory");
        Button userEdit = new Button("User Edit");

        TableView inventoryTable = new TableView();

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(addButton);
        hbox.getChildren().add(editButton);
        hbox.getChildren().add(deleteButton);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().add(inventoryButton);
        vbox.getChildren().add(userEdit);
        vbox.getChildren().add(logoutButton);
        vbox.getChildren().add(quitButton);

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(hbox);
        borderpane.setLeft(vbox);
        borderpane.setCenter(inventoryTable);

        Scene mainScene = new Scene(borderpane, 1000, 800);
        return mainScene;
    }
}