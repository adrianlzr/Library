package com.mip.mylibrary.controllers;

import com.mip.mylibrary.services.SignupService;
import com.mip.mylibrary.models.User;
import com.mip.mylibrary.common.Utils;
import com.mip.mylibrary.exceptions.SignupException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController extends BaseController implements Initializable {

    SignupService signupService;
    Utils utils;

    @FXML private TextField nume;
    @FXML private TextField prenume;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private ChoiceBox roles;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signupService = new SignupService();
        utils = new Utils();

        roles.getItems().addAll(User.UserRole.cititor, User.UserRole.bibliotecar);
        roles.setValue(User.UserRole.cititor);
    }

    public void signUp(ActionEvent event) throws IOException {
        User.UserRole rol = User.UserRole.valueOf(roles.getValue().toString());
        User user = new User(
                nume.getText(),
                prenume.getText(),
                email.getText(),
                password.getText(),
                rol
        );
        try {
            signupService.signUp(user);
            signUpSuccessful(event);
        } catch (SignupException e) {
            utils.showAlert(Alert.AlertType.ERROR, "Signup Failed", e.toString());
        }
    }

    public void signUpSuccessful(ActionEvent event) throws IOException {
        utils.showAlert(Alert.AlertType.INFORMATION, "Success", "Your account was successfully created. Please sign in");

        Parent libraryView = FXMLLoader.load(getClass().getResource("/fxml/LoginScene.fxml"));
        Scene libraryScene = new Scene(libraryView);
        // Retrieve the Stage info.
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(libraryScene);
        window.show();
    }

    public void signIn(ActionEvent event) throws IOException {
        utils.changeScene(event, "LoginScene.fxml");
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
