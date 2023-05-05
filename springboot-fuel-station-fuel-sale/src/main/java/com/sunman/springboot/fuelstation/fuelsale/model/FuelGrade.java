package com.sunman.springboot.fuelstation.fuelsale.model;

public class FuelGrade {

	private String id;

	private String name;

	public FuelGrade() {
		super();
	}

	public FuelGrade(String id, String name) {
		super();
		this.id = id;
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
