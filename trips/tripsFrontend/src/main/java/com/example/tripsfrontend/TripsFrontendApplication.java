package com.example.tripsfrontend;

import com.example.tripsfrontend.controller.CreateTrainFormController;
import com.example.tripsfrontend.controller.CreateTripFormController;
import com.example.tripsfrontend.controller.TrainTripFXController;
import com.example.tripsfrontend.model.Train;
import com.example.tripsfrontend.model.Trip;
import com.example.tripsfrontend.view.CreateTrainFormView;
import com.example.tripsfrontend.view.CreateTripFormView;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class TripsFrontendApplication extends Application {
    private Stage primaryStage;
    private TrainTripFXController trainTripFXController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Trips Frontend App");

        TableView<Trip> tripTableView = createTripTable();
        TableView<Train> trainTableView = createTrainTable();

        trainTripFXController = new TrainTripFXController(tripTableView, trainTableView);
        trainTripFXController.initialize();

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setTabMinWidth(100);

        Tab tripTab = createTab("Trips", "Trips", tripTableView, this::openCreateTripForm);
        tabPane.getTabs().add(tripTab);

        Tab trainTab = createTab("Trains", "Trains", trainTableView, this::openCreateTrainForm);
        tabPane.getTabs().add(trainTab);

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);

        primaryStage.setHeight(ScreenBounds.getWindowHeight(0.65));
        primaryStage.setMinHeight(ScreenBounds.getWindowHeight(0.65));
        primaryStage.setWidth(ScreenBounds.getWindowWidth(0.65));
        primaryStage.setMinWidth(ScreenBounds.getWindowWidth(0.65));

        primaryStage.show();
    }

    private HBox createHeaderBox(Label label, Button button) {
        label.setFont(Font.font("System", FontWeight.BOLD, 18));

        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.getChildren().add(label);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(buttonBox, Priority.ALWAYS);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        button.setFont(Font.font("System", FontWeight.BOLD, 14));

        buttonBox.getChildren().addAll(spacer, button);
        headerBox.getChildren().add(buttonBox);

        return headerBox;
    }

    private Tab createTab(String tabTitle, String headerLabelText, TableView<?> tableView, Runnable addButtonAction) {
        VBox tabVBox = new VBox(10);
        tabVBox.setPadding(new Insets(20));

        Label headerLabel = new Label(headerLabelText);
        Button addButton = new Button("+ Add New");
        addButton.setOnAction(e -> addButtonAction.run());
        HBox headerBox = createHeaderBox(headerLabel, addButton);

        tabVBox.getChildren().addAll(headerBox, tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);

        Tab tab = new Tab(tabTitle);
        tab.setContent(tabVBox);

        return tab;
    }

    private TableView<Trip> createTripTable() {
        TableView<Trip> table = new TableView<>();

        TableColumn<Trip, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getId()).asObject());

        TableColumn<Trip, Integer> trainIdColumn = new TableColumn<>("train_id");
        trainIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTrainId().getId()));

        TableColumn<Trip, Integer> departureCityIdColumn = new TableColumn<>("departure_city");
        departureCityIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartureCity().getId()));

        TableColumn<Trip, LocalDate> departureDateColumn = new TableColumn<>("departure_date");
        departureDateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartureDate()));

        TableColumn<Trip, LocalTime> departureTimeColumn = new TableColumn<>("departure_time");
        departureTimeColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartureTime()));

        TableColumn<Trip, Integer> arrivalCityIdColumn = new TableColumn<>("arrival_city");
        arrivalCityIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrivalCity().getId()));

        TableColumn<Trip, LocalDate> arrivalDateColumn = new TableColumn<>("arrival_date");
        arrivalDateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrivalDate()));

        TableColumn<Trip, LocalTime> arrivalTimeColumn = new TableColumn<>("arrival_time");
        arrivalTimeColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrivalTime()));

        TableColumn<Trip, Integer> availableSeatsColumn = new TableColumn<>("available_seats");
        availableSeatsColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getAvailableSeats()).asObject());

        TableColumn<Trip, Integer> totalSeatsColumn = new TableColumn<>("total_seats");
        totalSeatsColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getTotalSeats()).asObject());

        TableColumn<Trip, Double> basePriceColumn = new TableColumn<>("base_price");
        basePriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getBasePrice()).asObject());

        List<TableColumn<Trip, ?>> columns = Arrays.asList(
                idColumn,
                trainIdColumn,
                departureCityIdColumn,
                departureDateColumn,
                departureTimeColumn,
                arrivalCityIdColumn,
                arrivalDateColumn,
                arrivalTimeColumn,
                availableSeatsColumn,
                totalSeatsColumn,
                basePriceColumn
                );
        table.getColumns().addAll(columns);

        return table;
    }

    private TableView<Train> createTrainTable() {
        TableView<Train> table = new TableView<>();

        TableColumn<Train, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());

        TableColumn<Train, String> numberColumn = new TableColumn<>("number");
        numberColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumber()));

        TableColumn<Train, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Train, Integer> trainTypeIdColumn = new TableColumn<>("train_type_id");
        trainTypeIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTrainTypeId().getId()));

        TableColumn<Train, Integer> carCountColumn = new TableColumn<>("car_count");
        carCountColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCarCount()).asObject());

        TableColumn<Train, Integer> seatsPerCarColumn = new TableColumn<>("seats_per_car");
        seatsPerCarColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getSeatsPerCar()).asObject());

        List<TableColumn<Train, ?>> columns = Arrays.asList(
                idColumn,
                numberColumn,
                nameColumn,
                trainTypeIdColumn,
                carCountColumn,
                seatsPerCarColumn
        );

        table.getColumns().addAll(columns);

        return table;
    }

    private void openCreateTripForm() {
        primaryStage.getScene().getRoot().setDisable(true);

        CreateTripFormController createTripFormController = new CreateTripFormController();
        CreateTripFormView createTripFormView = new CreateTripFormView();

        createTripFormController.setView(createTripFormView);
        createTripFormView.setController(createTripFormController);

        createTripFormView.display(primaryStage);
        enableMainWindow();
    }

    private void openCreateTrainForm() {
        primaryStage.getScene().getRoot().setDisable(true);

        CreateTrainFormController createTrainFormController = new CreateTrainFormController();
        CreateTrainFormView createTrainFormView = new CreateTrainFormView();

        createTrainFormController.setView(createTrainFormView);
        createTrainFormView.setController(createTrainFormController);

        createTrainFormView.display(primaryStage);
        enableMainWindow();
    }

    public void enableMainWindow() {
        primaryStage.getScene().getRoot().setDisable(false);
        primaryStage.getScene().getWindow().setOpacity(1.0);
        trainTripFXController.initialize();
    }
}
