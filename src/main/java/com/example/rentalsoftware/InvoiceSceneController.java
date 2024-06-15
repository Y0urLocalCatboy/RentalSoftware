package com.example.rentalsoftware;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    public void prepare() {
        int price = 0;
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("person.json"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String invoice = "Invoice\n";
        String body = "Invoice for " + content +"\n";
        try (FileReader fileReader = new FileReader("vehicles.json")) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Gson gson = new Gson();
            Type carListType = new TypeToken<List<Car>>(){}.getType();
            all = gson.fromJson(jsonReader, carListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Car car : all) {
            if (car.isRented()) {
                invoice += car + " Rented for: " + car.getRentedDays() + " days\n";
                price += car.getPricePerHour() * car.getRentedDays() * 24;
            }
        }
        invoiceTitle.setText(body);
        invoiceBody.setText(invoice + "Total price: " + price + " PLN");

    }
    @FXML
    public void initialize() {
        prepare();
    }

    @FXML
    private void exit() {
        Platform.exit();
    }

    @FXML
    private void goToSceneTwo() {
        stage.setScene(scene2);
    }

    @FXML
    private Label invoiceBody;

    @FXML
    private Label invoiceTitle;
}
