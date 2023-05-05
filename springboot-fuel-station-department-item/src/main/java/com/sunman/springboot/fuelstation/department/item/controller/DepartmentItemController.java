package com.sunman.springboot.fuelstation.department.item.controller;

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

import com.sunman.springboot.fuelstation.department.item.SpringbootFuelStationDepartmentItemApplication;
import com.sunman.springboot.fuelstation.department.item.model.DepartmentItem;
import com.sunman.springboot.fuelstation.department.item.service.DepartmentItemService;

@RestController
@CrossOrigin("*")
@RequestMapping("/department-item-service")
public class DepartmentItemController {

	Logger logger = LoggerFactory.getLogger(SpringbootFuelStationDepartmentItemApplication.class);

	private DepartmentItemService service;

	public DepartmentItemController(DepartmentItemService departmentItemService) {
		this.service = departmentItemService;
	}

	@GetMapping("/")
	public String showWelcomeMessage() {
		logger.info("********** In welcome Message ***********");
		return "Welcome Department Item service";
	}

	@GetMapping("/department-item")
	public List<DepartmentItem> findAllDepartmentItem() {
		logger.info("[DepartmentItemController][findAllDepartmentItem]");
		return service.getAllDepartmentItem();
	}

	@GetMapping("/department-item/{name}")
	public DepartmentItem findDepartmentItemByName(@PathVariable String name) {
		logger.info("[DepartmentItemController][findDepartmentItemByName]");
		return service.findByName(name);
	}

	@PostMapping("/department-item")
	public String addDepartmentItem(@RequestBody DepartmentItem departmentItem) {
		logger.info("[DepartmentItemController][addDepartmentItem]");
		logger.info("departmentItem : "+departmentItem);
		DepartmentItem newDepartmentItem = service.addDepartmentItem(departmentItem);
		if(newDepartmentItem != null) {
			return "Department Item added succussfully";
		} else {
			return "Error";
		}
	}
}
