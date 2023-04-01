package com.example.aviasales.service;

import com.example.aviasales.model.Route;
import com.example.aviasales.repository.RouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

    public void saveRoute(Route route){
        routeRepository.save(route);
    }

    public void deleteRoute(Integer id){
        routeRepository.deleteById(id);
    }

    public Route getRouteById(Integer id){
        return routeRepository.findById(id).orElse(null);
    }
}
