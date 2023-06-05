package com.example.tripsBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="train_type")
@Data
public class TrainType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "trainTypeId")
    @JsonIgnore
    private Set<Train> trainSet;

    public void updateType(TrainType trainType){
        if(trainType.name != null){
            this.name = trainType.name;
        }
    }
}
