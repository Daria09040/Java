package com.example.tripsBackend.repository;

import com.example.tripsBackend.model.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainTypeRepository extends JpaRepository<TrainType, Integer> {
    List<TrainType> findByName(String name);
}
