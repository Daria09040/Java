module com.example.bookingsfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.example.bookingsfrontend;
    opens com.example.bookingsfrontend to com.google.gson, javafx.fxml;

    exports com.example.bookingsfrontend.model;
    opens com.example.bookingsfrontend.model to com.google.gson;
}