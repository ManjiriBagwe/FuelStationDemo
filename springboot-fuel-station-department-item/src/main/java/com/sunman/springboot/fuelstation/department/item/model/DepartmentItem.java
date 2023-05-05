package com.sunman.springboot.fuelstation.department.item.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departmentitems")
public class DepartmentItem {

	@Id
	private String id;

	private String name;

	public DepartmentItem() {
		super();
	}

	public DepartmentItem(String id, String name) {
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
		return "DepartmentItem [id=" + id + ", name=" + name + "]";
	}

}
