package com.example.rentalsoftware;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InvoiceSceneController {

    private Stage stage;
    private Scene scene2;

    public void init(Stage stage, Scene scene2) {
        this.stage = stage;
        this.scene2 = scene2;
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
    private Button exitButton;

    @FXML
    private Label invoiceBody;

    @FXML
    private Label invoiceTitle;

    @FXML
    private Button toSecondSceneButton;

}

