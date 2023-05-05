package com.sunman.springboot.fuelstation.fuelsale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sunman.springboot.fuelstation.fuelsale.model.FuelGrade;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ApiCall {

	private static final Logger logger = LoggerFactory.getLogger(ApiCall.class);

	@Autowired
	private RestTemplate restTemplate;

	private static final String fuelGradeMicroserviceURL= "http://fuel-grade-service/fuel-grade-service/fuel-grade";

	/* CircuitBreaker is used to check API call is working properly or not by using time out/ count out. */
	@CircuitBreaker(name = "FuelGradeCheckAPI", fallbackMethod = "fallback")
	public List<FuelGrade> getAllFuelGrade() {
		logger.info("[ApiCall][getAllFuelGrade]");
		logger.info("calling course microservice API using RestTemplate");
		List<FuelGrade> lFuelGrade = null;
		try {
			/* Sleep added to make API call slow response for testing purpose. */
			//Thread.sleep(3000);
			lFuelGrade = restTemplate.getForObject(fuelGradeMicroserviceURL, List.class);
			logger.info("List of Grade using API call : "+lFuelGrade);
		}catch (Exception e) {
			logger.info("Error 1 : "+e.getMessage());
		}
		return lFuelGrade; 
	}

	public List<FuelGrade> fallback(Exception ex) {
		logger.info("****************** Inside fallback *******************");
		return Arrays.asList(new FuelGrade("1", "Sample Grade"));
	}
}
