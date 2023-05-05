package com.sunman.springboot.fuelstation.fuel.grade.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fuelgrade")
public class FuelGrade {

	@Id
	private String id;

	private String name;

	public FuelGrade() {
		super();
	}

	public FuelGrade(String id, String name) {
		super();
		this.id = new ObjectId().toString();
		this.name = name;
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

	@Override
	public String toString() {
		return "FuelGrade [id=" + id + ", name=" + name + "]";
	}
}
