package com.example.rentalsoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CarRentalApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Scenes Loading
        FXMLLoader loader1 = new FXMLLoader(CarRentalApp.class.getResource("first-scene.fxml"));
        Scene scene1 = new Scene(loader1.load());
        FXMLLoader loader2 = new FXMLLoader(CarRentalApp.class.getResource("second-scene.fxml"));
        Scene scene2 = new Scene(loader2.load());
        FXMLLoader loader3 = new FXMLLoader(CarRentalApp.class.getResource("invoice-scene.fxml"));
        Scene scene3 = new Scene(loader3.load());

        // Initializing of the controllers
        FirstSceneController controller1_2 = loader1.getController();
        controller1_2.init(stage, scene2, scene1);

        SecondSceneController controller2_3 = loader2.getController();
        controller2_3.init(stage, scene3, scene1);

        InvoiceSceneController controller3_2 = loader3.getController();
        controller3_2.init(stage, scene2);

        // Startup
        stage.setTitle("Car Rental Application");
        stage.setScene(scene1);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}