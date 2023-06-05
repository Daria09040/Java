package com.example.tripsBackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name="trip")
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="trainId", nullable = false)
    private Train trainId;

    @ManyToOne
    @JoinColumn(name="departureCity", nullable = false)
    private City departureCity;

    @ManyToOne
    @JoinColumn(name="arrivalCity", nullable = false)
    private City arrivalCity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate departureDate, arrivalDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime departureTime, arrivalTime;

    private Integer availableSeats, totalSeats;

    private Double basePrice;

    public void updateTrip(Trip trip){
        if(trip.trainId != null){
            this.trainId = trip.trainId;
        }
        if(trip.departureCity != null){
            this.departureCity = trip.departureCity;
        }
        if(trip.arrivalCity != null){
            this.arrivalCity = trip.arrivalCity;
        }
        if(trip.departureDate != null){
            this.departureDate = trip.departureDate;
        }
        if(trip.arrivalDate != null){
            this.arrivalDate = trip.arrivalDate;
        }
        if(trip.departureTime != null){
            this.departureTime = trip.departureTime;
        }
        if(trip.arrivalTime != null){
            this.arrivalTime = trip.arrivalTime;
        }
        if(trip.availableSeats != null){
            this.availableSeats = trip.availableSeats;
        }
        if(trip.totalSeats != null){
            this.totalSeats = trip.totalSeats;
        }
        if(trip.basePrice != null){
            this.basePrice = trip.basePrice;
        }
    }
}
