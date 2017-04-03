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

   private Button logoutButton = new Button("Logout");
   private Button mainQuitButton = new Button("Quit");
   private Button addButton = new Button("Add");
   private Button editButton = new Button("Edit");
   private Button deleteButton = new Button("Delete");
   private Button inventoryButton = new Button("Inventory");
   private Button userEdit = new Button("User Edit");
   private TableView inventoryTable = new TableView();
   private HBox mainHBox = new HBox();
   private VBox mainVBox = new VBox();
   private BorderPane borderpane = new BorderPane();
   private Scene mainScene = new Scene(borderpane, 1000, 800);

   View(Controller c) {
      this.c = c;
   }

   // Constructer for View
   public View(Stage primaryStage) {
       this.primaryStage = primaryStage;

       primaryStage.setTitle("Inventory Management version. 0.01");
       primaryStage.setScene(mainView());
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

        loginViewStyleLoader();

        return loginScene;
    }

    public void loginViewStyleLoader() {
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


    /**
     * Main View Styles
     */

    // GUI for main program view.
    public Scene mainView() {

        mainHBox.setAlignment(Pos.CENTER);
        mainHBox.getChildren().add(addButton);
        mainHBox.getChildren().add(editButton);
        mainHBox.getChildren().add(deleteButton);

        mainVBox.setSpacing(10);
        mainVBox.setAlignment(Pos.BOTTOM_CENTER);
        mainVBox.getChildren().add(inventoryButton);
        mainVBox.getChildren().add(userEdit);
        mainVBox.getChildren().add(logoutButton);
        mainVBox.getChildren().add(mainQuitButton);

        borderpane.setTop(mainHBox);
        borderpane.setLeft(mainVBox);
        borderpane.setCenter(inventoryTable);

        mainViewStyleLoader();

        return mainScene;
    }

    public void mainViewStyleLoader() {
        Style.styleBorderPane(borderpane);
        Style.styleMainVBox(mainVBox);
        Style.styleMainHBox(mainHBox);
        Style.styleButtonForMainView(logoutButton);
        Style.styleButtonForMainView(mainQuitButton);
        Style.styleButtonForMainView(userEdit);
        Style.styleButtonForMainView(inventoryButton);
        Style.styleButtonForMainView(addButton);
        Style.styleButtonForMainView(editButton);
        Style.styleButtonForMainView(deleteButton);
        Style.styleTableView(inventoryTable);
    }

}