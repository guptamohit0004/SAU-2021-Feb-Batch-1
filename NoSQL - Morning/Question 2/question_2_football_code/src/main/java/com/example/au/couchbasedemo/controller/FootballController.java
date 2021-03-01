package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Football;
import com.example.au.couchbasedemo.repository.FootballRepository;

@RestController
public class FootballController {
    @Autowired
    FootballRepository footballRepository;
    @PostMapping("/footballdetails")
    public Football addPlayer(@RequestBody Football player) {
        return footballRepository.save(player);
    }
    @DeleteMapping("/footballdetails/{id}")
    public String deleteById(@PathVariable String id) {
        footballRepository.deleteById(id);
        return "Deleted Player";
    }
    @GetMapping("/footballdetails/{id}")
    public Optional<Football> getPlayerById(@PathVariable String id) {
        if (footballRepository.existsById(id)) {
            return footballRepository.findById(id);
        } else
            return Optional.empty();
    }
    @GetMapping("/footballdetails/goals/{goal}")
    public List<Football> getPlayerWithGoalsMore(@PathVariable Integer goal) {
        List<Football> playerList = new ArrayList<>();
        footballRepository.findAll().forEach(Football -> {
            Integer totalGoals = Football.gettotalGoals();
            if (totalGoals >= goal) {
                playerList.add(Football);
            }
        });
        return playerList;
    }
    @GetMapping("/footballdetails/age/{age}")
    public List<Football> getPlayerWithAgeLess(@PathVariable Integer age) {
        List<Football> playerList = new ArrayList<>();
        footballRepository.findAll().forEach(Football -> {
            Integer totalAge = Football.getage();
            if (totalAge <= age) {
                playerList.add(Football);
            }
        });
        return playerList;
    }
    @GetMapping("/footballdetails/all")
    public List<Football> getAllPlayers() {
        List<Football> playerList = new ArrayList<>();
        footballRepository.findAll().forEach(Football -> {
                playerList.add(Football);
        });
        return playerList;
    }
}