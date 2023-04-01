package com.example.restfullPgSQL.repository;
import com.example.restfullPgSQL.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    List<Type> findByName(String name);
}
