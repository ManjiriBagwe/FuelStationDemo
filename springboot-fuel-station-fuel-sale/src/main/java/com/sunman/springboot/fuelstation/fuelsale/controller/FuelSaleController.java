package com.sunman.springboot.fuelstation.fuelsale.controller;

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

import com.sunman.springboot.fuelstation.fuelsale.SpringbootFuelStationFuelSaleApplication;
import com.sunman.springboot.fuelstation.fuelsale.model.FuelSale;
import com.sunman.springboot.fuelstation.fuelsale.service.FuelSaleService;

@RestController
//@CrossOrigin("http://localhost:4200/")
@CrossOrigin("*")
@RequestMapping("/fuel-sale-service")
public class FuelSaleController {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationFuelSaleApplication.class);

	private FuelSaleService fuelSaleService;

	public FuelSaleController(FuelSaleService fuelSaleService) {
		this.fuelSaleService = fuelSaleService;
	}

	@GetMapping("/")
	public String welcome() {
		logger.info("[FuelSaleController][welcome]");
		return "Welcome to my application";
	}

	@GetMapping("/fuel-sale")
	public List<FuelSale> getAllFuelSaleData() {
		logger.info("[FuelSaleController][getAllFuelSaleData]");
		return fuelSaleService.findAll();
	}

	@GetMapping("/fuel-sale/{saledate}")
	public List<FuelSale> getFuelSaleData(@PathVariable String saledate) {
		logger.info("[FuelSaleController][getFuelSaleData]");
		logger.info("saledate : "+saledate);
		return fuelSaleService.findByDate(saledate);
	}

	@PostMapping("/add-fuel-sale-form")
	public String addFuelSaleData(@RequestBody FuelSale fuelSale) {
		logger.info("[FuelSaleController][addFuelSaleData]");
		logger.info("FuelSale : "+fuelSale);
		FuelSale newFuelSale = fuelSaleService.addFuleSaleData(fuelSale);
		if(newFuelSale != null) {
			return "New record added.";
		} else {
			return "Error";
		}
	}
}
