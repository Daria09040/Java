package com.example.aviasales.repository;

import com.example.aviasales.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
