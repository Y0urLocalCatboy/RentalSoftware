package com.example.rentalsoftware;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class InvoiceSceneController {

    private Stage stage;
    private Scene scene2;
    private List<Car> all;


    public void init(Stage stage, Scene scene2) {
        this.stage = stage;
        this.scene2 = scene2;
    }
    @FXML
    public void initialize() {
        String invoice = "Invoice\n";
        int price = 0;
        //tutaj będą zczytane dane z pliku z użytkownikami zamiast z vehicles.json
        //obecnie jest ogólna database
     try (
    FileReader fileReader = new FileReader("vehicles.json")) {
         JsonReader jsonReader = new JsonReader(fileReader);
         Gson gson = new Gson();
         Type carListType = new TypeToken<List<Car>>() {
         }.getType();
         all = gson.fromJson(jsonReader, carListType);
     } catch (Exception e) {
         e.printStackTrace();
     }
     for (Car car : all) {
         if (car.isRented()) {
                invoice += car + " Rented for: " + car.getRentedDays() + " days\n";
                price += car.getPricePerHour() * car.getRentedDays()*24;
             }
     }
        invoiceTitle.setText("Invoice");
        invoiceBody.setText(invoice + "Total price: " + price + " PLN");


    }


    @FXML
    private void goToSceneTwo() {
        stage.setScene(scene2);
    }
    @FXML
    private void exit() {
        Platform.exit();
    }

    @FXML
    private Label invoiceBody;

    @FXML
    private Label invoiceTitle;


}

