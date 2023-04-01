package com.example.aviasales.service;

import com.example.aviasales.model.City;
import com.example.aviasales.repository.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public void saveCity(City city){
        cityRepository.save(city);
    }

    public void deleteCity(Integer id){
        cityRepository.deleteById(id);
    }

    public City getCityById(Integer id){
        return cityRepository.findById(id).orElse(null);
    }
}
