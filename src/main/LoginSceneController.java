package com.example.rentalsoftware;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LoginSceneController {

    private Stage stage;
    private Scene mainScene;

    public void init(Stage stage, Scene mainScene) {
        this.stage = stage;
        this.mainScene = mainScene;
    }


    private TextField nameField;


    private TextField surnameField;


    private Button loginButton;


    private Button exitButton;


    private void login() {
        String name = nameField.getText();
        String surname = surnameField.getText();

        if (name.equals(name.toLowerCase()) || surname.equals(surname.toLowerCase())) {
            showAlert("Name and surname must start with an uppercase letter.");
            return;
        }

        List<User> users = loadUsers();
        User user = findUser(users, name, surname);

        if (user == null) {
            boolean createNew = confirmNewUser();
            if (createNew) {
                user = new User(name, surname, List.of());
                users.add(user);
                saveUsers(users);
            } else {
                return;
            }
        }

        stage.setScene(mainScene);
    }


    private void exit() {
        Platform.exit();
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

    private User findUser(List<User> users, String name, String surname) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getSurname().equals(surname)) {
                return user;
            }
        }
        return null;
    }

    private boolean confirmNewUser() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("New User");
        alert.setHeaderText(null);
        alert.setContentText("User not found. Do you want to create a new account?");
        alert.showAndWait();
        return alert.getResult().getText().equals("OK");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
