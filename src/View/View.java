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
class View {
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
   private Scene loginScene = new Scene(getloginVBox(), 1280, 720);

   // Objects used in mainView
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
   private VBox addMenuVBox = new VBox();
   private BorderPane borderpane = new BorderPane();
   private Scene mainScene = new Scene(borderpane, 1280, 720);

   private boolean isEditing = false;
   private Item selectedItem;

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
   private void loadCSS(Scene scene) {
      scene.getStylesheets().add("/View/stylesheet.css");
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

   /********************************************************************************************************************
    * MAIN VIEW RELATED METHODS STARTS HERE:
    *******************************************************************************************************************/

   // Get method for show the username of the currently logged in user.
   private Label getCurrentUserName() {
      String user = userNameField.getText();
      labelMainUserName.setId("main_current_user_label");
      labelMainUserName.setText("Current User: " + user);
      return labelMainUserName;
   }

   // Get method for show what level a user has.
   private Label getCurrentUserAccessLevel() {
      labelAccessLevel.setId("main_current_user_access_level_label");
      labelAccessLevel.setText("Access Level: ");
      return labelAccessLevel;
   }

   // Method for updating the inventory table
   private void updateTable() {
      ObservableList<Item> items = c.getItems();
      inventoryTable.setItems(items);

      uniqueItems.setText("Unique items: " + NumberFormat.getIntegerInstance().format(items.size()));
      int total = 0;
      for (Item i : items) {
         total += i.getQuantity();
      }
      totalQuantity.setText("Total quantity: " + NumberFormat.getIntegerInstance().format(total));
   }

   // Get method for inventory Table.
   private void getInventoryTable() {
      inventoryTable.setId("inventory_table");

      TableColumn<Item, Integer> idColumn = new TableColumn("ITEM NUMBER");
      idColumn.setMinWidth(150);
      idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

      TableColumn<Item, Integer> quantityColumn = new TableColumn("QUANTITY");
      quantityColumn.setMinWidth(100);
      quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

      TableColumn<Item, String> nameColumn = new TableColumn("NAME");
      nameColumn.setMinWidth(100);
      nameColumn.setCellValueFactory(new PropertyValueFactory("name"));

      TableColumn<Item, String> descriptionColumn = new TableColumn("DESCRIPTION");
      descriptionColumn.setMinWidth(450);
      descriptionColumn.setCellValueFactory(new PropertyValueFactory("description"));

      inventoryTable.setPadding(new Insets(10,10,10,10));

      updateTable();
      inventoryTable.getColumns().addAll(idColumn, quantityColumn, nameColumn, descriptionColumn);
   }

   // Get method for User Table
   private TableView getUserTable() {
      userTable.setId("user_table");

      TableView userTable = new TableView();

      TableColumn<User, String> userColumn = new TableColumn("USERNAME");
      userColumn.setMinWidth(50);
      userColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

      TableColumn<User, String> passColumn = new TableColumn("PASSWORD");
      passColumn.setMinWidth(50);
      passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

      TableColumn<User, Integer> accessColumn = new TableColumn("ACCESS LEVEL");
      accessColumn.setMinWidth(100);
      accessColumn.setCellValueFactory(new PropertyValueFactory("acces_lvl"));

      TableColumn<User, String> eMailColumn = new TableColumn("EMAIL ADDRESS");
      eMailColumn.setMinWidth(450);
      eMailColumn.setCellValueFactory(new PropertyValueFactory("email"));

      userTable.setPadding(new Insets(10,10,10,10));
      ObservableList<User> userList = c.getUsers();
      userTable.setItems(userList);
      userTable.getColumns().addAll(userColumn, passColumn, accessColumn, eMailColumn);

      return userTable;
   }

   // Method used for allowing search in Inventory Table
   private void search() {
      searchField.setMinWidth(800);
      searchField.setMaxWidth(800);
      searchField.setPromptText("Search");
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

   /**
    * Get Method for Logout Button.
    * @return logoutButton
    */
   private Button getLogoutButton() {
      logoutButton.setOnAction(event -> {
         inventoryTable.getColumns().clear();
         userTable.getColumns().clear();

         c.setLoggedUser(null);
         primaryStage.setScene(loginView());
         primaryStage.show();
      });
      return logoutButton;
   }

   // Get method for Quit Button in Main View
   private Button getMainQuitButton() {
      mainQuitButton.setOnAction(e -> {
         primaryStage.close();
         c.closeConnection();
      });
      return mainQuitButton;
   }

   //Get Method for Apply Button
   private Button getApplyButton() {
      applyButton.setOnAction(event -> {
         try {
            int quantity = Integer.parseInt(addQuantity.getText());
            String name = addName.getText();
            String description = addDescription.getText();

            if (isEditing) {
               Item item = new Item(selectedItem.getId(), quantity, name, description);
               c.updateItem(item);
               isEditing = false;
            } else {
               Item item = new Item(quantity, name, description);
               c.addItemToDb(item);
            }

            mainCenterVBox.getChildren().remove(addMenuVBox);

            updateTable();
         } catch (NumberFormatException ex) {
            System.out.println("You need to enter an integer you noob!");
         }
      });
      return applyButton;
   }

   // Get Method for cancel adding to Inventory Table.
   private Button getCancelButton() {
      cancelButton.setOnAction(event -> {
         mainCenterVBox.getChildren().remove(addMenuVBox);
         isEditing = false;
      });
      return cancelButton;
   }

   // Method for AddMenuBox.
   private void addMenuBox(VBox vbox) {
      HBox hbox1 = new HBox();
      hbox1.setSpacing(10);
      HBox hbox2 = new HBox();
      hbox2.setSpacing(10);
      HBox hbox3 = new HBox();
      hbox3.setSpacing(10);
      HBox hbox4 = new HBox();
      hbox4.setSpacing(10);
      HBox hbox5 = new HBox();
      hbox5.setSpacing(10);
      HBox hbox6 = new HBox();
      hbox6.setSpacing(10);
      BorderPane addBorderPane = new BorderPane();
      addQuantity.setMinWidth(50);
      addQuantity.setMaxWidth(50);
      try {
         hbox1.getChildren().add(addNameLabel);
         hbox2.getChildren().add(addName);
         hbox3.getChildren().add(addDescriptionLabel);
         hbox4.getChildren().add(addDescription);
         hbox5.getChildren().add(addQuantityLabel);
         hbox6.getChildren().add(getApplyButton());
         hbox6.getChildren().add(getCancelButton());
         addBorderPane.setLeft(addQuantity);
         addBorderPane.setRight(hbox6);
         vbox.getChildren().add(hbox1);
         vbox.getChildren().add(hbox2);
         vbox.getChildren().add(hbox3);
         vbox.getChildren().add(hbox4);
         vbox.getChildren().add(hbox5);
         vbox.getChildren().add(addBorderPane);
      } catch (IllegalArgumentException ex) {
         System.out.println("No exception to see here");
      }
   }

   // Get Method for AddButton.
   private Button getAddButton() {
      addButton.setOnAction(event -> {
         isEditing = false;
         addQuantity.setText("");
         addName.setText("");
         addDescription.setText("");
         addEditMenu();
      });
      return addButton;
   }

   // Method to show the add and edit menu
   private void addEditMenu() {
      try {
         addMenuVBox.setId("add_menu_vbox");
         mainCenterVBox.getChildren().add(addMenuVBox);
         addMenuBox(addMenuVBox);
      } catch (IllegalArgumentException ex) {
         System.out.println("No exception to see here");
      }
   }

   // Get method for editButton
   private Button getEditButton() {
      editButton.setOnAction(event -> {
         ObservableList<Item> items = inventoryTable.getSelectionModel().getSelectedItems();
         selectedItem = items.get(0);

         if (selectedItem != null) {
            isEditing = true;

            addQuantity.setText(String.valueOf(selectedItem.getQuantity()));
            addName.setText(selectedItem.getName());
            addDescription.setText(selectedItem.getDescription());

            addEditMenu();
         } else {
            System.out.println("Please select an item to edit!");
         }
      });

      return editButton;
   }

   // Get method for deleteButton.
   private Button getDeleteButton() {
      deleteButton.setOnAction(event -> {
         ObservableList<Item> items = inventoryTable.getSelectionModel().getSelectedItems();
         Item item = items.get(0);

         if (item != null) {
            c.removeItemFromDb(item);
            updateTable();
         } else {
            System.out.println("Please select an item to delete!");
         }
      });
      return deleteButton;
   }

   // Method for AddMenuBox.
   private VBox addUserBox() {
      VBox vbox = new VBox();
      vbox.setId("add_user_vbox");
      Label addUserNameLabel = new Label("Username:");
      Label addPasswordLabel = new Label("Password:");
      Label addEmailLabel = new Label("Email:");
      TextField addUserName = new TextField();
      addUserName.setPromptText("Enter new Username");
      PasswordField addPassword = new PasswordField();
      addPassword.setPromptText("Enter new Password");
      TextField addEmail = new TextField();
      addEmail.setPromptText("Enter an Email Address");
      HBox hbox1 = new HBox();
      hbox1.setSpacing(10);
      HBox hbox2 = new HBox();
      hbox2.setSpacing(10);
      HBox hbox3 = new HBox();
      hbox3.setSpacing(10);
      HBox hbox4 = new HBox();
      hbox4.setSpacing(10);
      HBox hbox5 = new HBox();
      hbox5.setSpacing(10);
      HBox hbox6 = new HBox();
      hbox6.setSpacing(10);
      HBox hbox7 = new HBox();
      hbox7.setSpacing(10);
      BorderPane addBorderPane = new BorderPane();
      addQuantity.setMinWidth(50);
      addQuantity.setMaxWidth(50);
      try {
         hbox1.getChildren().add(addUserNameLabel);
         hbox2.getChildren().add(addUserName);
         hbox3.getChildren().add(addPasswordLabel);
         hbox4.getChildren().add(addPassword);
         hbox5.getChildren().add(addEmailLabel);
         hbox6.getChildren().add(addEmail);
         hbox7.getChildren().add(getApplyButton());
         hbox7.getChildren().add(getCancelButton());
         addBorderPane.setLeft(hbox6);
         addBorderPane.setRight(hbox7);
         vbox.getChildren().add(hbox1);
         vbox.getChildren().add(hbox2);
         vbox.getChildren().add(hbox3);
         vbox.getChildren().add(hbox4);
         vbox.getChildren().add(hbox5);
         vbox.getChildren().add(addBorderPane);
      } catch (IllegalArgumentException ex) {
         System.out.println("No exception to see here");
      }
      return vbox;
   }

   private Button getAddUserButton() {
      VBox userVBox = new VBox();
      Button addUserButton = new Button();
      addUserButton.setText("Add User");
      addUserButton.setOnAction(event -> {
         mainCenterVBox.getChildren().clear();
         mainCenterVBox.getChildren().add(userTable);
         mainCenterVBox.getChildren().add(addUserBox());
      });
      return addUserButton;
   }

   private Button getEditUserButton() {
      Button editUserButton = new Button();
      editUserButton.setText("Edit User");

      return editUserButton;
   }

   private Button getDeleteUserButton() {
      Button deleteUserButton = new Button();
      deleteUserButton.setText("Delete User");
      return deleteUserButton;
   }

   private Scene mainView() {

      loadCSS(mainScene);
      getInventoryTable();
      userTable = getUserTable();
      search();

      primaryStage.setOnCloseRequest(e -> c.closeConnection());

      mainHBox.setId("main_hbox");
      mainHBox.setPadding(new Insets (20,10,20,10));
      mainHBox.setAlignment(Pos.TOP_CENTER);
      mainHBox.getChildren().add(getCurrentUserName());
      mainHBox.getChildren().add(getCurrentUserAccessLevel());

      mainTopVBox.setId("main_top_vbox");
      mainTopVBox.setAlignment(Pos.TOP_CENTER);
      mainTopVBox.setSpacing(30);
      mainTopVBox.setPadding(new Insets(20,10,20,10));
      mainTopVBox.getChildren().add(mainHBox);
      mainTopVBox.getChildren().add(searchField);

      mainRightVBox.setId("main_right_vbox");
      mainRightVBox.setPadding(new Insets(20,10,20,10));
      mainRightVBox.setSpacing(20);
      mainRightVBox.getChildren().add(getAddButton());
      mainRightVBox.getChildren().add(getEditButton());
      mainRightVBox.getChildren().add(getDeleteButton());

      mainLeftVBox.setId("main_left_vbox");
      mainLeftVBox.setPadding(new Insets(20,10,20,10));
      mainLeftVBox.getChildren().add(inventoryButton);
      mainLeftVBox.getChildren().add(userEdit);
      mainLeftVBox.getChildren().add(getLogoutButton());
      mainLeftVBox.getChildren().add(getMainQuitButton());

      mainCenterVBox.setId("main_center_vbox");
      mainCenterVBox.setPadding(new Insets(5,5,5,5));
      mainCenterVBox.getChildren().add(inventoryTable);

      mainBottomHBox.setId("main_bottom_hbox");
      mainBottomHBox.setPadding(new Insets(20,10,10,20));
      mainBottomHBox.setAlignment(Pos.BOTTOM_CENTER);
      mainBottomHBox.setSpacing(200);
      mainBottomHBox.getChildren().add(uniqueItems);
      mainBottomHBox.getChildren().add(totalQuantity);

      borderpane.setId("main_border_pane");
      borderpane.setRight(mainRightVBox);
      borderpane.setLeft(mainLeftVBox);
      borderpane.setTop(mainTopVBox);
      borderpane.setCenter(mainCenterVBox);
      borderpane.setBottom(mainBottomHBox);

      inventoryButton.setOnAction(e -> {
         mainCenterVBox.getChildren().clear();
         mainCenterVBox.getChildren().add(inventoryTable);
      });

      userEdit.setOnAction(e -> {
         mainCenterVBox.getChildren().clear();
         mainCenterVBox.getChildren().add(userTable);
         mainRightVBox.getChildren().clear();
         mainRightVBox.getChildren().add(getAddUserButton());
         mainRightVBox.getChildren().add(getEditUserButton());
         mainRightVBox.getChildren().add(getDeleteUserButton());
      });
      return mainScene;
    }
}