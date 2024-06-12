package com.example.rentalsoftware;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstSceneController {
    private Stage stage;
    private Scene scene2;




    public void init(Stage stage, Scene scene2) {
        this.stage = stage;
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
