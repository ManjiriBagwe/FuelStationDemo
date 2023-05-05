package com.sunman.springboot.fuelstation.department.item.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunman.springboot.fuelstation.department.item.SpringbootFuelStationDepartmentItemApplication;
import com.sunman.springboot.fuelstation.department.item.model.DepartmentItem;
import com.sunman.springboot.fuelstation.department.item.repository.DepartmentItemRepository;

@Service
public class DepartmentItemService {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationDepartmentItemApplication.class);

	@Autowired
	private DepartmentItemRepository repository;

	public List<DepartmentItem> getAllDepartmentItem() {
		logger.info("[DepartmentItemService][getAllDepartmentItem]");
		List<DepartmentItem> lDepartmentItem = repository.findAll();
		logger.info("lDepartmentItem : "+lDepartmentItem);
		return lDepartmentItem;
	}

	public DepartmentItem findByName(String name) {
		logger.info("[DepartmentItemService][findByName]");
		DepartmentItem departmentItem = repository.findByName(name);
		logger.info("departmentItem : "+departmentItem);
		return departmentItem;
	}

	public DepartmentItem addDepartmentItem(DepartmentItem departmentItem) {
		logger.info("[DepartmentItemService][addDepartmentItem]");
		DepartmentItem newDepartmentItem = repository.save(departmentItem);
		logger.info("newDepartmentItem : "+newDepartmentItem);
		return newDepartmentItem;

	}
}
