package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Football;

public interface FootballRepository extends CrudRepository<Football, String> {

	Football findByName(String movie);

}