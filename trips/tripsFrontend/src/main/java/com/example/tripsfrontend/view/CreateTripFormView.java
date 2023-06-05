package com.example.tripsfrontend.view;

import com.example.tripsfrontend.ScreenBounds;
import com.example.tripsfrontend.controller.CreateTripFormController;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateTripFormView {
    private Stage stage;
    private TextField trainIdField;
    private TextField departureCityField;
    private TextField departureDateField;
    private TextField departureTimeField;
    private TextField arrivalCityField;
    private TextField arrivalDateField;
    private TextField arrivalTimeField;
    private TextField availableSeatsField;
    private TextField totalSeatsField;
    private TextField basePriceField;
    private CreateTripFormController controller;

    public void setController(CreateTripFormController controller) {
        this.controller = controller;
    }

    public void display(Stage primaryStage) {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.setTitle("Create Trip");

        Label headlineLabel = new Label("Create New Trip");
        headlineLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label trainIdLabel = new Label("train_id:");
        Label departureCityLabel = new Label("departure_city:");
        Label departureDateLabel = new Label("departure_date:");
        Label departureTimeLabel = new Label("departure_time:");
        Label arrivalCityLabel = new Label("arrival_city:");
        Label arrivalDateLabel = new Label("arrival_date:");
        Label arrivalTimeLabel = new Label("arrival_time:");
        Label availableSeatsLabel = new Label("available_seats:");
        Label totalSeatsLabel = new Label("total_seats:");
        Label basePriceLabel = new Label("base_price:");

        trainIdField = new TextField();
        departureCityField = new TextField();
        departureDateField = new TextField();
        departureTimeField = new TextField();
        arrivalCityField = new TextField();
        arrivalDateField = new TextField();
        arrivalTimeField = new TextField();
        availableSeatsField = new TextField();
        totalSeatsField = new TextField();
        basePriceField = new TextField();

        Button createButton = new Button("Create");
        createButton.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        createButton.setOnAction(e -> controller.createTrip());

        createButton.disableProperty().bind(Bindings.createBooleanBinding(() ->
                                trainIdField.getText().isEmpty() ||
                                departureCityField.getText().isEmpty() ||
                                departureDateField.getText().isEmpty() ||
                                departureTimeField.getText().isEmpty() ||
                                arrivalCityField.getText().isEmpty() ||
                                arrivalDateField.getText().isEmpty() ||
                                arrivalTimeField.getText().isEmpty() ||
                                availableSeatsField.getText().isEmpty() ||
                                totalSeatsField.getText().isEmpty() ||
                                basePriceField.getText().isEmpty(),
                trainIdField.textProperty(),
                departureCityField.textProperty(),
                departureDateField.textProperty(),
                departureTimeField.textProperty(),
                arrivalCityField.textProperty(),
                arrivalDateField.textProperty(),
                arrivalTimeField.textProperty(),
                availableSeatsField.textProperty(),
                totalSeatsField.textProperty(),
                basePriceField.textProperty()));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(10, 20, 10, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(headlineLabel, 0, 0, 2, 1);
        gridPane.add(trainIdLabel, 0, 1);
        gridPane.add(trainIdField, 1, 1);
        gridPane.add(departureCityLabel, 0, 2);
        gridPane.add(departureCityField, 1, 2);
        gridPane.add(departureDateLabel, 0, 3);
        gridPane.add(departureDateField, 1, 3);
        gridPane.add(departureTimeLabel, 0, 4);
        gridPane.add(departureTimeField, 1, 4);
        gridPane.add(arrivalCityLabel, 0, 5);
        gridPane.add(arrivalCityField, 1, 5);
        gridPane.add(arrivalDateLabel, 0, 6);
        gridPane.add(arrivalDateField, 1, 6);
        gridPane.add(arrivalTimeLabel, 0, 7);
        gridPane.add(arrivalTimeField, 1, 7);
        gridPane.add(availableSeatsLabel, 0, 8);
        gridPane.add(availableSeatsField, 1, 8);
        gridPane.add(totalSeatsLabel, 0, 9);
        gridPane.add(totalSeatsField, 1, 9);
        gridPane.add(basePriceLabel, 0, 10);
        gridPane.add(basePriceField, 1, 10);
        gridPane.add(createButton, 0, 11, 2, 1);
        GridPane.setHalignment(createButton, javafx.geometry.HPos.RIGHT);

        javafx.scene.layout.ColumnConstraints column1 = new javafx.scene.layout.ColumnConstraints();
        column1.setPercentWidth(30);
        javafx.scene.layout.ColumnConstraints column2 = new javafx.scene.layout.ColumnConstraints();
        column2.setPercentWidth(70);
        gridPane.getColumnConstraints().addAll(column1, column2);

        javafx.scene.layout.RowConstraints rowConstraints = new javafx.scene.layout.RowConstraints();
        rowConstraints.setPrefHeight(30);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        stage.setHeight(ScreenBounds.getWindowHeight(0.6));
        stage.setMinHeight(ScreenBounds.getWindowHeight(0.6));
        stage.setWidth(ScreenBounds.getWindowWidth(0.4));
        stage.setMinWidth(ScreenBounds.getWindowWidth(0.4));

        stage.showAndWait();
    }

    public Integer getTrainId() {
        return Integer.parseInt(trainIdField.getText());
    }

    public Integer getDepartureCity() {
        return Integer.parseInt(departureCityField.getText());
    }

    public String getDepartureDate() {
        return departureDateField.getText();
    }

    public String getDepartureTime() {
        return departureTimeField.getText();
    }

    public Integer getArrivalCity() {
        return Integer.parseInt(arrivalCityField.getText());
    }

    public String getArrivalDate() {
        return arrivalDateField.getText();
    }

    public String getArrivalTime() {
        return arrivalTimeField.getText();
    }

    public Integer getAvailableSeats() {
        return Integer.parseInt(availableSeatsField.getText());
    }

    public Integer getTotalSeats() {
        return Integer.parseInt(totalSeatsField.getText());
    }

    public Double getBasePrice() {
        return Double.parseDouble(basePriceField.getText());
    }

    public void close() {
        stage.close();
    }

    public void displayErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
