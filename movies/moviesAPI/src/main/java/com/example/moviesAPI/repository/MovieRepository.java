package com.example.moviesAPI.repository;

import com.example.moviesAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByName(String name);
    List<Movie> findByGenre(String genre);
    List<Movie> findByDuration(Integer duration);
    List<Movie> findByRelease(Integer release);
}
