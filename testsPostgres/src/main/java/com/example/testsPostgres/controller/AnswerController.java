package com.example.testsPostgres.controller;

import com.example.testsPostgres.repository.AnswerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    private final AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @GetMapping("/answers")
    public ResponseEntity<List<Object[]>> getAnswers(){
        return ResponseEntity.ok(this.answerRepository.findAllByUserID(2L));
    }
}
