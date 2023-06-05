package com.example.tripsfrontend.controller;

import com.example.tripsfrontend.http.HttpRequestHandler;
import com.example.tripsfrontend.model.Train;
import com.example.tripsfrontend.model.Trip;
import javafx.scene.control.TableView;

import java.util.List;

public class TrainTripFXController {
    private final TableView<Trip> tripTableView;
    private final TableView<Train> trainTableView;
    private final HttpRequestHandler httpRequestHandler;

    public TrainTripFXController(TableView<Trip> tripTableView, TableView<Train> trainTableView) {
        this.tripTableView = tripTableView;
        this.trainTableView = trainTableView;
        httpRequestHandler = new HttpRequestHandler();
    }

    public void initialize() {
        fetchTrips();
        fetchTrains();
    }

    private void fetchTrips() {
        List<Trip> trips = httpRequestHandler.getAllTrips();
        updateTripTableView(trips);
    }

    private void updateTripTableView(List<Trip> trips) {
        tripTableView.getItems().clear();
        tripTableView.getItems().addAll(trips);
    }

    private void fetchTrains() {
        List<Train> trains = httpRequestHandler.getAllTrains();
        updateTrainTableView(trains);
    }

    private void updateTrainTableView(List<Train> trains) {
        trainTableView.getItems().clear();
        trainTableView.getItems().addAll(trains);
    }
}
