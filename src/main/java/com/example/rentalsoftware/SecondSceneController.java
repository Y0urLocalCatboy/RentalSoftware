package com.example.rentalsoftware;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class SecondSceneController {

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
