package com.example.rentalsoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InvoiceSceneApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InvoiceSceneApp.class.getResource("invoice-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Car Rental Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}