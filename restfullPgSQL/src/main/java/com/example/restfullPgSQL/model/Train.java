package com.example.restfullPgSQL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="train")
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, number;

    @ManyToOne
    @JoinColumn(name="typeId", nullable = false)
    private Type type;

    @OneToMany(mappedBy = "train")
    @JsonIgnore
    private Set<Schedule> schedulesTrain;

    public void updateTrain(Train train){
        if(train.name != null){
            this.name = train.name;
        }
        if(train.type != null){
            this.type = train.type;
        }
        if(train.number != null){
            this.number = train.number;
        }
    }
}
