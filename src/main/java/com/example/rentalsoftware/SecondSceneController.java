package com.example.rentalsoftware;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

public class SecondSceneController {


    private Stage stage;
    private Scene scene3;

    public void init(Stage stage, Scene scene3) {
        this.stage = stage;
        this.scene3 = scene3;
    }

    @FXML
    private void goToInvoice() {
        stage.setScene(scene3);
    }
    @FXML
    private void exit() {
        Platform.exit();
    }
    @FXML
    private ListView<?> carList;

    @FXML
    private Button exitButton;

    @FXML
    private Button reserveButton;

    @FXML
    private Button returnButton;

    @FXML
    private Label searchLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    void listMouseClick(MouseEvent event) {

    }

    @FXML
    void listScrolled(ScrollEvent event) {

    }

}
