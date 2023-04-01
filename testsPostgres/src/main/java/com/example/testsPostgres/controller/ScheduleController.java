package com.example.testsPostgres.controller;

import com.example.testsPostgres.model.Schedule;
import com.example.testsPostgres.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/tests")
    public ResponseEntity<List<Schedule>> getTests(){
        return ResponseEntity.ok(this.scheduleRepository.findAllByRowIDAndUserID(2L, 2L));
    }
}
