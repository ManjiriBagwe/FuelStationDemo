package com.sunman.springboot.fuelstation.departmentsale.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunman.springboot.fuelstation.departmentsale.model.DepartmentSale;

public interface DepartmentSaleRepository extends MongoRepository<DepartmentSale, String> {

	public List<DepartmentSale> findBySaledate(Date saledate);

	public List<DepartmentSale> findByStrsaledate(String strsaledate);

	public List<DepartmentSale> findByName(String name);

}
