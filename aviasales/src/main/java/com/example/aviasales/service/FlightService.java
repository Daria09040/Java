package com.example.aviasales.service;

import com.example.aviasales.model.Flight;
import com.example.aviasales.repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void deleteFlight(Integer id){
        flightRepository.deleteById(id);
    }

    public Flight getFlightById(Integer id){
        return flightRepository.findById(id).orElse(null);
    }
}
