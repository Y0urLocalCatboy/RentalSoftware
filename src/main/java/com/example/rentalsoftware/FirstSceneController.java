package com.example.rentalsoftware;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstSceneController {
    private Stage stage;
    private Scene scene2;
    private Scene scene1;

    public void backToSceneOne() {
        stage.setScene(scene1);
    }

    public void init(Stage stage, Scene scene2, Scene scene1) {
        this.stage = stage;
        this.scene1 = scene1;
        this.scene2 = scene2;
    }

    @FXML
    private void goToSceneTwo() {
        //przejscie dalej
        stage.setScene(scene2);
    }

    @FXML
    private void exit() {
        stage.close();
    }
}
