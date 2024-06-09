package com.example.rentalsoftware;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FirstSceneController {
    private Stage stage;
    private Scene scene2;

    public void init(Stage stage, Scene scene2) {
        this.stage = stage;
        this.scene2 = scene2;
    }

    @FXML
    private void goToSceneTwo() {
        if(nameTextField.getText().isEmpty() || surnameTextField.getText().isEmpty()) {
            fluffLabel.setText("Please fill in all the fields");
            return;
        }
        stage.setScene(scene2);
    }
    @FXML
    private void exit() {
        Platform.exit();
    }
    @FXML
    private Button continueSceneTwoButton;

    @FXML
    private Label fluffLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label surnameLabel;

    @FXML
    private TextField surnameTextField;

}
