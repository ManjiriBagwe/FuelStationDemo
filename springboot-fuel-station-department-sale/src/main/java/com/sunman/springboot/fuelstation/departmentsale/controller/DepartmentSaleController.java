package com.sunman.springboot.fuelstation.departmentsale.controller;

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

import com.sunman.springboot.fuelstation.departmentsale.SpringbootFuelStationDepartmentSaleApplication;
import com.sunman.springboot.fuelstation.departmentsale.model.DepartmentSale;
import com.sunman.springboot.fuelstation.departmentsale.service.DepartmentSaleService;

@RestController
//@CrossOrigin("http://localhost:4200/")
@CrossOrigin("*")
@RequestMapping("/department-sale-service")
public class DepartmentSaleController {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationDepartmentSaleApplication.class);

	private DepartmentSaleService departmentSaleService;

	public DepartmentSaleController(DepartmentSaleService departmentSaleService) {
		this.departmentSaleService = departmentSaleService;
	}

	@GetMapping("/")
	public String welcome() {
		logger.info("[DepartmentSaleController][welcome]");
		return "Welcome to department sale application";
	}

	@GetMapping("/department-sale")
	public List<DepartmentSale> getAllDepartmentSaleData() {
		logger.info("[DepartmentSaleController][getAllDepartmentSaleData]");
		return departmentSaleService.findAll();
	}

	@GetMapping("/department-sale/{saledate}")
	public List<DepartmentSale> getDepartmentSaleData(@PathVariable String saledate) {
		logger.info("[DepartmentSaleController][getDepartmentSaleData]");
		logger.info("[getDepartmentSaleData] saledate : "+saledate);
		return departmentSaleService.findByDate(saledate);
	}

	@PostMapping("/add-department-sale-form")
	public String addDepartmentSaleData(@RequestBody DepartmentSale departmentSale) {
		logger.info("[DepartmentSaleController][addDepartmentSaleData]");
		logger.info("departmentSale : "+departmentSale);
		DepartmentSale newDepartmentSale = departmentSaleService.addDepartmentSaleData(departmentSale);
		if(newDepartmentSale != null) {
			return "New record added.";
		} else {
			return "Error";
		}
	}
}
