module com.example.rentalsoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


//    opens com.example.rentalsoftware to javafx.fxml;
//    exports com.example.rentalsoftware;
    opens com.example.rentalsoftware to javafx.fxml, com.google.gson;
    exports com.example.rentalsoftware;
}