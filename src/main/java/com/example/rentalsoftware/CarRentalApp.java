package com.example.rentalsoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileWriter;
import java.io.FileReader;
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
        controller1_2.init(stage, scene2);

        SecondSceneController controller2_3 = loader2.getController();
        controller2_3.init(stage, scene3);

        InvoiceSceneController controller3_2 = loader3.getController();
        controller3_2.init(stage, scene2);

        // Startup
        stage.setTitle("Car Rental Application");
        stage.setScene(scene1);
        stage.show();
    }


    public static void main(String[] args) {
//        Car car1 = new Car("ICE", "Toyota", "crimson", "AB 12345", true, 1, 10);
//        Car car2 = new Car("BEV", "Tesla", "black", "CD 67890", true, 4, 15);
//        Car car3 = new Car("hybrid", "Toyota", "yellow", "EF 24680", false, 0, 7);
//        OtherVehicles motor1 = new OtherVehicles("BEV", "Volkswagen", "black", "GH 13579", false, 0, 10, "motorcycle");
//        Vehicle[] all = {car1, car2, car3, motor1};
//        Gson gson = new Gson();
//        String json = gson.toJson(all);
//        System.out.println(json);
//
//        try (FileWriter fileWriter = new FileWriter("vehicles.json")) {
//            fileWriter.write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        launch();
    }
}