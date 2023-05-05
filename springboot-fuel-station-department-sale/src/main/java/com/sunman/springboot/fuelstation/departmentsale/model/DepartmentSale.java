package com.sunman.springboot.fuelstation.departmentsale.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "departmentsale")
public class DepartmentSale {
	@Id
	private String id;
	private String name;
	private int quantity;
	private float sale;
	private float profit;
	private float margin;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date saledate;

	private String strsaledate;

	public DepartmentSale() {
		super();
	}

	public DepartmentSale(String id, String name, int quantity, float sale, float profit, float margin, Date saledate, String strsaledate) {
		super();
		//this.id = id;
		this.id = new ObjectId().toString();
		this.name = name;
		this.quantity = quantity;
		this.sale = sale;
		this.profit = profit;
		this.margin = margin;
		this.saledate = saledate;
		this.strsaledate = strsaledate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public float getMargin() {
		return margin;
	}

	public void setMargin(float margin) {
		this.margin = margin;
	}
	public Date getSaleDate() {
		return saledate;
	}

	public void setSaleDate(Date saleDate) {
		this.saledate = saleDate;
	}

	public String getStrsaledate() {
		return strsaledate;
	}

	public void setStrsaledate(String strsaledate) {
		this.strsaledate = strsaledate;
	}

	@Override
	public String toString() {
		return "DepartmentSale [id=" + id + ", name=" + name + ", quantity=" + quantity + ", sale=" + sale + ", profit="
				+ profit + ", margin=" + margin + ", saledate=" + saledate + ", strsaledate=" + strsaledate + "]";
	}
}
