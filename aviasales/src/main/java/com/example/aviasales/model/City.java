package com.example.aviasales.model;

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
    private Set<Route> routesCityTo;

    @OneToMany(mappedBy = "cityFrom")
    @JsonIgnore
    private Set<Route> routesCityFrom;

    public void updateCity(City city){
        if(city.name != null){
            this.name = city.name;
        }
    }
}
