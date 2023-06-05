module com.example.tripsfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.example.tripsfrontend;
    opens com.example.tripsfrontend to com.google.gson, javafx.fxml;

    exports com.example.tripsfrontend.model;
    opens com.example.tripsfrontend.model to com.google.gson;
}