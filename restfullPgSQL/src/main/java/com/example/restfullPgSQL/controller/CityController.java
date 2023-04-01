package com.example.restfullPgSQL.controller;

import com.example.restfullPgSQL.model.City;
import com.example.restfullPgSQL.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> get(@PathVariable Integer id){
        try{
            City city = cityService.getCityById(id);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<City> getByName(@PathVariable String name){
        return cityService.getCityByName(name);
    }

    @PostMapping("/")
    public void add(@RequestBody City city){
        cityService.saveCity(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody City city, @PathVariable Integer id){
        try{
            City baseCity = cityService.getCityById(id);
            baseCity.updateCity(city);
            cityService.saveCity(baseCity);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
