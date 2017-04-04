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

import java.text.NumberFormat;

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
   private HBox mainHBox = new HBox();
   private HBox mainHBoxAdd = new HBox();
   private HBox mainBottomHBox = new HBox();
   private VBox mainTopVBox = new VBox();
   private VBox mainRightVBox = new VBox();
   private VBox mainLeftVBox = new VBox();
   private VBox mainCenterVBox = new VBox();
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

      quitButton.setOnAction(event -> {
         primaryStage.close();
         c.closeConnection();
      });

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
      ObservableList<Item> itemList = c.getItems();
      inventoryTable.setItems(itemList);
      inventoryTable.getColumns().addAll(idColumn, quantityColumn, nameColumn, descriptionColumn);

      uniqueItems.setText("Unique items: " + NumberFormat.getIntegerInstance().format(itemList.size()));
      int total = 0;
      for (Item i : itemList) {
         total += i.getQuantity();
      }
      totalQuantity.setText("Total quantity: " + NumberFormat.getIntegerInstance().format(total));

      search();

      // Does not work yet.
      logoutButton.setOnAction(event -> {
         primaryStage.setScene(loginView());
         primaryStage.show();
      });

      mainQuitButton.setOnAction(evente -> {
         primaryStage.close();
         c.closeConnection();
      });

      primaryStage.setOnCloseRequest(e -> c.closeConnection());

      searchField.setPromptText("Search");

      addButton.setOnAction(event -> {
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
         mainCenterVBox.getChildren().remove(mainHBoxAdd); //
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
      Style.styleMainBottomHBox(mainBottomHBox);
      Style.styleloginLabel(uniqueItems);
      Style.styleloginLabel(totalQuantity);
      Style.styleMainAddBox(mainHBoxAdd, mainCenterVBox);
      Style.styleTextfield(addQuantity);
      Style.styleTextfield(addName);
      Style.styleTextfield(addDescription);
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