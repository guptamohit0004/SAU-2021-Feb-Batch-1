package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Bookmyshow;



public interface BookmyshowRepository extends CrudRepository<Bookmyshow, String> {
	
	Bookmyshow findByName(String movie);

}