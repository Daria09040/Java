package com.example.aviasales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity(name="route")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="cityFrom", nullable = false)
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name="cityTo", nullable = false)
    private City cityTo;

    @OneToMany(mappedBy = "routeId")
    @JsonIgnore
    private Set<Flight> flightsRoute;

    public void updateRoute(Route route){
        if(route.flightsRoute != null){
            this.flightsRoute = route.flightsRoute;
        }
        if(route.cityFrom != null){
            this.cityFrom = route.cityFrom;
        }
        if(route.cityTo != null){
            this.cityTo = route.cityTo;
        }
    }

}
