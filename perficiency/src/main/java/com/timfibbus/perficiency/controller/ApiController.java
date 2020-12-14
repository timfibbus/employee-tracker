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
@RequestMapping("/api")
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
		newbie.setCompanyEmail(adder.get(2));
		newbie.setBirthDate(adder.get(3));
		newbie.setHiredDate(adder.get(4));
		newbie.setRole(adder.get(5));
		employeeDao.save(newbie);
		newHome.setStreet(adder.get(6));
		newHome.setSuite(adder.get(7));
		newHome.setCity(adder.get(8));
		newHome.setRegion(adder.get(9));
		newHome.setPostal(adder.get(10));
		newHome.setCountry(adder.get(11));
		newHome.setEmployee(newbie);
		newbie.setAddress(newHome);
		addDao.save(newHome);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String id,
			@RequestBody Employee employed) throws ResourceNotFoundException {

		Employee employee = employeeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID : " + id));

		employee.setFirstName(employed.getFirstName());
		employee.setLastName(employed.getLastName());
		employee.setCompanyEmail(employed.getCompanyEmail());
		employee.setContactEmail(employed.getContactEmail());
		employee.setSkills(employed.getSkills());
		employee.setAddress(employed.getAddress());
		employee.setBirthDate(employed.getBirthDate());
		employee.setHiredDate(employed.getHiredDate());
		employee.setRole(employed.getRole());
		final Employee updatedEmployee = employeeDao.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmp(@PathVariable(value = "employeeId") @RequestBody String id) throws Exception {
		Employee byeBye = employeeDao.findById(id).orElse(null);
		Address addOut = addDao.findById(byeBye.getAddress().getId()).orElse(null);
		System.out.println(addOut.toString());
		byeBye.setId();
		addDao.deleteById(addOut.getId());
		employeeDao.deleteById(byeBye.getId());
		System.out.println("all good");
	}
	
	@RequestMapping("/employees/{employeeId}/skills")
	public List<Skill> findAllSkillsByEmployee(@PathVariable(value = "employeeId") String id) {
		Employee employee = employeeDao.findById(id).orElse(null);
		List<Skill> theSkills = employee.getSkills();
		return theSkills;
	}
	
	@RequestMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill findSkillByEmployeeIdAndSkillId(@PathVariable(value = "employeeId") @RequestBody String id, @PathVariable(value = "skillId") String skillId) {
		Employee thisOne = employeeDao.findById(id).orElse(null);
		Skill thisSkill = skiDao.findByEmployeeIdAndId(id, skillId);
		return thisSkill;
		
	}
	
	@PutMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill updateFromEmployeeById(@PathVariable(value = "employeeId") String id, @PathVariable(value = "skillId") String skillId, @RequestBody ArrayList<String> updater) {
		Skill thisSkill = skiDao.findByEmployeeIdAndId(id, skillId);
		
		
		return thisSkill;
	}
	
	@PostMapping("/employees/{employeeId}/skills")
	public Skill addSkillByEmployee(@PathVariable(value = "employeeId") String id, @RequestBody ArrayList<String> newSkill) {
		Employee mySkill = employeeDao.findById(id).orElse(null);
		Skill addSkill = new Skill();
		Field addField = new Field();
		addField.setName(newSkill.get(0));
		addField.setType(newSkill.get(1));
		addSkill.setExperience(Integer.parseInt(newSkill.get(2)));
		addSkill.setSummary(newSkill.get(3));
		addSkill.setEmployee(mySkill);
		fiDao.save(addField);
		addSkill.setField(addField);
		skiDao.save(addSkill);
		return addSkill;
	}

}
