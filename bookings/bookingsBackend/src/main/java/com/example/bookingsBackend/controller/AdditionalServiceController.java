package com.example.bookingsBackend.controller;

import com.example.bookingsBackend.model.AdditionalService;
import com.example.bookingsBackend.service.AdditionalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/additional-services")
public class AdditionalServiceController {
    @Autowired
    private AdditionalServiceService additionalServiceService;

    @GetMapping("")
    public List<AdditionalService> getAllAdditionalServices(){
        return additionalServiceService.getAllAdditionalServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdditionalService> get(@PathVariable Integer id){
        try{
            AdditionalService additionalService = additionalServiceService.getAdditionalServiceById(id);
            return new ResponseEntity<AdditionalService>(additionalService, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<AdditionalService>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<AdditionalService> getByName(@PathVariable String name){
        return additionalServiceService.getAdditionalServiceByName(name);
    }

    @GetMapping("/price-per-day/{pricePerDay}")
    public List<AdditionalService> getByPricePerDay(@PathVariable Double pricePerDay){
        return additionalServiceService.getAdditionalServiceByPricePerDay(pricePerDay);
    }

    @PostMapping("/")
    public void add(@RequestBody AdditionalService additionalService){
        additionalServiceService.saveAdditionalService(additionalService);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        additionalServiceService.deleteAdditionalService(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AdditionalService additionalService, @PathVariable Integer id){
        try{
            AdditionalService baseAdditionalService = additionalServiceService.getAdditionalServiceById(id);
            baseAdditionalService.updateAdditionalService(additionalService);
            additionalServiceService.saveAdditionalService(baseAdditionalService);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
