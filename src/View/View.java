package View;

import Controller.Controller;
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

   private Stage primaryStage = new Stage();

   // Objects used in loginView
   private Label loginLabel = new Label("LOGIN");
   private Label userIdLabel = new Label("Username:");
   private Label userPassword = new Label("User Password:");
   private Button quitButton = new Button("Quit");
   private Button loginButton = new Button("Login");
   private TextField userNameField = new TextField();
   private PasswordField passwordField = new PasswordField();
   private GridPane gridPane = new GridPane();
   private HBox hbox = new HBox();
   private VBox vbox = new VBox();
   private Scene loginScene = new Scene(vbox, 1000, 800);

   View(Controller c) {
      this.c = c;
   }

   // Constructer for View
   public View(Stage primaryStage) {
       this.primaryStage = primaryStage;

       primaryStage.setTitle("Inventory Management version. 0.01");
       primaryStage.setScene(loginView());
       primaryStage.show();
   }

   // GUI for login Screen.
   public Scene loginView() {

        userNameField.setPromptText("Username");
        passwordField.setPromptText("Password");

        // TODO burde laves om til noget med bedre kode konvention
        loginButton.setOnAction(e -> {
           String user = userNameField.getText();
           String pass = passwordField.getText();

           if (c.verifyUser(user, pass)) {
              // TODO
               primaryStage.setScene(mainView());
           }
        });

        gridPane.add(userIdLabel, 0, 0);
        gridPane.add(userNameField, 1, 0);
        gridPane.add(userPassword, 0,1);
        gridPane.add(passwordField, 1,1);

        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(quitButton);
        hbox.getChildren().add(loginButton);

        vbox.getChildren().add(loginLabel);
        vbox.getChildren().add(gridPane);
        vbox.getChildren().add(hbox);

        loginViewStyle();

        return loginScene;
    }

    public void loginViewStyle() {
        Style.styleLoginVBox(vbox);
        Style.styleLoginHBox(hbox);
        Style.styleloginGrid(gridPane);
        Style.styleloginTitleLabel(loginLabel);
        Style.styleloginLabel(userIdLabel);
        Style.styleloginLabel(userPassword);
        Style.styleButtons(loginButton);
        Style.styleButtons(quitButton);
        Style.styleTextfield(userNameField);
        Style.stylePasswordField(passwordField);
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