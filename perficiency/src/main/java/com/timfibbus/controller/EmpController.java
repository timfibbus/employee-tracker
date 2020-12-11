package com.timfibbus.controller;


import com.timfibbus.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@Autowired
	EmployeeService empServ;
	@Autowired
	EmpDao employeeDao;
	@Autowired
	SkillDao skiDao;
	@Autowired
	AddressDao addDao;
	@Autowired
	FieldDao fiDao;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/employees")
	public String employed(Model model) {
		List<Employee> allEmployees = employeeDao.findAll();
		model.addAttribute(allEmployees);
		System.out.println(allEmployees);
		
		return "employees";
	}
	
	@RequestMapping("/skills")
	public String skilled(Model model) {
		List<Skill> allSkills = skiDao.findAll();
		model.addAttribute(allSkills);
		return "skills";
	}
	
	@PostMapping("/add-employee")
	public String adder(Model model, Employee newGuy) {
		employeeDao.save(newGuy);
		return "confirm";
	}

}
