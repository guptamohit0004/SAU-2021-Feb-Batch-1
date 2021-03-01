package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Football {
    @Id
    String id;
    @NotNull
    @Field
    String name;
    @Field
    Integer totalGoals;
    @Field
    Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer gettotalGoals()
	{
		return totalGoals;
	}
	public void settotalGoals(Integer totalGoals)
	{
		this.totalGoals = totalGoals;
	}
	public Integer getage()
	{
		return age;
	}
	public void setage(Integer age)
	{
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public Football(String id, String name, Integer totalGoals,Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.totalGoals = totalGoals;
		this.age=age;
	}
}
