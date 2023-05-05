package com.sunman.springboot.fuelstation.fuelsale.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunman.springboot.fuelstation.fuelsale.SpringbootFuelStationFuelSaleApplication;
import com.sunman.springboot.fuelstation.fuelsale.model.FuelSale;
import com.sunman.springboot.fuelstation.fuelsale.repository.FuelSaleRepository;

@Service
public class FuelSaleService {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationFuelSaleApplication.class);

	@Autowired
	private FuelSaleRepository fuelSaleRepository;

	@Autowired
	private ApiCall apiCall;

	public List<FuelSale> findAll() {
		logger.info("[FuelSaleService][findAll]");
		List<FuelSale> lFuelSale = fuelSaleRepository.findAll();
		logger.info("lFuelSale : " + lFuelSale);
		return lFuelSale;
	}

	public List<FuelSale> findByDate(String saleDate) {
		logger.info("[FuelSaleService][findByDate]");
		List<FuelSale> lFuelSale = fuelSaleRepository.findByStrsaledate(saleDate);
		logger.info("findByDate String : " + lFuelSale);

		/* Calling other Microservice API */
		testServiceToServiceCall();

		return lFuelSale;
	}

	public List<FuelSale> findByGrade(String grade) {
		logger.info("[FuelSaleService][findByGrade]");
		List<FuelSale> lFuelSale = fuelSaleRepository.findByGrade(grade);
		logger.info("findByGrade : " + lFuelSale);
		return lFuelSale;
	}

	public FuelSale addFuleSaleData(FuelSale fuelSale) {
		logger.info("[FuelSaleService][addFuleSaleData]");
		FuelSale newFuelSale = fuelSaleRepository.save(fuelSale);
		logger.info("newFuelSale : " + newFuelSale);
		return newFuelSale;
	}

	private void testServiceToServiceCall() {
		try {
			logger.info("Additional code to code Service to Service API testing");
			apiCall.getAllFuelGrade();
			logger.info("API call Successful");
		} catch (Exception e) {
			logger.info("Error message : " + e.getMessage());
		}
	}
}
