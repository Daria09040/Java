package com.example.restfullPgSQL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="type")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Train> trains;

    public void updateType(Type type){
        if(type.name != null){
            this.name = type.name;
        }
    }
}
