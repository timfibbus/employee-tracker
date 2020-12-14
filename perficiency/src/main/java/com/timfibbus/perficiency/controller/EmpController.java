package com.timfibbus.perficiency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@RequestMapping("/employees")
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
		Employee newbie = new Employee();
		Address newHome = new Address();
		newbie.setFirstName(firstName);
		newbie.setLastName(lastName);
		newbie.setCompanyEmail(companyEmail);
		newbie.setBirthDate(birthDate);
		newbie.setHiredDate(hiredDate);
		newbie.setRole(role);
		employeeDao.save(newbie);
		newHome.setStreet(street);
		newHome.setSuite(suite);
		newHome.setCity(city);
		newHome.setRegion(region);
		newHome.setCountry(country);
		newHome.setPostal(postal);
		newHome.setEmployee(newbie);
		addDao.save(newHome);
		return "index";
	}

	@RequestMapping("/employees/{employeeId}")
	public String findEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model) {
		Employee thisGuy = empServ.findEmployeeById(employeeId);
		model.addAttribute("thisGuy", thisGuy);
		return "employee-profile";
	}

	@PostMapping("/employees/{employeeId}")
	public String updateEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model) {
		return "employee-profile";
	}

	@RequestMapping("/employees/{employeeId}/skills")
	public String findAllSkillsByEmployee(Model model) {
		Iterable<Skill> allSkills = skiDao.findAll();
		model.addAttribute(allSkills);
		return "skills";
	}

	@PostMapping("/employees/{employeeId}/skills")
	public String addSkillToEmployee(@PathVariable(value = "employeeId") String employeeId) {
		return "add-skill";
	}

	@RequestMapping("/employees/{employeeId}/skills/{skillId}")
	public String findSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		return "found-skill";
	}

	@PostMapping("/employees/{employeeId}/skills/{skillId}")
	public String updateSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		return "skills";
	}

	@DeleteMapping("/employees/{employeeId}/skills/{skillId")
	public String deleteSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId,
			@PathVariable(value = "skillId") String skillId) {
		return "skills";
	}
}
