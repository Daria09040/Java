package com.example.moviesAPI.service;

import com.example.moviesAPI.model.Movie;
import com.example.moviesAPI.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> getMovieByName(String name){
        return movieRepository.findByName(name);
    }

    public List<Movie> getMovieByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getMovieByDuration(Integer duration){
        return movieRepository.findByDuration(duration);
    }

    public List<Movie> getMovieByRelease(Integer release){
        return movieRepository.findByRelease(release);
    }

    public void saveMovie(Movie Movie){
        movieRepository.save(Movie);
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }

    public Movie getMovieById(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

}
