package com.timfibbus.perficiency.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.timfibbus.perficiency.entity.Employee;

//@CrossOrigin(origins = "http://localhost:8080")
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
	
	@ResponseBody@GetMapping("/emps")
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@GetMapping("/emps/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		Employee employee = employeeDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID : " + id));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/emps")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeDao.save(employee);
	}

	@PutMapping("/emps/{id}")
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
		employee.setRole(employee.getRole());
		final Employee updatedEmployee = employeeDao.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/emps/{id}")
	public Map<String, Boolean> deleteEmp(@PathVariable(value = "id") String id) throws Exception {
		Employee employee = employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found at ID : " + id));
		employeeDao.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	

}
