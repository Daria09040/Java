package com.example.restfullPgSQL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="city")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "cityTo")
    @JsonIgnore
    private Set<Schedule> schedulesCityTo;

    @OneToMany(mappedBy = "cityFrom")
    @JsonIgnore
    private Set<Schedule> schedulesCityFrom;

    public void updateCity(City city){
        if(city.name != null){
            this.name = city.name;
        }
    }
}
