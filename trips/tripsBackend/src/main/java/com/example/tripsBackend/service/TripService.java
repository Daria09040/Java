package com.example.tripsBackend.service;

import com.example.tripsBackend.model.City;
import com.example.tripsBackend.model.Train;
import com.example.tripsBackend.model.Trip;
import com.example.tripsBackend.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public List<Trip> getTripByTrainId(Train trainId){
        return tripRepository.findByTrainId(trainId);
    }

    public List<Trip> getTripByDepartureCityId(City departureCity){
        return tripRepository.findByDepartureCity(departureCity);
    }

    public List<Trip> getTripByArrivalCityId(City arrivalCity){
        return tripRepository.findByArrivalCity(arrivalCity);
    }

    public List<Trip> getTripByDepartureDate(LocalDate departureDate){
        return tripRepository.findByDepartureDate(departureDate);
    }

    public List<Trip> getTripByArrivalDate(LocalDate arrivalDate){
        return tripRepository.findByArrivalDate(arrivalDate);
    }

    public List<Trip> getTripByDepartureTime(LocalTime departureTime){
        return tripRepository.findByDepartureTime(departureTime);
    }

    public List<Trip> getTripByArrivalTime(LocalTime arrivalTime){
        return tripRepository.findByArrivalTime(arrivalTime);
    }

    public List<Trip> getTripByAvailableSeats(Integer availableSeats){
        return tripRepository.findByAvailableSeats(availableSeats);
    }

    public List<Trip> getTripByTotalSeats(Integer totalSeats){
        return tripRepository.findByTotalSeats(totalSeats);
    }

    public List<Trip> getTripByBasePrice(Double basePrice){
        return tripRepository.findByBasePrice(basePrice);
    }

    public void saveTrip(Trip trip){
        tripRepository.save(trip);
    }

    public void deleteTrip(Integer id){
        tripRepository.deleteById(id);
    }

    public Trip getTripById(Integer id){
        return tripRepository.findById(id).orElse(null);
    }
}
