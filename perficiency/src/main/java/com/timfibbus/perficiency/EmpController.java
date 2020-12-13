package com.timfibbus.perficiency;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		List<Employee> allEmployees = employeeDao.findAll();
		model.addAttribute(allEmployees);
		System.out.println(allEmployees);
		return "index";
	}
	
	@RequestMapping("/create")
	public String createEmployee(Model model) {
		return "create";
	}
	
	@PostMapping("/employees")
	public String adder(Model model, String firstName, String lastName, String companyEmail,
			String birthDate, String hiredDate, String role, String street, @RequestParam(required = false) 
			String suite, String city, String region, String postal, String country) {
		Employee newbie = new Employee();
		/*Address newHome = new Address();
		newHome.setStreet(street);
		newHome.setSuite(suite);
		newHome.setCity(city);
		newHome.setRegion(region);
		newHome.setCountry(country);
		newHome.setPostal(postal);
		newHome.setId();
		System.out.println(newHome.getId());
		addDao.save(newHome);
		*/newbie.setId();
		newbie.setFirstName(firstName);
		newbie.setLastName(lastName);
		//newbie.setAddress(newHome);
		newbie.setCompanyEmail(companyEmail);
		newbie.setBirthDate(birthDate);
		newbie.setHiredDate(hiredDate);
		newbie.setRole(role);
		employeeDao.save(newbie);
		return "index";
	}
	
	@RequestMapping("/employees/{employeeId}")
	public String findEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model) {
		Employee thisGuy = employeeDao.findById(employeeId).orElse(null);
		model.addAttribute(thisGuy);
		return "employee-profile";
	}
	
	@PostMapping("/employees/{employeeId}")
	public String updateEmployeeById(@PathVariable(value = "employeeId") String employeeId, Model model) {
		return "employee-profile";
	}
	
	@RequestMapping("/employees/{employeeId}/skills")
	public String findAllSkillsByEmployee(Model model) {
		List<Skill> allSkills = skiDao.findAll();
		model.addAttribute(allSkills);
		return "skills";
	}
	
	@PostMapping("/employees/{employeeId}/skills")
	public String addSkillToEmployee(@PathVariable(value = "employeeId") String employeeId) {
		return "add-skill";
	}
	
	@RequestMapping("/employees/{employeeId}/skills/{skillId}")
	public String findSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId, @PathVariable(value = "skillId") String skillId) {
		return "found-skill";
	}
	
	@PostMapping("/employees/{employeeId}/skills/{skillId}")
	public String updateSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId, @PathVariable(value = "skillId") String skillId) {
		return "skills";
	}
	
	@DeleteMapping("/employees/{employeeId}/skills/{skillId")
	public String deleteSkillFromEmployeeById(@PathVariable(value = "employeeId") String employeeId, @PathVariable(value = "skillId") String skillId) {
		return "skills";
	}
}
