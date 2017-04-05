package View;

import Controller.Controller;
import Controller.Item;
import Controller.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;

/**
 * Tommy is primary contributor for this class.
 */
public class View {
   private Controller c;

   private Stage primaryStage = new Stage();

   // Objects used in loginView
   private Label loginLabel = new Label();
   private Label userIdLabel = new Label("Username:");
   private Label userPassword = new Label("User Password:");
   private Button quitButton = new Button();
   private Button loginButton = new Button("Login");
   private TextField userNameField = new TextField();
   private PasswordField passwordField = new PasswordField();
   private GridPane gridPane = new GridPane();
   private HBox loginHBox = new HBox();
   private VBox loginVBox = new VBox();
   private Scene loginScene = new Scene(getloginVBox(), 1300, 900);

   // Objects used in mainView
   private Label labelMainUserEmaiL = new Label();
   private Label labelMainUserName = new Label();
   private Label labelAccessLevel = new Label();
   private Label uniqueItems = new Label();
   private Label totalQuantity = new Label();
   private Label addQuantityLabel = new Label("Quantity");
   private Label addNameLabel = new Label("Name:");
   private Label addDescriptionLabel = new Label("Description:");
   private Button logoutButton = new Button("Logout");
   private Button mainQuitButton = new Button("Quit");
   private Button addButton = new Button("Add");
   private Button editButton = new Button("Edit");
   private Button deleteButton = new Button("Delete");
   private Button inventoryButton = new Button("Inventory");
   private Button userEdit = new Button("User Edit");
   private Button applyButton = new Button("Apply");
   private Button cancelButton = new Button("Cancel");
   private TextField searchField = new TextField();
   private TextField addName = new TextField();
   private TextField addQuantity = new TextField();
   private TextField addDescription = new TextField();
   private TableView inventoryTable = new TableView<>();
   private TableView userTable = new TableView<>();
   private HBox mainHBox = new HBox();
   private HBox mainHBoxAdd = new HBox();
   private HBox mainBottomHBox = new HBox();
   private VBox mainTopVBox = new VBox();
   private VBox mainRightVBox = new VBox();
   private VBox mainLeftVBox = new VBox();
   private VBox mainCenterVBox = new VBox();
   private BorderPane borderpane = new BorderPane();
   private Scene mainScene = new Scene(borderpane, 1300, 900);

   // Constructor for View class
   View(Controller c, Stage stage) {
      this.c = c;

      this.primaryStage = stage;

      loginView();

      primaryStage.setTitle("Inventory Management version. 0.1");
      primaryStage.setScene(loginScene);
      primaryStage.show();
   }

   // load CSS from a stylesheet.
   private Scene loadCSS(Scene scene) {
      scene.getStylesheets().add("/View/stylesheet.css");
      return scene;
   }

   // Get method for login label.
   private Label getLoginLabel() {
      loginLabel.setId("login_login_label");
      loginLabel.setText("Login");
      return loginLabel;
   }

   // Get method for quit button in login View.
   private Button getQuitButton() {
      quitButton.setId("login_quit_button");
      quitButton.setText("Quit");
      quitButton.setOnAction(event -> {
         primaryStage.close();
         c.closeConnection();
      });
      return quitButton;
   }

   // Get method for Login button in login view
   private Button getLoginButton() {
      loginButton.setId("login_login_button");
      loginButton.setText("Login");
      loginButton.setOnAction(e -> {
         String user = userNameField.getText();
         String pass = passwordField.getText();

         if (c.verifyUser(user, pass)) {
            mainHBox.getChildren().clear();
            mainHBoxAdd.getChildren().clear();
            mainBottomHBox.getChildren().clear();
            mainTopVBox.getChildren().clear();
            mainRightVBox.getChildren().clear();
            mainLeftVBox.getChildren().clear();
            mainCenterVBox.getChildren().clear();
            borderpane.getChildren().clear();

            primaryStage.setScene(mainView());
            primaryStage.show();
         } else {
            System.out.println("login error");
         }
      });
      return loginButton;
   }

