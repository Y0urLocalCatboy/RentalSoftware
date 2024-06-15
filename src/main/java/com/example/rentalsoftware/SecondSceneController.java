package com.example.rentalsoftware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class SecondSceneController {
    private Stage stage;
    private Scene scene3;
    private Scene scene1;
    private List<Car> all;
    private Car clickedCar;
    private InvoiceSceneController InvoiceSceneController;

    public void init(Stage stage, Scene scene3, Scene scene1, InvoiceSceneController InvoiceSceneController) {
        this.stage = stage;
        this.scene3 = scene3;
        this.scene1 = scene1;
        this.InvoiceSceneController = InvoiceSceneController;
        read();
    }
private void read() {
    try (FileReader fileReader = new FileReader("vehicles.json")) {
        JsonReader jsonReader = new JsonReader(fileReader);
        Gson gson = new Gson();
        Type carListType = new TypeToken<List<Car>>() {
        }.getType();
        all = gson.fromJson(jsonReader, carListType);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private void write() {
    try (FileWriter fileWriter = new FileWriter("vehicles.json")) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(all, fileWriter);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @FXML
    public void initialize() {
        updateView();
    }
    public void updateView() {
        read();
        carList.getItems().clear();
        reservedCarList.getItems().clear();

        for (Car vehicle : all) {
            if (!vehicle.isRented()) {
                if (vehicle instanceof OtherVehicles) {
                    carList.getItems().add(((OtherVehicles) vehicle).toString());
                } else {
                    carList.getItems().add(vehicle.toString());
                }
            } else {
                if (vehicle instanceof OtherVehicles) {
                    reservedCarList.getItems().add(((OtherVehicles) vehicle).toString());
                } else {
                    reservedCarList.getItems().add(vehicle.toString());
                }
            }
        }
    }


    @FXML
    private Label availableLabel;

    @FXML
    private ListView<String> carList;

    @FXML
    private ListView<String> reservedCarList;

    @FXML
    private TextField searchTextField;

    @FXML
    private void back(){
        read();
        stage.setScene(scene1);
    }

    @FXML
    private void exit() {
        Platform.exit();
    }

    @FXML
    private void goToInvoice() {
        write();
        InvoiceSceneController.prepare();
        stage.setScene(scene3);
    }

    @FXML
    void listMouseClick(MouseEvent event) {
        String selected = carList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String[] parts = selected.split(" ");
            String chosen = parts[6];
            for (Car car : all) {
                if (car.getLicensePlate().equals(chosen)) {
                    clickedCar = car;
                    break;
                }
            }
        }
    }

    @FXML
    void listScrolled(ScrollEvent event) {}
    @FXML
    private void handleReserveButtonAction() {
        if (clickedCar == null) {
            availableLabel.setText("Please choose a car to reserve");
            return;
        }
        if (clickedCar.isRented()) {
            availableLabel.setText("This car is already reserved");
            return;
        }
        clickedCar.setRented(true);
        clickedCar.setRentedDays(1);
        reservedCarList.getItems().add(clickedCar.toString());
        carList.getItems().remove(clickedCar.toString());

        availableLabel.setText("Car reserved successfully");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(all);

        write();
        initialize();
    }

    @FXML
    private void handleReturnButtonAction() {
        String selected = reservedCarList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String[] parts = selected.split(" ");
            String chosen = parts[6];
            for (Car car : all) {
                if (chosen.equals(car.getLicensePlate())) {
                    clickedCar = car;
                    break;
                }
            }
            if (clickedCar != null && clickedCar.isRented()) {
                clickedCar.setRented(false);
                carList.getItems().add(clickedCar.toString());
                reservedCarList.getItems().remove(selected);
                availableLabel.setText("Car returned successfully");

                write();
                updateView();
            } else {
                availableLabel.setText("This car hasn't been rented.");
            }
        } else {
            availableLabel.setText("No item selected");
        }
    }

    @FXML
    private void searchCars(ScrollEvent event) {
        String query = searchTextField.getText().toLowerCase();
        carList.getItems().clear();
        for (Car car : all) {
            if (car.toString().toLowerCase().contains(query)) {
                carList.getItems().add(car.toString());
            }
        }
    }
}
