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
	
	@RequestMapping("/")
	public String index() {
		return "welcome";
	}

	//Employee Methods
	
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

	@PostMapping("/employee-add")
	public String adder(Model model, String firstName, String lastName, String companyEmail, String birthDate,
			String hiredDate, String role, String street, @RequestParam(required = false) String suite, String city,
			String region, String postal, String country, String contactEmail, String businessUnit) {
		ArrayList<String> adder = new ArrayList<>();
		adder.add(firstName);
		adder.add(lastName);
		adder.add(contactEmail);
		adder.add(companyEmail);
		adder.add(birthDate);
		adder.add(hiredDate);
		adder.add(role);
		adder.add(businessUnit);
		adder.add(street);
		adder.add(suite);
		adder.add(city);
		adder.add(region);
		adder.add(postal);
		adder.add(country);
		
		empServ.addEmployee(adder);

		return "redirect:employee-list";
	}

	@RequestMapping("/employee-profile/{employeeId}")
	public String findEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model) {
		Employee thisGuy = empServ.findEmployeeById(employeeId);
		Employee thatOne = thisGuy;
		model.addAttribute("thatOne", thatOne);
		return "employee-profile";
	}
	
	@RequestMapping("/employee-profile/{employeeId}/edit")
	public String editEmployee(@PathVariable(value = "employeeId") String employeeId, Model model) {
		Employee thatOne = empServ.findEmployeeById(employeeId);
		model.addAttribute("thatOne", thatOne);
		return "profile-edit";
	}

	@RequestMapping("/employee-update/{employeeId}")
	public String updateEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model, String firstName, 
			String lastName, String contactEmail, String companyEmail, String birthDate, String role, String businessUnit,String hiredDate, 
			String street, @RequestParam(required = false) String suite, String city,
			String region, String postal, String country) {
		
		ArrayList<String> adder = new ArrayList<>();
		adder.add(firstName);
		adder.add(lastName);
		adder.add(contactEmail);
		adder.add(companyEmail);
		adder.add(birthDate);
		adder.add(hiredDate);
		adder.add(role);
		adder.add(businessUnit);
		adder.add(street);
		adder.add(suite);
		adder.add(city);
		adder.add(region);
		adder.add(postal);
		adder.add(country);
		System.out.println(contactEmail);
		System.out.println(role);
		System.out.println(businessUnit);
		empServ.updateEmployeeById(employeeId, adder);
		Employee thatOne = empServ.findEmployeeById(employeeId);
		
		model.addAttribute("thatOne", thatOne);
		return "employee-profile";
	}
	
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployeeById(Model model, @PathVariable(value = "employeeId") String employeeId) {
		empServ.deleteEmployeeById(employeeId);
		List<Employee> employees = empServ.findAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	//Skill Methods
	
	@RequestMapping("/employee-profile/{employeeId}/skills")
	public String findAllSkillsByEmployee(Model model, @PathVariable(value = "employeeId") String employeeId) {
		//Employee employee = employeeDao.findById(employeeId).orElse(null);
		List<Skill> allSkills = empServ.findAllSkillsByEmployee(employeeId);
		model.addAttribute("id", employeeId);
		model.addAttribute("allSkills", allSkills);
		return "employee-skills";
	}
	
	@RequestMapping("/skill-form/{employeeId}")
	public String createSkill(Model model, @PathVariable(value = "employeeId") String employeeId) {
		model.addAttribute("id", employeeId);
		return "add-skill";
	}

	@RequestMapping("/employee-profile/{employeeId}/add-skill")
	public String addSkillToEmployee(Model model, @PathVariable(value = "employeeId") String employeeId, String name, String type, Integer experience, String summary) {
		ArrayList<String> newSkill = new ArrayList<>();
		newSkill.add(name);
		newSkill.add(type);
		newSkill.add(String.valueOf(experience));
		newSkill.add(summary);
		empServ.addSkillByEmployee(employeeId, newSkill);
		Employee thatOne = empServ.findEmployeeById(employeeId);
		model.addAttribute("thatOne", thatOne);
		System.out.println(newSkill.toString());
		return "employee-profile";
	}
	
	@RequestMapping("/employee-profile/{employeeId}/{skillId}")
	public String findSkillFromEmployeeById(Model model, @PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		Skill skill = empServ.findSkillByEmployeeAndSkillId(employeeId, skillId);
		//Employee employee = employeeDao.findById(employeeId).orElse(null);
		model.addAttribute("id", employeeId);
		model.addAttribute("skill", skill);
		return "skill-details";
	}

	@RequestMapping("/employee-profile/{employeeId}/update/{skillId}")
	public String updateSkillFromEmployeeById(Model model, @PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId, String type, String name, Integer experience, String summary) {
		ArrayList<String> upSkill = new ArrayList<>();
		upSkill.add(name);
		upSkill.add(type);
		upSkill.add(experience.toString());
		upSkill.add(summary);
		empServ.updateSkillByEmployeeAndSkillId(employeeId, skillId, upSkill);

		return "employee-skills";
	}

	@RequestMapping("/employee-profile/{employeeId}/delete/{skillId}")
	public String deleteSkillFromEmployeeById(Model model, @PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		empServ.deleteSkillById(employeeId, skillId);
		List<Skill> allSkills = empServ.findAllSkillsByEmployee(employeeId);
		//Employee thatOne = empServ.findEmployeeById(employeeId);
		model.addAttribute("id", employeeId);
		model.addAttribute("allSkills", allSkills);
		
		return "employee-skills";
	}
	
	@RequestMapping("/employees/fields/{fieldId}")
	public String findAllEmployeesWithField(@PathVariable(value = "fieldId") String fieldId) {
		return "fields-employees";
	}
	
	@RequestMapping("/employees/fields")
	public String findAllFields() {
		
		return "fields";
	}
	
}
