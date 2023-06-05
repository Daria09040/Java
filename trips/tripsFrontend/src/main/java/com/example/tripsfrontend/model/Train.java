package com.example.tripsfrontend.model;

public class Train {
    private Integer id;
    private Integer carCount;
    private Integer seatsPerCar;
    private String name;
    private String number;
    private TrainType trainTypeId;

    public Train() {
    }

    public Train(TrainType trainTypeId,
                 String number,
                 String name,
                 Integer carCount,
                 Integer seatsPerCar) {
        this.carCount = carCount;
        this.seatsPerCar = seatsPerCar;
        this.name = name;
        this.number = number;
        this.trainTypeId = trainTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public Integer getSeatsPerCar() {
        return seatsPerCar;
    }

    public void setSeatsPerCar(Integer seatsPerCar) {
        this.seatsPerCar = seatsPerCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TrainType getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(TrainType trainTypeId) {
        this.trainTypeId = trainTypeId;
    }
}