   // Get method for login gridpane.
   private GridPane getLoginGridPane() {
      gridPane.setId("login_gridpane");
      gridPane.add(userIdLabel, 0, 0);
      gridPane.add(userNameField, 1, 0);
      gridPane.add(userPassword, 0,1);
      gridPane.add(passwordField, 1,1);
      return gridPane;
   }

   // Get method for loginHBox.
   private HBox getloginHbox() {
      loginHBox.setId("login_hbox");
      loginHBox.setAlignment(Pos.CENTER);
      loginHBox.getChildren().add(getQuitButton());
      loginHBox.getChildren().add(getLoginButton());
      return loginHBox;
   }

   // Get method for loginVBox.
   private VBox getloginVBox() {
      loginVBox.setId("login_vbox");
      loginVBox.getChildren().add(getLoginLabel());
      loginVBox.getChildren().add(getLoginGridPane());
      loginVBox.getChildren().add(getloginHbox());
      return loginVBox;
   }

   // Get method for loginView returns login scene.
   private Scene loginView() {

      loadCSS(loginScene);

      userNameField.setPromptText("Username");
      passwordField.setPromptText("Password");

      // TODO: Only used for testing purposes needs to be deleted at completion
      userNameField.setText("mikk7506");
      passwordField.setText("12345");

      return loginScene;
   }

   /**
    * Main View:
    * GUI setup for mainView.
    * @return mainScene
    */
   private Scene mainView() {

      loadCSS(mainScene);

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
      ObservableList<Item> itemList = c.getItems();
      inventoryTable.setItems(itemList);
      inventoryTable.getColumns().addAll(idColumn, quantityColumn, nameColumn, descriptionColumn);

      userTable = loadUserTable();

      uniqueItems.setText("Unique items: " + NumberFormat.getIntegerInstance().format(itemList.size()));
      int total = 0;
      for (Item i : itemList) {
         total += i.getQuantity();
      }
      totalQuantity.setText("Total quantity: " + NumberFormat.getIntegerInstance().format(total));

      search();

      logoutButton.setOnAction(event -> {
         gridPane.getChildren().clear();
         loginHBox.getChildren().clear();
         loginVBox.getChildren().clear();

         c.setLoggedUser(null);
         primaryStage.setScene(loginView());
         primaryStage.show();
      });

      mainQuitButton.setOnAction(e -> {
         primaryStage.close();
         c.closeConnection();
      });

      primaryStage.setOnCloseRequest(e -> c.closeConnection());

      searchField.setPromptText("Search");

      addButton.setOnAction(event -> {
         addQuantity.setText("");
         addName.setText("");
         addDescription.setText("");

         mainCenterVBox.getChildren().add(mainHBoxAdd);
         addMenuBox(mainHBoxAdd);
      });

      applyButton.setOnAction(event -> {
         try {
            int quantity = Integer.parseInt(addQuantity.getText());
            String name = addName.getText();
            String description = addDescription.getText();
            Item item = new Item(quantity, name, description);
            c.addItemToDb(item);

            mainCenterVBox.getChildren().remove(mainHBoxAdd);
         } catch (NumberFormatException ex) {
            System.out.println("You need to enter an integer you noob!");
         }
      });

      cancelButton.setOnAction(event -> {
         mainCenterVBox.getChildren().remove(mainHBoxAdd);
      });

      mainHBox.setAlignment(Pos.TOP_CENTER);
      mainHBox.getChildren().add(getCurrentUserName());
      mainHBox.getChildren().add(getCurrentUserAccessLevel());

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

      mainCenterVBox.getChildren().add(inventoryTable);

      mainBottomHBox.getChildren().add(uniqueItems);
      mainBottomHBox.getChildren().add(totalQuantity);

      borderpane.setRight(mainRightVBox);
      borderpane.setLeft(mainLeftVBox);
      borderpane.setTop(mainTopVBox);
      borderpane.setCenter(mainCenterVBox);
      borderpane.setBottom(mainBottomHBox);

      //mainViewStyleLoader();

      inventoryButton.setOnAction(e -> {
         mainCenterVBox.getChildren().clear();
         mainCenterVBox.getChildren().add(inventoryTable);
      });

      userEdit.setOnAction(e -> {
         mainCenterVBox.getChildren().clear();
         mainCenterVBox.getChildren().add(userTable);
      });

      return mainScene;
    }

