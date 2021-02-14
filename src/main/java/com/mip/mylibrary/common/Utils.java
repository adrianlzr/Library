package com.mip.mylibrary.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {

    private String fxmlPath = "/fxml/%s";
    private Alert alert = new Alert(AlertType.NONE);


    public void changeScene(ActionEvent event, String scene) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(String.format(fxmlPath, scene)));
        Scene libraryScene = new Scene(root);
        // Retrieve the Stage info.
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(libraryScene);
        window.show();
    }

    public void showAlert(AlertType alertType, String title, String message) {
        alert.setAlertType(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
