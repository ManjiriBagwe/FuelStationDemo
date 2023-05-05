package com.sunman.springboot.fuelstation.fuel.grade.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunman.springboot.fuelstation.fuel.grade.SpringbootFuelStationFuelGradeApplication;
import com.sunman.springboot.fuelstation.fuel.grade.model.FuelGrade;
import com.sunman.springboot.fuelstation.fuel.grade.repository.FuelGradeRepository;

@Service
public class FuelGradeService {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationFuelGradeApplication.class);

	@Autowired
	private FuelGradeRepository repository;

	public List<FuelGrade> findAll() {
		logger.debug("[FuelGradeService][findAll]");
		List<FuelGrade> lFuelGrade = repository.findAll();
		logger.debug("lFuelGrade : "+lFuelGrade);
		return lFuelGrade;
	}


	public FuelGrade findByName(String name) {
		logger.debug("[FuelGradeService][findByName]");
		FuelGrade fuelGrade = repository.findByName(name);
		logger.debug("fuelGrade : "+fuelGrade);
		return fuelGrade;
	}

	public FuelGrade addFuelGrade(FuelGrade fuelGrade) {
		logger.debug("[FuelGradeService][addFuelGrade]");
		FuelGrade newFuelGrade = repository.save(fuelGrade);
		logger.debug("newFuelGrade : "+newFuelGrade);
		return newFuelGrade;

	}
}
