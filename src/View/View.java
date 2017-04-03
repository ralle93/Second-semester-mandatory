package View;

import Controller.Controller;
import Controller.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
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
   private Scene loginScene = new Scene(vbox, 1280, 800);

   // Objects used in mainView
   private Label labelMainUserID = new Label();
   private Label labelMainUserName = new Label();
   private Label labelAccessLevel = new Label();
   private Button logoutButton = new Button("Logout");
   private Button mainQuitButton = new Button("Quit");
   private Button addButton = new Button("Add");
   private Button editButton = new Button("Edit");
   private Button deleteButton = new Button("Delete");
   private Button inventoryButton = new Button("Inventory");
   private Button userEdit = new Button("User Edit");
   private TextField searchField = new TextField();
   private TableView inventoryTable = new TableView<>();
   private HBox mainHBox = new HBox();
   private VBox mainTopVBox = new VBox();
   private VBox mainRightVBox = new VBox();
   private VBox mainLeftVBox = new VBox();
   private BorderPane borderpane = new BorderPane();
   private Scene mainScene = new Scene(borderpane, 1200, 800);

   View(Controller c, Stage stage) {
      this.c = c;

      this.primaryStage = stage;

      loginView();

      primaryStage.setTitle("Inventory Management version. 0.1");
      primaryStage.setScene(loginScene);
      primaryStage.show();
   }

   /**
    * Login View:
    * GUI setup for loginView.
    * @return loginScene
    */
   private Scene loginView() {

      quitButton.setOnAction(event -> primaryStage.close());

      userNameField.setPromptText("Username");
      passwordField.setPromptText("Password");

      userNameField.setText("mikk7506");
      passwordField.setText("12345");

      // TODO burde laves om til noget med bedre kode konvention
      loginButton.setOnAction(e -> {
         String user = userNameField.getText();
         String pass = passwordField.getText();

         if (c.verifyUser(user, pass)) {
            // TODO
            primaryStage.setScene(mainView());
            primaryStage.show();
         } else {
            System.out.println("login error");
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

   /**
    * Login View Style:
    * Style Loader for loginView, a helper method for that loads css styling for loginView
    */
   private void loginViewStyleLoader() {
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
    * Main View:
    * GUI setup for mainView.
    * @return mainScene
    */
   private Scene mainView() {

      TableColumn<Item, Integer> idColumn = new TableColumn("ITEM NUMBER");
      idColumn.setMinWidth(25);
      idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

      TableColumn<Item, Integer> quantityColumn = new TableColumn("QUANTITY");
      quantityColumn.setMinWidth(25);
      quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

      TableColumn<Item, String> nameColumn = new TableColumn("NAME");
      nameColumn.setMinWidth(100);
      nameColumn.setCellValueFactory(new PropertyValueFactory("name"));

      TableColumn<Item, String> descriptionColumn = new TableColumn("DESCRIPTION");
      descriptionColumn.setMinWidth(500);
      descriptionColumn.setCellValueFactory(new PropertyValueFactory("description"));

      inventoryTable.setPadding(new Insets(10,10,10,10));
      inventoryTable.setItems(c.getItems());
      inventoryTable.getColumns().addAll(idColumn, quantityColumn, nameColumn, descriptionColumn);

      search();

      // Does not work yet.
      logoutButton.setOnAction(event -> {
         primaryStage.setScene(loginView());
         primaryStage.show();
      });

      mainQuitButton.setOnAction(evente -> primaryStage.close());

      searchField.setPromptText("Search");

      mainHBox.setAlignment(Pos.TOP_CENTER);
      mainHBox.getChildren().add(labelMainUserID);
      mainHBox.getChildren().add(getCurrentUserName());
      mainHBox.getChildren().add(labelAccessLevel);

      mainTopVBox.setAlignment(Pos.TOP_CENTER);
      mainTopVBox.setSpacing(10);
      mainTopVBox.setPadding(new Insets(10,10,10,10));
      mainTopVBox.getChildren().add(mainHBox);
      mainTopVBox.getChildren().add(searchField);

      mainRightVBox.getChildren().add(addButton);
      mainRightVBox.getChildren().add(editButton);
      mainRightVBox.getChildren().add(deleteButton);

      mainLeftVBox.getChildren().add(inventoryButton);
      mainLeftVBox.getChildren().add(userEdit);
      mainLeftVBox.getChildren().add(logoutButton);
      mainLeftVBox.getChildren().add(mainQuitButton);

      borderpane.setRight(mainRightVBox);
      borderpane.setLeft(mainLeftVBox);
      borderpane.setTop(mainTopVBox);
      borderpane.setCenter(inventoryTable);

      mainViewStyleLoader();

      return mainScene;
    }

   /**
    * Main View Style:
    * Style Loader for mainView, a helper method for that loads css styling for mainView
    */
   private void mainViewStyleLoader() {
      Style.styleBorderPane(borderpane);
      Style.styleMainVBox(mainLeftVBox);
      Style.styleMainVBox(mainRightVBox);
      Style.styleMainHBox(mainHBox);
      Style.styleMainSearchField(searchField);
      Style.styleButtonForMainView(logoutButton);
      Style.styleButtonForMainView(mainQuitButton);
      Style.styleButtonForMainView(userEdit);
      Style.styleButtonForMainView(inventoryButton);
      Style.styleButtonForMainView(addButton);
      Style.styleButtonForMainView(editButton);
      Style.styleButtonForMainView(deleteButton);
      Style.styleTableView(inventoryTable);
   }

   private void search() {
      // Search
      searchField.setOnKeyPressed(e -> {
         if (e.getCode().equals(KeyCode.ENTER)) {
            ObservableList<Item> list = c.getItems();
            ObservableList<Item> searchResults = FXCollections.observableArrayList();
            String searchStr = searchField.getText().toLowerCase();

            for (Item i : list) {
               if (i.getName().toLowerCase().contains(searchStr)) {
                  searchResults.add(i);
               } else if (i.getDescription().toLowerCase().contains(searchStr)) {
                  searchResults.add(i);
               } else if (Integer.toString(i.getId()).contains(searchStr)) {
                  searchResults.add(i);
               }
            }

            inventoryTable.setItems(searchResults);
         }
      });

      searchField.lengthProperty().addListener((observable, oldValue, newValue) -> {
         if (searchField.getText().equals(null) || searchField.getText().length() == 0) {
            inventoryTable.setItems(c.getItems());
         }
      });
   }

   public Label getCurrentUserID() {
      return labelMainUserID;
   }

   public Label getCurrentUserName() {
      String user = userNameField.getText();
      labelMainUserName.setText(user);
      return labelMainUserName;
   }

   public Label getCurrentUserAccessLevel() {
      return labelAccessLevel;
   }
}