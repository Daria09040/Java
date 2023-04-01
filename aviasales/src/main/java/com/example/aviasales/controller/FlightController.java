package com.example.aviasales.controller;

import com.example.aviasales.model.Flight;
import com.example.aviasales.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> get(@PathVariable Integer id){
        try{
            Flight flight = flightService.getFlightById(id);
            return new ResponseEntity<Flight>(flight, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Flight flight){
        flightService.saveFlight(flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        flightService.deleteFlight(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Flight flight, @PathVariable Integer id){
        try{
            Flight baseFlight = flightService.getFlightById(id);
            baseFlight.updateFlight(flight);
            flightService.saveFlight(baseFlight);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
