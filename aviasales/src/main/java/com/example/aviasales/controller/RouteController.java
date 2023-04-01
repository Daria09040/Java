package com.example.aviasales.controller;

import com.example.aviasales.model.Route;
import com.example.aviasales.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("")
    public List<Route> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> get(@PathVariable Integer id){
        try{
            Route route = routeService.getRouteById(id);
            return new ResponseEntity<Route>(route, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Route route){
        routeService.saveRoute(route);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        routeService.deleteRoute(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Route route, @PathVariable Integer id){
        try{
            Route baseRoute = routeService.getRouteById(id);
            baseRoute.updateRoute(route);
            routeService.saveRoute(baseRoute);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
