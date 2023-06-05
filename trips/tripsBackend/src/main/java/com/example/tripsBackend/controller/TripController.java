package com.example.tripsBackend.controller;

import com.example.tripsBackend.model.City;
import com.example.tripsBackend.model.Train;
import com.example.tripsBackend.model.Trip;
import com.example.tripsBackend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("")
    public List<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> get(@PathVariable Integer id){
        try{
            Trip trip = tripService.getTripById(id);
            return new ResponseEntity<Trip>(trip, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/train_id/{trainId}")
    public List<Trip> getByTrainId(@PathVariable Train trainId){
        return tripService.getTripByTrainId(trainId);
    }

    @GetMapping("/departure_city/{departureCityId}")
    public List<Trip> getByDepartureCity(@PathVariable City departureCityId){
        return tripService.getTripByDepartureCityId(departureCityId);
    }

    @GetMapping("/arrival_city/{arrivalCityId}")
    public List<Trip> getByArrivalCity(@PathVariable City arrivalCityId){
        return tripService.getTripByArrivalCityId(arrivalCityId);
    }

    @GetMapping("/departure_date/{departureDate}")
    public List<Trip> getByDepartureDate(@PathVariable String departureDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate _departureDate = LocalDate.parse(departureDate, formatter);
        return tripService.getTripByDepartureDate(_departureDate);
    }

    @GetMapping("/arrival_date/{arrivalDate}")
    public List<Trip> getByArrivalDate(@PathVariable String arrivalDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate _arrivalDate = LocalDate.parse(arrivalDate, formatter);
        return tripService.getTripByArrivalDate(_arrivalDate);
    }

    @GetMapping("/departure_time/{departureTime}")
    public List<Trip> getByDepartureTime(@PathVariable String departureTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime _departureTime = LocalTime.parse(departureTime, formatter);
        return tripService.getTripByDepartureTime(_departureTime);
    }

    @GetMapping("/arrival_time/{arrivalTime}")
    public List<Trip> getByArrivalTime(@PathVariable String arrivalTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime _arrivalTime = LocalTime.parse(arrivalTime, formatter);
        return tripService.getTripByArrivalTime(_arrivalTime);
    }

    @GetMapping("/available_seats/{availableSeats}")
    public List<Trip> getByAvailableSeats(@PathVariable Integer availableSeats){
        return tripService.getTripByAvailableSeats(availableSeats);
    }

    @GetMapping("/total_seats/{totalSeats}")
    public List<Trip> getByTotalSeats(@PathVariable Integer totalSeats){
        return tripService.getTripByTotalSeats(totalSeats);
    }

    @GetMapping("/base_price/{basePrice}")
    public List<Trip> getByTotalSeats(@PathVariable Double basePrice){
        return tripService.getTripByBasePrice(basePrice);
    }

    @PostMapping("/")
    public void add(@RequestBody Trip trip){
        tripService.saveTrip(trip);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        tripService.deleteTrip(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Trip trip, @PathVariable Integer id){
        try{
            Trip baseTrip = tripService.getTripById(id);
            baseTrip.updateTrip(trip);
            tripService.saveTrip(baseTrip);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
