package com.example.restfullPgSQL.repository;

import com.example.restfullPgSQL.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Integer> {
        List<Train> findByName(String name);
        List<Train> findByNumber(String number);
        List<Train> findByTypeId(int type);
}
