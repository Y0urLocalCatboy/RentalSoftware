module com.example.rentalsoftware {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rentalsoftware to javafx.fxml;
    exports com.example.rentalsoftware;
}