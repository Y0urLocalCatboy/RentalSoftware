package com.example.rentalsoftware;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class SecondSceneController {

    private Stage stage;
    private Scene scene3;
    private Scene scene1;

    public void init(Stage stage, Scene scene3, Scene scene1) {
        this.stage = stage;
        this.scene3 = scene3;
        this.scene1 = scene1;
    }

    @FXML
    public void initialize() {
        carList.getItems().clear();
        reservedCarList.getItems().clear();
        try (FileReader fileReader = new FileReader("vehicles.json")) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Gson gson = new Gson();
            Type carListType = new TypeToken<List<Car>>(){}.getType();
            all = gson.fromJson(jsonReader, carListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Car car : all) {
            if(!car.isRented()) {
                carList.getItems().add(car.toString());
            } else {
                reservedCarList.getItems().add(car.toString());
            }
        }
    }

    private List<Car> all;
    private Vehicle clickedCar;
    private User currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = user;
        showUserCars();
    }

    @FXML
    private Label availableLabel;

    @FXML
    private ListView<String> carList;

    @FXML
    private ListView<String> reservedCarList;

    @FXML
    private Label reservedLabel;

    @FXML
    private void showUserCars() {
        reservedCarList.getItems().clear();
        for (Vehicle vehicle : currentUser.getVehicles()) {
            reservedCarList.getItems().add(vehicle.toString());
        }
    }

    @FXML
    private void back() throws IOException {
        stage.setScene(scene1);
    }

    @FXML
    private void exit() {
        Platform.exit();
    }

    @FXML
    private void goToInvoice() {
        stage.setScene(scene3);
    }

    @FXML
    void listMouseClick() {
        String selected = carList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String[] parts = selected.split(" ");
            if (parts.length >= 7) {
                String chosen = parts[6];
                for (Car car : all) {
                    if (chosen.equals(car.getLicensePlate())) {
                        clickedCar = car;
                        break;
                    }
                }
                if (clickedCar != null) {
                    if (clickedCar.isRented()) {
                        availableLabel.setText("This car is already reserved");
                    } else {
                        availableLabel.setText("This car is available for reservation");
                    }
                } else {
                    availableLabel.setText("Clicked car not found.");
                }
            } else {
                availableLabel.setText("Selected item does not contain enough parts.");
            }
        } else {
            availableLabel.setText("No item selected.");
        }
    }

    @FXML
    private void reservation() {
        if (clickedCar == null) {
            availableLabel.setText("Please choose a car");
            return;
        }
        if (clickedCar.isRented()) {
            availableLabel.setText("This car is already reserved");
            return;
        }
        clickedCar.setRented(true);
        reservedCarList.getItems().add(clickedCar.toString());
        carList.getItems().remove(clickedCar.toString());

        currentUser.getVehicles().add(clickedCar);
        saveUsers();
    }

    private void saveUsers() {
        List<User> users = loadUsers();
        for (User user : users) {
            if (user.getName().equals(currentUser.getName()) && user.getSurname().equals(currentUser.getSurname())) {
                user.setVehicles(currentUser.getVehicles());
                break;
            }
        }
        saveUsers(users);
    }

    private List<User> loadUsers() {
        try (FileReader reader = new FileReader("users.json")) {
            JsonReader jsonReader = new JsonReader(reader);
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<User>>(){}.getType();
            return gson.fromJson(jsonReader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private void saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter("users.json")) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



// New method to handle the return button click
    /*@FXML
    private void handleReturnButtonAction() {
        String selected = reservedCarList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String[] parts = selected.split(" ");
            if (parts.length >= 7) {
                String chosen = parts[6];
                clickedCar = null; // Reset clickedCar before searching
                for (Car car : all) {
                    if (chosen.equals(car.getLicensePlate())) {
                        clickedCar = car;
                        break;
                    }
                }

                if (clickedCar == null) {
                    availableLabel.setText("Car not found.");
                    return;
                }

                if (!clickedCar.isRented()) {
                    availableLabel.setText("This car hasn't been rented.");
                    return;
                }

                clickedCar.setRented(false);
                clickedCar.setRentedDays(0);
                reservedCarList.getItems().remove(selected);
                carList.getItems().add(clickedCar.toString());

                availableLabel.setText("Car returned successfully");

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(all);

                try (FileWriter fileWriter = new FileWriter("vehicles.json")) {
                    fileWriter.write(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                availableLabel.setText("Selected item does not contain enough parts.");
            }
        } else {
            availableLabel.setText("No item selected.");
        }
    }*/
}
