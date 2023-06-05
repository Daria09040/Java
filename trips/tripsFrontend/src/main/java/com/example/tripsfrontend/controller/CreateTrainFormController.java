package com.example.tripsfrontend.controller;

import com.example.tripsfrontend.http.HttpRequestHandler;
import com.example.tripsfrontend.model.Train;
import com.example.tripsfrontend.model.TrainType;
import com.example.tripsfrontend.view.CreateTrainFormView;

public class CreateTrainFormController {
    private CreateTrainFormView createTrainFormView;
    private final HttpRequestHandler httpRequestHandler;

    public CreateTrainFormController() {
        httpRequestHandler = new HttpRequestHandler();
    }

    public void setView(CreateTrainFormView createTrainFormView) {
        this.createTrainFormView = createTrainFormView;
    }

    public void createTrain() {
        try {
            validateFormFields();

            TrainType trainType = new TrainType();
            trainType.setId(createTrainFormView.getTrainTypeId());

            Train newTrain = new Train(
                    trainType,
                    createTrainFormView.getNumber(),
                    createTrainFormView.getName(),
                    createTrainFormView.getCarCount(),
                    createTrainFormView.getSeatsPerCar());

            httpRequestHandler.addTrain(newTrain);

            createTrainFormView.close();
        } catch (IllegalArgumentException e) {
            createTrainFormView.displayErrorMessage(e.getMessage());
        }
    }

    private void validateFormFields() {
        Integer trainTypeId = createTrainFormView.getTrainTypeId();
        Integer carCount = createTrainFormView.getCarCount();
        Integer seatsPerCar = createTrainFormView.getSeatsPerCar();

        if (trainTypeId <= 0) {
            throw new IllegalArgumentException("train_type_id must be a positive integer.");
        }

        if (carCount <= 0) {
            throw new IllegalArgumentException("car_count must be a positive integer.");
        }

        if (seatsPerCar <= 0) {
            throw new IllegalArgumentException("seats_per_car must be a positive integer.");
        }
    }
}
