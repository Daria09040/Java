package com.example.bookingsBackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="additionalService")
@Data
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double pricePerDay;

    @ManyToMany(mappedBy = "additionalServiceSet")
    private Set<Booking> bookingSet;

    public void updateAdditionalService(AdditionalService additionalService){
        if(additionalService.name != null){
            this.name = additionalService.name;
        }
        if(additionalService.pricePerDay != null){
            this.pricePerDay = additionalService.pricePerDay;
        }
    }

}
