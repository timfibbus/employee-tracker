package com.timfibbus.perficiency;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class EmployeeResponse {
	
	//@JsonProperty("employees")
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
