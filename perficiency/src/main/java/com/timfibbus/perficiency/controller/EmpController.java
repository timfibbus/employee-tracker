package com.timfibbus.perficiency.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timfibbus.perficiency.EmployeeService;
import com.timfibbus.perficiency.dao.AddressDao;
import com.timfibbus.perficiency.dao.EmpDao;
import com.timfibbus.perficiency.dao.FieldDao;
import com.timfibbus.perficiency.dao.SkillDao;
import com.timfibbus.perficiency.entity.Address;
import com.timfibbus.perficiency.entity.Employee;
import com.timfibbus.perficiency.entity.Field;
import com.timfibbus.perficiency.entity.Skill;

@Controller
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
		return "welcome";
	}

	@RequestMapping("/employee-list")
	public String findAllEmployees(Model model) {
		List<Employee> employees = empServ.findAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}

	@RequestMapping("/create-employee")
	public String createEmployee(Model model) {
		return "create-employee";
	}

	@PostMapping("/employees")
	public String adder(Model model, String firstName, String lastName, String companyEmail, String birthDate,
			String hiredDate, String role, String street, @RequestParam(required = false) String suite, String city,
			String region, String postal, String country) {
		ArrayList<String> adder = new ArrayList<>();
		adder.add(firstName);
		adder.add(lastName);
		adder.add(companyEmail);
		adder.add(birthDate);
		adder.add(hiredDate);
		adder.add(role);
		adder.add(street);
		adder.add(suite);
		adder.add(city);
		adder.add(region);
		adder.add(postal);
		adder.add(country);
		
		empServ.addEmployee(adder);
		
		return "redirect:employee-list";
	}

	@RequestMapping("/employees/{employeeId}")
	public String findEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model) {
		ResponseEntity<Employee> thisGuy = empServ.findEmployeeById(employeeId);
		System.out.println(thisGuy.getBody().toString());
		Employee thatOne = thisGuy.getBody();
		model.addAttribute("thatOne", thatOne);
		return "employee-profile";
	}

	@PostMapping("/employees/{employeeId}")
	public String updateEmployeeById(@PathVariable(value = "employeeId") String employeeId, Employee updated, Model model) {
		Employee thisGuy = empServ.updateEmployeeById(employeeId, updated);
		model.addAttribute("thisGuy", thisGuy);
		return "employee-profile";
	}
	
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployeeById(@PathVariable(value = "employeeId") String employeeId) {
		Employee byeBye = employeeDao.findById(employeeId).orElse(null);
		Address noMore = byeBye.getAddress();
		addDao.delete(noMore);
		employeeDao.delete(byeBye);
		return "redirect:employee-list";
	}

	@RequestMapping("/employees/{employeeId}/skills")
	public String findAllSkillsByEmployee(Model model, @PathVariable(value = "employeeId") String employeeId) {
		Employee employee = employeeDao.findById(employeeId).orElse(null);
		List<Skill> allSkills = skiDao.findAllByEmployeeId(employeeId);
		model.addAttribute(employee);
		model.addAttribute(allSkills);
		return "employee-skills";
	}

	@PostMapping("/employees/{employeeId}/skills")
	public String addSkillToEmployee(Model model, @PathVariable(value = "employeeId") String employeeId, String name, String type, Integer experience, String summary) {
		ArrayList<String> newSkill = new ArrayList<>();
		newSkill.add(name);
		newSkill.add(type);
		newSkill.add(experience.toString());
		newSkill.add(summary);
		Skill skill = empServ.addSkillByEmployee(employeeId, newSkill);
		model.addAttribute("skill", skill);
		return "add-skill";
	}
	
	@RequestMapping("/employees/{employeeId}/skills/{skillId}")
	public String findSkillFromEmployeeById(Model model, @PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		Skill skill = empServ.findSkillByEmployeeAndSkillId(employeeId, skillId);
		//Employee employee = employeeDao.findById(employeeId).orElse(null);
		model.addAttribute("skill", skill);
		return "found-skill";
	}

	@PostMapping("/employees/{employeeId}/skills/{skillId}")
	public String updateSkillFromEmployeeById(Model model, @PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId, String type, String name, Integer experience, String summary) {
		ArrayList<String> upSkill = new ArrayList<>();
		upSkill.add(name);
		upSkill.add(type);
		upSkill.add(experience.toString());
		upSkill.add(summary);
		Skill updated = empServ.updateSkillByEmployeeAndSkillId(employeeId, skillId, upSkill);
		model.addAttribute("updated", updated);
		return "skills";
	}

	@DeleteMapping("/employees/{employeeId}/skills/{skillId}")
	public String deleteSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		return "skills";
	}
	
	@RequestMapping("/employees/fields/{fieldId}")
	public String findAllEmployeesWithField(@PathVariable(value = "fieldId") String fieldId) {
		return "fields-employees";
	}
	
	@RequestMapping("/employees/fields")
	public String findAllFields() {
		List<Field> fields = fiDao.findAll();
		return "fields";
	}
	
}
