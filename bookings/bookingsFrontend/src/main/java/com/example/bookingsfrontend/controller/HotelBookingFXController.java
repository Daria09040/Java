package com.example.bookingsfrontend.controller;

import com.example.bookingsfrontend.http.HttpRequestHandler;
import com.example.bookingsfrontend.model.Booking;
import javafx.scene.control.TableView;

import java.util.List;

public class HotelBookingFXController {
    private final TableView<Booking> bookingTableView;
    private final HttpRequestHandler httpRequestHandler;

    public HotelBookingFXController(TableView<Booking> bookingTableView) {
        this.bookingTableView = bookingTableView;
        httpRequestHandler = new HttpRequestHandler();
    }

    public void initialize() {
        fetchBookings();
    }

    private void fetchBookings() {
        List<Booking> bookings = httpRequestHandler.getAllBookings();
        updateTableView(bookings);
    }

    private void updateTableView(List<Booking> bookings) {
        bookingTableView.getItems().clear();
        bookingTableView.getItems().addAll(bookings);
    }
}
