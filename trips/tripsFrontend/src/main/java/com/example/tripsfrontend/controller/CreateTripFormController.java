package com.example.tripsfrontend.controller;

import com.example.tripsfrontend.http.HttpRequestHandler;
import com.example.tripsfrontend.model.City;
import com.example.tripsfrontend.model.Train;
import com.example.tripsfrontend.model.Trip;
import com.example.tripsfrontend.view.CreateTripFormView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CreateTripFormController {
    private CreateTripFormView createTripFormView;
    private final HttpRequestHandler httpRequestHandler;

    public CreateTripFormController() {
        httpRequestHandler = new HttpRequestHandler();
    }

    public void setView(CreateTripFormView createTripFormView) {
        this.createTripFormView = createTripFormView;
    }

    public void createTrip() {
        try {
            validateFormFields();

            Train train = new Train();
            train.setId(createTripFormView.getTrainId());

            City departureCity = new City();
            departureCity.setId(createTripFormView.getDepartureCity());

            City arrivalCity = new City();
            arrivalCity.setId(createTripFormView.getArrivalCity());

            Trip newTrip = new Trip(
                    train,
                    departureCity,
                    arrivalCity,
                    LocalDate.parse(createTripFormView.getDepartureDate(), httpRequestHandler.localDateFormatter),
                    LocalTime.parse(createTripFormView.getDepartureTime(), httpRequestHandler.localTimeFormatter),
                    LocalDate.parse(createTripFormView.getArrivalDate(), httpRequestHandler.localDateFormatter),
                    LocalTime.parse(createTripFormView.getArrivalTime(), httpRequestHandler.localTimeFormatter),
                    createTripFormView.getAvailableSeats(),
                    createTripFormView.getTotalSeats(),
                    createTripFormView.getBasePrice());
            httpRequestHandler.addTrip(newTrip);

            createTripFormView.close();
        } catch (IllegalArgumentException e) {
            createTripFormView.displayErrorMessage(e.getMessage());
        }
    }

    private void validateFormFields() {
        Integer trainId = createTripFormView.getTrainId();
        Integer departureCity = createTripFormView.getDepartureCity();
        String departureDate = createTripFormView.getDepartureDate();
        String departureTime = createTripFormView.getDepartureTime();
        Integer arrivalCity = createTripFormView.getArrivalCity();
        String arrivalDate = createTripFormView.getArrivalDate();
        String arrivalTime = createTripFormView.getArrivalTime();
        Integer availableSeats = createTripFormView.getAvailableSeats();
        Integer totalSeats = createTripFormView.getTotalSeats();
        Double basePrice = createTripFormView.getBasePrice();

        if (trainId <= 0) {
            throw new IllegalArgumentException("train_id must be a positive integer.");
        }

        if (departureCity <= 0) {
            throw new IllegalArgumentException("departure_city must be a positive integer.");
        }

        if (arrivalCity <= 0) {
            throw new IllegalArgumentException("arrival_city must be a positive integer.");
        }

        if (availableSeats <= 0) {
            throw new IllegalArgumentException("available_seats must be a positive integer.");
        }

        if (totalSeats <= 0) {
            throw new IllegalArgumentException("total_seats must be a positive integer.");
        }

        if (basePrice <= 0) {
            throw new IllegalArgumentException("base_price must be a positive number.");
        }

        try {
            LocalDate.parse(departureDate, httpRequestHandler.localDateFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for departure_date. Expected format: dd.MM.yyyy");
        }

        try {
            LocalTime.parse(departureTime, httpRequestHandler.localTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for departure_time. Expected format: HH:mm");
        }

        try {
            LocalDate.parse(arrivalDate, httpRequestHandler.localDateFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for arrival_date. Expected format: dd.MM.yyyy");
        }

        try {
            LocalTime.parse(arrivalTime, httpRequestHandler.localTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for arrival_time. Expected format: HH:mm");
        }

        LocalDateTime departureDateTime;
        LocalDateTime arrivalDateTime;

        try {
            departureDateTime = LocalDateTime.parse(departureDate + " " + departureTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            arrivalDateTime = LocalDateTime.parse(arrivalDate + " " + arrivalTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

            if (arrivalDateTime.isBefore(departureDateTime)) {
                throw new IllegalArgumentException("Arrival date and time must be after departure date and time.");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for date or time.");
        }

    }

}
