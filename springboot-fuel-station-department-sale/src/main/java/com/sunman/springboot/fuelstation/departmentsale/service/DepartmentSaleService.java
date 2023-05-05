package com.sunman.springboot.fuelstation.departmentsale.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunman.springboot.fuelstation.departmentsale.SpringbootFuelStationDepartmentSaleApplication;
import com.sunman.springboot.fuelstation.departmentsale.model.DepartmentSale;
import com.sunman.springboot.fuelstation.departmentsale.repository.DepartmentSaleRepository;

@Service
public class DepartmentSaleService {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationDepartmentSaleApplication.class);

	@Autowired
	private DepartmentSaleRepository departmentSaleRepository;

	public List<DepartmentSale> findAll() {
		logger.info("[DepartmentSaleService][findAll]");
		List<DepartmentSale> lDepartmentSale = departmentSaleRepository.findAll();
		logger.info("lDepartmentSale = "+lDepartmentSale);
		return lDepartmentSale;
	}

	public List<DepartmentSale> findByDate(String saleDate) {
		logger.info("[DepartmentSaleService][findByDate]");
		List<DepartmentSale> lDepartmentSale = departmentSaleRepository.findByStrsaledate(saleDate);
		logger.info("findByDate String : "+lDepartmentSale);
		return lDepartmentSale;
	}

	public List<DepartmentSale> findByName(String name) {
		logger.info("[DepartmentSaleService][findByName]");
		List<DepartmentSale> lDepartmentSale = departmentSaleRepository.findByName(name);
		logger.info("findByGrade : "+lDepartmentSale);
		return lDepartmentSale;
	}

	public DepartmentSale addDepartmentSaleData(DepartmentSale departmentSale) {
		logger.info("[DepartmentSaleService][addDepartmentSaleData]");
		DepartmentSale newDepartmentSale = departmentSaleRepository.save(departmentSale);
		logger.info("newDepartmentSale : "+newDepartmentSale);
		return newDepartmentSale;
	}
}
