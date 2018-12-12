package com.yfy.beem.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/main.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Scene scene = new Scene(root,800,400);
        stage.setScene(scene);
        stage.setTitle("Test FX scene");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
