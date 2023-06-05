package com.example.tripsBackend.repository;

import com.example.tripsBackend.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByName(String name);
}
