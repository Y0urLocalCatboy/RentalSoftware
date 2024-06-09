package com.example.rentalsoftware;

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
import com.google.gson.Gson;

public class SecondSceneController {
    private Stage stage;
    private Scene scene3;

    public void init(Stage stage, Scene scene3) {
        this.stage = stage;
        this.scene3 = scene3;
    }
    private List<Car> all;
    @FXML
    public void initialize() {
        carList.getItems().clear();
        try (FileReader fileReader = new FileReader("vehicles.json")) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Gson gson = new Gson();
            Type carListType = new TypeToken<List<Car>>(){}.getType();
            all = gson.fromJson(jsonReader, carListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Car car : all) {
            if(!car.isRented())
                carList.getItems().add(car.toString());
        }

    }
    @FXML
    private void goToInvoice() {
        stage.setScene(scene3);
    }
    @FXML
    private void reservation() {
        if(clickedCar == null) {
            searchLabel.setText("Please choose a car");
            return;
        }
        clickedCar.setRented(true);
        clickedCar.setRentedDays(1);
        searchLabel.setText("Car reserved");
        Gson gson = new Gson();
        String json = gson.toJson(all);

        try (FileWriter fileWriter = new FileWriter("vehicles.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        initialize();
    }
    @FXML
    private void exit() {
        Platform.exit();
    }
    @FXML
    private ListView<String> carList;

    @FXML
    private Label searchLabel;
    private Vehicle clickedCar;

    @FXML
    private TextField searchTextField;

    @FXML
    void listMouseClick(MouseEvent event) {
        String chosen = carList.getSelectionModel().getSelectedItem().split(" ")[6];
        for(Car car : all) {
            if(car.getLicensePlate().equals(chosen)) {
                clickedCar = car;
                break;
            }
        }
        //clickedCar to wybrany przez myszkę samochód - dzięki temu możemy go zarezerwować
        searchTextField.setText(clickedCar.toString());
    }

    @FXML
    void listScrolled(ScrollEvent event) {

    }

}
