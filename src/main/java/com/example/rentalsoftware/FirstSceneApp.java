package com.example.rentalsoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstSceneApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //SCENES LOADING
            //first scene
        FXMLLoader loader1 = new FXMLLoader(FirstSceneApp.class.getResource("first-scene.fxml"));
        Parent root1 = loader1.load();
        Scene scene1 = new Scene(root1);
            //second scene
        FXMLLoader loader2 = new FXMLLoader(FirstSceneApp.class.getResource("second-scene.fxml"));
        Parent root2 = loader2.load();
        Scene scene2 = new Scene(root2);
            //third scene
        FXMLLoader loader3 = new FXMLLoader(FirstSceneApp.class.getResource("invoice-scene.fxml"));
        Parent root3 = loader3.load();
        Scene scene3 = new Scene(root3);


        //Initializing of the controllers (going to the next/last stage)
            //1 -> 2
        FirstSceneController controller1 = loader1.getController();
        controller1.init(stage, scene2);
            //2 -> 3
        SecondSceneController controller2 = loader2.getController();
        controller2.init(stage, scene3);
            //3 -> 2
        InvoiceSceneController controller3 = loader3.getController();
        controller3.init(stage, scene2);

        //startup
        stage.setTitle("Car Rental Application");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}