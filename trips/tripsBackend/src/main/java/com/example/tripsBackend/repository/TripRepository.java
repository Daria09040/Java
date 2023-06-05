package com.example.tripsBackend.repository;

import com.example.tripsBackend.model.City;
import com.example.tripsBackend.model.Train;
import com.example.tripsBackend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findByTrainId(Train trainId);
    List<Trip> findByDepartureCity(City departureCityId);
    List<Trip> findByArrivalCity(City arrivalCityId);
    List<Trip> findByDepartureDate(LocalDate departureDate);
    List<Trip> findByArrivalDate(LocalDate arrivalDate);
    List<Trip> findByDepartureTime(LocalTime departureTime);
    List<Trip> findByArrivalTime(LocalTime arrivalTime);
    List<Trip> findByAvailableSeats(Integer availableSeats);
    List<Trip> findByTotalSeats(Integer totalSeats);
    List<Trip> findByBasePrice(Double basePrice);
}
