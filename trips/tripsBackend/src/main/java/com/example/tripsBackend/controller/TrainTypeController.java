package com.example.tripsBackend.controller;

import com.example.tripsBackend.model.TrainType;
import com.example.tripsBackend.service.TrainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/train_types")
public class TrainTypeController {
    @Autowired
    private TrainTypeService trainTypeService;

    @GetMapping("")
    public List<TrainType> getAllTypes(){
        return trainTypeService.getAllTrainTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainType> get(@PathVariable Integer id){
        try{
            TrainType trainType = trainTypeService.getTrainTypeById(id);
            return new ResponseEntity<TrainType>(trainType, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<TrainType>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<TrainType> getByName(@PathVariable String name){
        return trainTypeService.getTrainTypeByName(name);
    }

    @PostMapping("/")
    public void add(@RequestBody TrainType trainType){
        trainTypeService.saveTrainType(trainType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        trainTypeService.deleteTrainType(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TrainType trainType, @PathVariable Integer id){
        try{
            TrainType baseTrainType = trainTypeService.getTrainTypeById(id);
            baseTrainType.updateType(trainType);
            trainTypeService.saveTrainType(baseTrainType);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
