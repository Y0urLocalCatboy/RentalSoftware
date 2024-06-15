package com.example.rentalsoftware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class FirstSceneController {
    private Stage stage;
    private Scene scene2;
    private Scene scene4;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Label fluffLabel;
    public void setSurnameTextField(String surnameTextField) {
        this.surnameTextField.setText(surnameTextField);
    }
    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }
    public void setFluffLabel(String fluffLabel) {
        this.fluffLabel.setText(fluffLabel);
    }

    public void init(Stage stage, Scene scene2, Scene scene4) {
        this.stage = stage;
        this.scene2 = scene2;
        this.scene4 = scene4;
    }
    @FXML
    private void goToSceneTwo() {
        if (nameTextField.getText().isEmpty() || surnameTextField.getText().isEmpty()) {
            fluffLabel.setText("Please fill in all fields!");
            return;
        } else if (nameTextField.getText().length() < 3 || surnameTextField.getText().length() < 3) {
            fluffLabel.setText("Name and surname must be at least 3 characters long!");
            return;
        } else if (nameTextField.getText().length() > 20 || surnameTextField.getText().length() > 20) {
            fluffLabel.setText("Name and surname must be at most 20 characters long!");
            return;
        } else if (!nameTextField.getText().matches("[a-zA-Z]+") || !surnameTextField.getText().matches("[a-zA-Z]+")) {
            fluffLabel.setText("Name and surname must contain only letters!");
            return;
        } else if(nameTextField.getText().equals("admin") || surnameTextField.getText().equals("admin")) {
            setFluffLabel("Enter your name and surname to log in!");
            setNameTextField("");
            setSurnameTextField("");
            stage.setScene(scene4);
            return;
        } else if (nameTextField.getText().equals(surnameTextField.getText())) {
            fluffLabel.setText("Name and surname must be different!");
            return;
        } else if (!Character.isUpperCase(nameTextField.getText().charAt(0)) ||
                !nameTextField.getText().substring(1).equals(nameTextField.getText().substring(1).toLowerCase()) ||
                !Character.isUpperCase(surnameTextField.getText().charAt(0)) ||
                !surnameTextField.getText().substring(1).equals(surnameTextField.getText().substring(1).toLowerCase())) {
            fluffLabel.setText("Name and surname must start with a capital letter and have the rest in lower case!");
            return;
        } else if (nameTextField.getText().contains(" ") || surnameTextField.getText().contains(" ")) {
            fluffLabel.setText("Name and surname must not contain spaces!");
            return;
        }
        String name = nameTextField.getText() + " " + surnameTextField.getText();
        try (FileWriter fileWriter = new FileWriter("person.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(name, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setFluffLabel("Enter your name and surname to log in!");
        setNameTextField("");
        setSurnameTextField("");
        stage.setScene(scene2);
    }

    @FXML
    private void exit() {
        stage.close();
    }
}
