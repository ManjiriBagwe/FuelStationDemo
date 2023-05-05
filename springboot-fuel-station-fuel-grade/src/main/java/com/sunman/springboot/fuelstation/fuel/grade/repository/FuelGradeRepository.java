package com.sunman.springboot.fuelstation.fuel.grade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunman.springboot.fuelstation.fuel.grade.model.FuelGrade;

public interface FuelGradeRepository extends MongoRepository<FuelGrade, String>{

	public FuelGrade findByName(String name);
}
