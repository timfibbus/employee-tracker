package com.timfibbus.perficiency.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timfibbus.perficiency.EmployeeService;
import com.timfibbus.perficiency.dao.AddressDao;
import com.timfibbus.perficiency.dao.EmpDao;
import com.timfibbus.perficiency.dao.FieldDao;
import com.timfibbus.perficiency.dao.SkillDao;
import com.timfibbus.perficiency.entity.Address;
import com.timfibbus.perficiency.entity.Employee;
import com.timfibbus.perficiency.entity.Field;
import com.timfibbus.perficiency.entity.Skill;

@RestController
public class ApiController {
	
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
	
	@ResponseBody@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable(value = "employeeId") String id)
			throws ResourceNotFoundException {
		Employee employee = employeeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID : " + id));
		//return ResponseEntity.ok().body(employee);
		return employee;
	}

	@PutMapping("/employees")
	public void createEmployee(@RequestBody ArrayList<String> adder) {
		Employee newbie = new Employee();
		Address newHome = new Address();
		newbie.setFirstName(adder.get(0));
		newbie.setLastName(adder.get(1));
		newbie.setContactEmail(adder.get(2));
		newbie.setCompanyEmail(adder.get(3));
		newbie.setBirthDate(adder.get(4));
		newbie.setHiredDate(adder.get(5));
		newbie.setRole(adder.get(6));
		newbie.setBusinessUnit(adder.get(7));
		employeeDao.save(newbie);
		newHome.setStreet(adder.get(8));
		newHome.setSuite(adder.get(9));
		newHome.setCity(adder.get(10));
		newHome.setRegion(adder.get(11));
		newHome.setPostal(adder.get(12));
		newHome.setCountry(adder.get(13));
		newHome.setEmployee(newbie);
		newbie.setAddress(newHome);
		addDao.save(newHome);
	}

	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable(value = "id") String id,
			@RequestBody ArrayList<String> adder) throws ResourceNotFoundException {

		Employee employee = employeeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID : " + id));
	
		employee.setFirstName(adder.get(0));
		employee.setLastName(adder.get(1));
		employee.setContactEmail(adder.get(2));
		employee.setCompanyEmail(adder.get(3));
		employee.setBirthDate(adder.get(4));
		employee.setHiredDate(adder.get(5));
		employee.setRole(adder.get(6));
		employee.setBusinessUnit(adder.get(7));
		employee.getAddress().setStreet(adder.get(8));
		employee.getAddress().setSuite(adder.get(9));
		employee.getAddress().setCity(adder.get(10));
		employee.getAddress().setRegion(adder.get(11));
		employee.getAddress().setPostal(adder.get(12));
		employee.getAddress().setCountry(adder.get(13));
		employeeDao.save(employee);
		System.out.println(employee.toString());
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmp(@PathVariable(value = "employeeId") @RequestBody String id) throws Exception {
		
		employeeDao.deleteById(id);
		System.out.println("all good");
	}
	
	@GetMapping("/employees/{employeeId}/skills")
	public List<Skill> findAllSkillsByEmployee(@PathVariable(value = "employeeId") String id) {
		Employee employee = employeeDao.findById(id).orElse(null);
		List<Skill> theSkills = employee.getSkills();
		List<Skill> allSkills = skiDao.findAllByEmployeeId(id);
		System.out.println(allSkills);
		return theSkills;
	}
	
	@GetMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill findSkillByEmployeeIdAndSkillId(@PathVariable(value = "employeeId") @RequestBody String id, @PathVariable(value = "skillId") String skillId) {
		Skill thisSkill = skiDao.findByEmployeeIdAndId(id, skillId);
		return thisSkill;
		
	}
	
	@PutMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill updateFromEmployeeById(@PathVariable(value = "employeeId") String id, @PathVariable(value = "skillId") String skillId, @RequestBody ArrayList<String> updater) {
		Skill thisSkill = skiDao.findByEmployeeIdAndId(id, skillId);
		thisSkill.getField().setName(updater.get(0));
		thisSkill.getField().setType(updater.get(1));
		thisSkill.setExperience(Integer.parseInt(updater.get(2)));
		thisSkill.setSummary(updater.get(3));
		
		return thisSkill;
	}
	
	@PostMapping("/employees/{employeeId}/skills")
	public void addSkillByEmployee(@PathVariable(value = "employeeId") String id, @RequestBody ArrayList<String> newSkill) {
		Employee mySkill = employeeDao.findById(id).orElse(null);
		Skill addSkill = new Skill();
		Field addField = new Field();
		addField.setName(newSkill.get(0));
		addField.setType(newSkill.get(1));
		fiDao.save(addField);
		addSkill.setExperience(Integer.parseInt(newSkill.get(2)));
		addSkill.setSummary(newSkill.get(3));
		addSkill.setEmployee(mySkill);
		addSkill.setField(addField); 
		skiDao.save(addSkill);
		System.out.println("all good");
	}

	@DeleteMapping("/employees/{employeeId}/skills/{skillId}")
	public void deleteSkillbyEmployeeIdAndId(@PathVariable(value = "employeeId") String id, @PathVariable(value = "skillId") String skillId) {
		Skill thisSkill = skiDao.findByEmployeeIdAndId(id, skillId);
		skiDao.delete(thisSkill);
	}
}
