package com.mip.MyLibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent pane = FXMLLoader.load(getClass().getResource("/fxml/LoginScene.fxml"));
        window.setTitle("My Library");
        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }
}
