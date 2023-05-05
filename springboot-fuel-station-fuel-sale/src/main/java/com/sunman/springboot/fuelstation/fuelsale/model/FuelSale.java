package com.sunman.springboot.fuelstation.fuelsale.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "fuelsale")
public class FuelSale {
	@Id
	private String id;
	private String grade;
	private float volume;
	private float sale;
	private float profit;
	private float margin;

	@Field("saledate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date saledate;

	private String strsaledate;

	public FuelSale() {
		super();
	}

	public FuelSale(String id, String grade, float volume, float sale, float profit, float margin, Date saledate, String strsaledate) {
		super();
		//this.id = id;
		this.id = new ObjectId().toString();
		this.grade = grade;
		this.volume = volume;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
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
		return "FuelSale [id=" + id + ", grade=" + grade + ", volume=" + volume + ", sale=" + sale + ", profit="
				+ profit + ", margin=" + margin + ", saledate=" + saledate + ", strsaledate=" + strsaledate + "]";
	}
}
