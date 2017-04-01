package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Tommy is primary contributor for this class.
 */
public class Style {

    public static void styleLoginVBox(VBox vbox) {
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(100);
        vbox.setPadding(new Insets(25,25,25,25));
        vbox.setStyle("-fx-background-color: azure;");
    }

    public static void styleloginGrid(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setStyle("-fx-border-radius: 2%;"+
                          "-fx-border-width: 2px;"+
                          "-fx-border-color: blueviolet;");
    }

    public static void styleLoginHBox(HBox hbox) {
        hbox.setSpacing(100);
        hbox.setPadding(new Insets(10,10,10,10));
    }

    public static void styleloginLabel(Label label) {
        label.setStyle("-fx-text-fill: blueviolet;");
    }

    public static void styleButtons(Button button) {
        button.setStyle("-fx-text-fill: blueviolet;"+
                        "-fx-background-color: azure;"+
                        "-fx-border-width: 2px;"+
                        "-fx-border-color: blueviolet;"+
                        "-fx-border-radius: 20%;");
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-text-fill: azure;"+
                            "-fx-background-color: blueviolet;"+
                            "-fx-border-width: 2px;"+
                            "-fx-border-color: transparent;"+
                            "-fx-border-radius: 20%;");
        });
        button.setOnMouseExited(event -> {
            button.setStyle("-fx-text-fill: blueviolet;"+
                            "-fx-background-color: transparent;"+
                            "-fx-border-width: 2px;"+
                            "-fx-border-color: blueviolet;"+
                            "-fx-border-radius: 20%;");
        });
    }

    public static void styleTextfield(TextField textField) {
        textField.setStyle("-fx-background-color: azure;"+
                           "-fx-border-color: blueviolet;"+
                           "-fx-border-width: 2px;"+
                           "-fx-border-radius: 2%;"+
                           "-fx-text-fill: blueviolet;"+
                           "-fx-prompt-text-fill: blueviolet;");
    }

    public static void stylePasswordField(PasswordField passwordField) {
        passwordField.setStyle("-fx-background-color: azure;"+
                               "-fx-border-color: blueviolet;"+
                               "-fx-border-width: 2px;"+
                               "-fx-border-radius: 2%;"+
                               "-fx-text-fill: blueviolet;"+
                               "-fx-prompt-text-fill: blueviolet;");
    }
}
