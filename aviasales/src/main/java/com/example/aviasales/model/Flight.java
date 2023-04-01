package com.example.aviasales.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity(name="flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String aviaName;
    private int duration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="routeId", nullable = false)
    private Route routeId;

    public void updateFlight(Flight flight){
        if(flight.duration != 0){
            this.duration = flight.duration;
        }
        if(flight.aviaName != null){
            this.aviaName = flight.aviaName;
        }
        if(flight.dateTime != null){
            this.dateTime = flight.dateTime;
        }
    }
}


