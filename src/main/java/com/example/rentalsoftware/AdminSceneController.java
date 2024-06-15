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
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class AdminSceneController {
    private Stage stage;
    private Scene scene1;
    private Scene scene2;

    private List<Car> all;
    private Car clickedCar;
    private SecondSceneController secondSceneController;


    public void init(Stage stage, Scene scene1, Scene scene2, SecondSceneController secondSceneController) {
        this.stage = stage;
        this.scene1 = scene1;
        this.scene2 = scene2;
        this.secondSceneController = secondSceneController; // Inicjalizacja kontrolera scene2
        read();
    }
    private void refresh(){
        write();
        carList.getItems().clear();
        for (Car car : all)
            carList.getItems().add(car.toString());
    }
    private void write() {
        try (FileWriter fileWriter = new FileWriter("vehicles.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(all, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void read(){
        try (FileReader fileReader = new FileReader("vehicles.json")) {
            JsonReader jsonReader = new JsonReader(fileReader);
            Gson gson = new Gson();
            Type carListType = new TypeToken<List<Car>>(){}.getType();
            all = gson.fromJson(jsonReader, carListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize(){
        read();
        for (Car car : all)
            carList.getItems().add(car.toString());
    }
    @FXML
    private void back(){
        write();
        secondSceneController.updateView();
        stage.setScene(scene1);
    }
    @FXML
    private void add(){
        if(textFieldBrand.getText().isEmpty() || textFieldColor.getText().isEmpty() || textFieldLicensePlate.getText().isEmpty() || textFieldPrice.getText().isEmpty() || textFieldType.getText().isEmpty() || textFieldInfo.getText().isEmpty()){
            labelAdmin.setText("Please fill in all fields!");
            return;
        } if(textFieldBrand.getText().length() < 3 || textFieldColor.getText().length() < 3 || textFieldLicensePlate.getText().length() < 3 || textFieldType.getText().length() < 3){
            labelAdmin.setText("All fields must be at least 3 characters long!");
            return;
        } if(textFieldBrand.getText().length() > 20 || textFieldLicensePlate.getText().length() > 20 || textFieldType.getText().length() > 20){
            labelBrand.setText("All fields must be at most 20 characters long!");
            return;
        } if(textFieldColor.getText().length() > 20){
            labelColor.setText("All fields must be at most 20 characters long!");
            return;
        } if(textFieldPrice.getText().length() > 5){
            labelPrice.setText("Price must be at most 5 characters long!");
            return;
        } if(!textFieldBrand.getText().matches("[a-zA-Z]+")){
            labelBrand.setText("Brand must contain only letters!");
            return;
        } if(!textFieldInfo.getText().matches("[a-zA-Z]+")){
            labelTypeOfVeh.setText("Type of a vehicle must contain only letters!");
            return;
        } if(!textFieldColor.getText().matches("[a-zA-Z]+")){
            labelColor.setText("Color must contain only letters!");
            return;
        }  if(!textFieldType.getText().matches("[a-zA-Z]+")){
            labelTypeOfEng.setText("Type of engine must contain only letters!");
            return;
        } if(!textFieldPrice.getText().matches("[0-9]+")){
            labelPrice.setText("Price must contain only numbers!");
            return;
        } if(!(textFieldLicensePlate.getText().length() == 7)){
            labelLicensePlate.setText("7 characters!");
            return;
        } if(!textFieldLicensePlate.getText().matches("[A-Z0-9]+")){
            labelLicensePlate.setText("Big letters and numbers!");
            return;
        }
        if(textFieldInfo.getText().equals("Car")){
            String brand = textFieldBrand.getText();
            String color = textFieldColor.getText();
            String licensePlate = textFieldLicensePlate.getText();
            String type = textFieldType.getText();
            int price = Integer.parseInt(textFieldPrice.getText());
            Car car = new Car(type, brand, color, licensePlate, false, 0, price);
            all.add(car);
            refresh();
        } else {
            String additionalInfo = textFieldInfo.getText();
            String brand = textFieldBrand.getText();
            String color = textFieldColor.getText();
            String licensePlate = textFieldLicensePlate.getText();
            String type = textFieldType.getText();
            int price = Integer.parseInt(textFieldPrice.getText());
            OtherVehicles car = new OtherVehicles(type, brand, color, licensePlate, false, 0, price, additionalInfo);
            all.add(car);
            refresh();
        }
    }
    @FXML
    private void delete(){
        if(clickedCar != null){
            all.remove(clickedCar);
            clickedCar = null;
            refresh();
        }
        else{
            labelAdmin.setText("Please select a car from the list.");
        }
    }
    @FXML
    private void changeVeh(){
        delete();
        add();
    }
    @FXML
    private void changeCat(){
        stage.setScene(scene1);
    }
    @FXML
    void mouseClick(MouseEvent event) {
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
        textFieldBrand.setText(clickedCar.getBrand());
        textFieldColor.setText(clickedCar.getColor());
        textFieldLicensePlate.setText(clickedCar.getLicensePlate());
        textFieldPrice.setText(String.valueOf(clickedCar.getPricePerHour()));
        textFieldType.setText(clickedCar.getType());textFieldInfo.setText("Car");
    }

    @FXML
    private void exit() {
        Platform.exit();
    }


    @FXML
    private ListView<String> carList;
    @FXML
    private TextField textFieldInfo;

    @FXML
    private Label labelBrand;

    @FXML
    private Label labelColor;

    @FXML
    private Label labelLicensePlate;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelTypeOfEng;

    @FXML
    private Label labelTypeOfVeh;
    @FXML
    private Label labelAdmin;


    @FXML
    private TextField textFieldBrand;

    @FXML
    private TextField textFieldColor;

    @FXML
    private TextField textFieldLicensePlate;

    @FXML
    private TextField textFieldPrice;

    @FXML
    private TextField textFieldType;

}