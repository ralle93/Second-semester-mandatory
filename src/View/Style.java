package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Tommy is primary contributor for this class.
 */
class Style {

    static void styleLoginVBox(VBox vbox) {
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(100);
        vbox.setPadding(new Insets(25,25,25,25));
        vbox.setStyle("-fx-background-color: azure;");
    }

    static void styleloginGrid(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(25);
        gridPane.setHgap(10);
    }

    static void styleLoginHBox(HBox hbox) {
        hbox.setSpacing(100);
        hbox.setPadding(new Insets(10,10,10,10));
    }

    static void styleloginTitleLabel(Label label) {
        label.setPadding(new Insets(10,50,10,50));
        label.setStyle("-fx-text-fill: cadetblue;"+
                       "-fx-font-size: 48px;"+
                       "-fx-font-family: monospace;"+
                       "-fx-border-color: cadetblue;"+
                       "-fx-border-width: 2px;"+
                       "-fx-border-radius: 20%");
    }

    static void styleloginLabel(Label label) {
        label.setStyle("-fx-text-fill: cadetblue;"+
                       "-fx-font-family: monospace;"+
                       "-fx-font-size: 18px;");
    }

    static void styleButtons(Button button) {
        button.setStyle("-fx-text-fill: cadetblue;"+
                        "-fx-background-color: azure;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-color: cadetblue;"+
                        "-fx-border-radius: 20%;"
        );
        button.setOnMouseEntered(event -> button.setStyle(
                        "-fx-border-radius: 20%;"+
                        "-fx-text-fill: azure;"+
                        "-fx-background-color: cadetblue;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-color: transparent;")
        );
        button.setOnMouseExited(event -> button.setStyle(
                        "-fx-text-fill: cadetblue;"+
                        "-fx-background-color: transparent;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-color: cadetblue;"+
                        "-fx-border-radius: 20%;")
        );
    }

    static void styleTextfield(TextField textField) {
        textField.setStyle("-fx-background-color: azure;"+
                           "-fx-border-color: cadetblue;"+
                           "-fx-border-width: 2px;"+
                           "-fx-border-radius: 2%;"+
                           "-fx-text-fill: cadetblue;"+
                           "-fx-prompt-text-fill: cadetblue;"
        );
    }

    static void stylePasswordField(PasswordField passwordField) {
        passwordField.setStyle("-fx-background-color: azure;"+
                               "-fx-border-color: cadetblue;"+
                               "-fx-border-width: 2px;"+
                               "-fx-border-radius: 2%;"+
                               "-fx-text-fill: cadetblue;"+
                               "-fx-prompt-text-fill: cadetblue;"
        );
    }

    /**
     * STYLING Main View
     */
    static void styleBorderPane(BorderPane borderPane) {
        borderPane.setPadding(new Insets(10,10,10,10));
        borderPane.setStyle("-fx-background-color: azure;");
    }

    static void styleMainVBox(VBox vbox) {
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setStyle("-fx-background-color: azure;");
    }

    static void styleMainHBox(HBox hbox) {
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(100);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: cadetblue;" + "-fx-border-radius: 20%;" + "-fx-border-width: 20px;" + "-fx-border-color: cadetblue;");
    }

    static void styleMainSearchField(TextField textField) {
        textField.setMinWidth(500);
        textField.setMaxWidth(500);
        textField.setPadding(new Insets(10,10,10,10));
        textField.setStyle("-fx-border-color: cadetblue;"+
                            "-fx-border-width: 2px;"+
                            "-fx-border-radius: 20%;"+
                            "-fx-background-color: transparent;"+
                           "-fx-text-fill: cadetblue;");
    }

    static void styleButtonForMainView(Button button) {
        button.setMaxWidth(150);
        button.setMinWidth(150);
        button.setStyle("-fx-background-color: transparent;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-radius: 20%;"+
                        "-fx-border-color: cadetblue;"+
                        "-fx-text-fill: cadetblue;"
        );
        button.setOnMouseEntered(event -> button.setStyle(
                        "-fx-background-color: cadetblue;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-radius: 20%;"+
                        "-fx-border-color: cadetblue;"+
                        "-fx-text-fill: azure;")
        );
        button.setOnMouseExited(event -> button.setStyle(
                        "-fx-background-color: transparent;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-radius: 20%;"+
                        "-fx-border-color: cadetblue;"+
                        "-fx-text-fill: cadetblue;")
        );
    }

    static void styleTableView(TableView tableView) {
        tableView.setStyle("-fx-border-width: 5px;"+
                            "-fx-border-color: cadetblue;"+
                            "-fx-border-radius: 2%;"+
                            "-fx-background-color: transparent;");

    }
}
