package com.example.moviesAPI.controller;

import com.example.moviesAPI.model.Movie;
import com.example.moviesAPI.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> get(@PathVariable Integer id){
        try{
            Movie movie = movieService.getMovieById(id);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
        public List<Movie> getByName(@PathVariable String name){
        return movieService.getMovieByName(name);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getByGenre(@PathVariable String genre){
        return movieService.getMovieByGenre(genre);
    }

    @GetMapping("/duration/{duration}")
    public List<Movie> getByDuration(@PathVariable Integer duration){
        return movieService.getMovieByDuration(duration);
    }

    @GetMapping("/release/{release}")
    public List<Movie> getByRelease(@PathVariable Integer release){
        return movieService.getMovieByRelease(release);
    }

    @PostMapping("/")
    public void add(@RequestBody Movie movie){
        movieService.saveMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable Integer id){
        try{
            Movie baseMovie = movieService.getMovieById(id);
            baseMovie.updateMovie(movie);
            movieService.saveMovie(baseMovie);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
