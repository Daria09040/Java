package com.example.tripsfrontend.model;

public class TrainType {
    private Integer id;
    private String name;

    public TrainType() {
    }

    public TrainType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
