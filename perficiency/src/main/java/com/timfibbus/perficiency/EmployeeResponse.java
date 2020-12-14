package com.timfibbus.perficiency;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.timfibbus.perficiency.entity.Employee;


public class EmployeeResponse {
	
	ArrayList<Employee> employees;

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

}
