package com.example.restfullPgSQL.controller;

import com.example.restfullPgSQL.model.Train;
import com.example.restfullPgSQL.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping("")
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> get(@PathVariable Integer id){
        try{
            Train train = trainService.getTrainById(id);
            return new ResponseEntity<Train>(train, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<Train> getByName(@PathVariable String name){
        return trainService.getTrainByName(name);
    }

    @GetMapping("/number/{number}")
    public List<Train> getByNumber(@PathVariable String number){
        return trainService.getTrainByNumber(number);
    }

    @GetMapping("/type/{type}")
    public List<Train> getByTypeId(@PathVariable int type){
        return trainService.getTrainByTypeId(type);
    }

    @PostMapping("/")
    public void add(@RequestBody Train train){
        trainService.saveTrain(train);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        trainService.deleteTrain(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Train train, @PathVariable Integer id){
        try{
            Train baseTrain = trainService.getTrainById(id);
            baseTrain.updateTrain(train);
            trainService.saveTrain(baseTrain);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