    private TableView loadUserTable() {
       TableView temp = new TableView();

       TableColumn<User, String> userColumn = new TableColumn("USERNAME");
       userColumn.setMinWidth(25);
       userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

       TableColumn<User, String> passColumn = new TableColumn("PASSWORD");
       passColumn.setMinWidth(25);
       passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

       TableColumn<User, Integer> accessColumn = new TableColumn("ACCESS LEVEL");
       accessColumn.setMinWidth(100);
       accessColumn.setCellValueFactory(new PropertyValueFactory("acces_lvl"));

       TableColumn<User, String> eMailColumn = new TableColumn("EMAIL ADDRESS");
       eMailColumn.setMinWidth(500);
       eMailColumn.setCellValueFactory(new PropertyValueFactory("email"));

       temp.setPadding(new Insets(10,10,10,10));
       ObservableList<User> userList = c.getUsers();
       temp.setItems(userList);
       temp.getColumns().addAll(userColumn, passColumn, accessColumn, eMailColumn);

       return temp;
    }

   /**
    * Main View Style:
    * Style Loader for mainView, a helper method for that loads css styling for mainView
    */
   /*
   private void mainViewStyleLoader() {
      Style.styleBorderPane(borderpane);
      Style.styleMainVBox(mainLeftVBox);
      Style.styleMainVBox(mainRightVBox);
      Style.styleMainHBox(mainHBox, labelMainUserName, labelAccessLevel);
      Style.styleMainSearchField(searchField);
      Style.styleButtonForMainView(logoutButton);
      Style.styleButtonForMainView(mainQuitButton);
      Style.styleButtonForMainView(userEdit);
      Style.styleButtonForMainView(inventoryButton);
      Style.styleButtonForMainView(addButton);
      Style.styleButtonForMainView(editButton);
      Style.styleButtonForMainView(deleteButton);
      Style.styleTableView(inventoryTable);
      Style.styleTableView(userTable);
      Style.styleMainBottomHBox(mainBottomHBox);
      Style.styleloginLabel(uniqueItems);
      Style.styleloginLabel(totalQuantity);
      Style.styleMainAddBox(mainHBoxAdd, mainCenterVBox);
      Style.styleTextfield(addQuantity);
      Style.styleTextfield(addName);
      Style.styleTextfield(addDescription);
      Style.styleButtons(applyButton);
      Style.styleButtons(cancelButton);
      Style.styleloginLabel(addNameLabel);
      Style.styleloginLabel(addQuantityLabel);
      Style.styleloginLabel(addDescriptionLabel);
   }
   */

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

   public Label getCurrentUserEmail() {
      return labelMainUserEmaiL;
   }

   public Label getCurrentUserName() {
      String user = userNameField.getText();
      labelMainUserName.setText("Current User: " + user);
      return labelMainUserName;
   }

   public Label getCurrentUserAccessLevel() {
      labelAccessLevel.setText("Access Level: ");
      return labelAccessLevel;
   }

   public void addMenuBox(HBox hbox) {
      addQuantity.setMinWidth(50);
      addQuantity.setMaxWidth(50);
      hbox.getChildren().add(addQuantityLabel);
      hbox.getChildren().add(addQuantity);
      hbox.getChildren().add(addNameLabel);
      hbox.getChildren().add(addName);
      hbox.getChildren().add(addDescriptionLabel);
      hbox.getChildren().add(addDescription);
      hbox.getChildren().add(applyButton);
      hbox.getChildren().add(cancelButton);
   }
}