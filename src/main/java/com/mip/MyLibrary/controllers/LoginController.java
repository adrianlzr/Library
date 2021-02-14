package com.mip.MyLibrary.controllers;

import com.mip.MyLibrary.exceptions.LoginException;
import com.mip.MyLibrary.services.LoginService;
import com.mip.MyLibrary.models.User;
import com.mip.MyLibrary.common.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends BaseController implements Initializable {

    private Utils utils;
    private LoginService loginService;

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        utils = new Utils();
        loginService = new LoginService();
    }

    public void logIn(ActionEvent event) throws IOException {
        User user = new User(email.getText(), password.getText());
        try {
            loginService.login(user);
            logInSuccessful(event);
        }catch (LoginException e) {
            utils.showAlert(Alert.AlertType.ERROR, "Login Failed", e.toString());
        }
    }

    public void logInSuccessful(ActionEvent event) throws IOException {
        changeScene(event, "/fxml/LibraryScene.fxml");
    }

    public void signUp(ActionEvent event) throws IOException {
        utils.changeScene(event, "SignupScene.fxml");
    }

    public void changeScene(ActionEvent event, String scene) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        Parent libraryView = loader.load();
        LibraryController controller = loader.getController();
        User user = this.getUser();
        controller.setUser(user);
        Scene libraryScene = new Scene(libraryView);
        // Retrieve the Stage info.
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(libraryScene);
        window.show();
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

}
