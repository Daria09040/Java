package com.example.restfullPgSQL.controller;

import com.example.restfullPgSQL.model.Type;
import com.example.restfullPgSQL.service.TrainService;
import com.example.restfullPgSQL.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private TrainService trainService;

    @GetMapping("")
    public List<Type> getAllTypes(){
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> get(@PathVariable Integer id){
        try{
            Type type = typeService.getTypeById(id);
            return new ResponseEntity<Type>(type, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<Type> getByName(@PathVariable String name){
        return typeService.getTypeByName(name);
    }

    @PostMapping("/")
    public void add(@RequestBody Type type){
        typeService.saveType(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        typeService.deleteType(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Type type, @PathVariable Integer id){
        try{
            Type baseType = typeService.getTypeById(id);
            baseType.updateType(type);
            typeService.saveType(baseType);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
