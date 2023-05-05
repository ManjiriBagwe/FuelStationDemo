package com.sunman.springboot.fuelstation.fuel.grade.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunman.springboot.fuelstation.fuel.grade.SpringbootFuelStationFuelGradeApplication;
import com.sunman.springboot.fuelstation.fuel.grade.model.FuelGrade;
import com.sunman.springboot.fuelstation.fuel.grade.service.FuelGradeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/fuel-grade-service")
public class FuelGradeController {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationFuelGradeApplication.class);

	private FuelGradeService service;

	public FuelGradeController(FuelGradeService fuelGradeService) {
		this.service = fuelGradeService;
	}

	@GetMapping("/")
	public String showWelcomeMessage() {
		logger.info("********** In welcome Message ***********");
		return "Welcome Fuel Grade service";
	}

	@GetMapping("/fuel-grade")
	public List<FuelGrade> findAllFuelGrade() {
		logger.info("[FuelGradeController][findAllFuelGrade]");
		return service.findAll();
	}

	@GetMapping("/fuel-grade/{name}")
	public FuelGrade findFuelGradeByName(@PathVariable String name) {
		logger.info("[FuelGradeController][findFuelGradeByName]");
		return service.findByName(name);
	}

	@PostMapping("/fuel-grade")
	public String addFuelGrade(@RequestBody FuelGrade fuelGrade) {
		logger.info("[FuelGradeController][addFuelGrade]");
		logger.info("fuelGrade : "+fuelGrade);
		FuelGrade newFuelGrade = service.addFuelGrade(fuelGrade);
		if(newFuelGrade != null) {
			return "Fuel-Grade added succussfully";
		} else {
			return "Error";
		}
	}
}
