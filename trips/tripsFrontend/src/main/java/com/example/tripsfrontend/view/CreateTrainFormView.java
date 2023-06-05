package com.example.tripsfrontend.view;

import com.example.tripsfrontend.ScreenBounds;
import com.example.tripsfrontend.controller.CreateTrainFormController;
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

public class CreateTrainFormView {
    private Stage stage;
    private TextField trainTypeIdField;
    private TextField numberField;
    private TextField nameField;
    private TextField carCountField;
    private TextField seatsPerCarField;
    private CreateTrainFormController controller;

    public void setController(CreateTrainFormController controller) {
        this.controller = controller;
    }

    public void display(Stage primaryStage) {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.setTitle("Create Train");

        Label headlineLabel = new Label("Create New Train");
        headlineLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label trainTypeIdLabel = new Label("train_type_id:");
        Label numberLabel = new Label("number:");
        Label nameLabel = new Label("name:");
        Label carCountLabel = new Label("car_count:");
        Label seatsPerCarLabel = new Label("seats_per_car:");

        trainTypeIdField = new TextField();
        numberField = new TextField();
        nameField = new TextField();
        carCountField = new TextField();
        seatsPerCarField = new TextField();

        Button createButton = new Button("Create");
        createButton.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        createButton.setOnAction(e -> controller.createTrain());

        createButton.disableProperty().bind(Bindings.createBooleanBinding(() ->
                        trainTypeIdField.getText().isEmpty() ||
                                numberField.getText().isEmpty() ||
                                nameField.getText().isEmpty() ||
                                carCountField.getText().isEmpty() ||
                                seatsPerCarField.getText().isEmpty(),
                trainTypeIdField.textProperty(),
                numberField.textProperty(),
                nameField.textProperty(),
                carCountField.textProperty(),
                seatsPerCarField.textProperty()));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(10, 20, 10, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(headlineLabel, 0, 0, 2, 1);
        gridPane.add(trainTypeIdLabel, 0, 1);
        gridPane.add(trainTypeIdField, 1, 1);
        gridPane.add(numberLabel, 0, 2);
        gridPane.add(numberField, 1, 2);
        gridPane.add(nameLabel, 0, 3);
        gridPane.add(nameField, 1, 3);
        gridPane.add(carCountLabel, 0, 4);
        gridPane.add(carCountField, 1, 4);
        gridPane.add(seatsPerCarLabel, 0, 5);
        gridPane.add(seatsPerCarField, 1, 5);
        gridPane.add(createButton, 0, 6, 2, 1);
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

    public Integer getTrainTypeId() {
        return Integer.parseInt(trainTypeIdField.getText());
    }

    public String getNumber() {
        return numberField.getText();
    }

    public String getName() {
        return nameField.getText();
    }

    public Integer getCarCount() {
        return Integer.parseInt(carCountField.getText());
    }

    public Integer getSeatsPerCar() {
        return Integer.parseInt(seatsPerCarField.getText());
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
