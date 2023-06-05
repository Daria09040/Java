package com.example.bookingsBackend.repository;

import com.example.bookingsBackend.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    List<RoomType> findByName(String name);
}
