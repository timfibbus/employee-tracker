package com.timfibbus.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private String employeeId;
	private String name;
	private String type;
	
	
	
	public Skill(Long id, String employeeId, String name, String type) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.name = name;
		this.type = type;
	}

	public Skill() {
		super();
	}


	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", type=" + type + "]";
	}
	
	
	
}
