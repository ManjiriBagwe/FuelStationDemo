package com.sunman.springboot.fuelstation.department.item.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunman.springboot.fuelstation.department.item.model.DepartmentItem;

public interface DepartmentItemRepository extends MongoRepository<DepartmentItem, String>{

	public DepartmentItem findByName(String name);
}

