package com.example.testsPostgres.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {
    @GetMapping("/buy")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Buy %s!", name);
    }
}
