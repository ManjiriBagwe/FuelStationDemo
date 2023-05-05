package com.sunman.springboot.fuelstation.fuelsale.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunman.springboot.fuelstation.fuelsale.model.FuelSale;

public interface FuelSaleRepository  extends MongoRepository<FuelSale, String> {

	public List<FuelSale> findBySaledate(Date saledate);

	public List<FuelSale> findByStrsaledate(String strsaledate);

	public List<FuelSale> findByGrade(String grade);
}
