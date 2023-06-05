package com.example.tripsBackend.repository;

import com.example.tripsBackend.model.Train;
import com.example.tripsBackend.model.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Integer> {
    List<Train> findByName(String name);
    List<Train> findByNumber(String number);
    List<Train> findByTrainTypeId(TrainType trainTypeId);
    List<Train> findByCarCount(Integer carCount);
    List<Train> findBySeatsPerCar(Integer seatsPerCar);
}
