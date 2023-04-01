package com.example.restfullPgSQL.controller;

import com.example.restfullPgSQL.model.Schedule;
import com.example.restfullPgSQL.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("")
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> get(@PathVariable Integer id){
        try{
            Schedule schedule = scheduleService.getScheduleById(id);
            return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/from/{from}")
    public List<Schedule> getByCityFromId(@PathVariable int from){
        return scheduleService.getScheduleByCityFromId(from);
    }

    @GetMapping("/to/{to}")
    public List<Schedule> getByCityToId(@PathVariable int to){
        return scheduleService.getScheduleByCityToId(to);
    }

    @GetMapping("/train/{train}")
    public List<Schedule> getByTrainId(@PathVariable int train){
        return scheduleService.getScheduleByTrainId(train);
    }

    @GetMapping("/start/{start}")
    public List<Schedule> getByStartTime(@PathVariable String start){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime _start = LocalDateTime.parse(start, formatter);
        return scheduleService.getScheduleByStartTime(_start);
    }

    @GetMapping("/end/{end}")
    public List<Schedule> getByEndTime(@PathVariable String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime _end = LocalDateTime.parse(end, formatter);
        return scheduleService.getScheduleByEndTime(_end);
    }

    @PostMapping("/")
    public void add(@RequestBody Schedule schedule){
        scheduleService.saveSchedule(schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        scheduleService.deleteSchedule(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Schedule schedule, @PathVariable Integer id){
        try{
            Schedule baseSchedule = scheduleService.getScheduleById(id);
            baseSchedule.updateSchedule(schedule);
            scheduleService.saveSchedule(baseSchedule);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
