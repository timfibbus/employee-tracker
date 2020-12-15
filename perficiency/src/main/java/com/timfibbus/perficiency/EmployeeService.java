package com.timfibbus.perficiency;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.timfibbus.perficiency.dao.AddressDao;
import com.timfibbus.perficiency.dao.EmpDao;
import com.timfibbus.perficiency.entity.Employee;
import com.timfibbus.perficiency.entity.Skill;

@Service
public class EmployeeService {
	
	@Autowired
	EmpDao employeeDao;
	@Autowired
	AddressDao addDao;
	
	
	private RestTemplate rt;
	
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "admin");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	public List<Employee> findAllEmployees() {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees");
		URI url = b.build().toUri();
		ResponseEntity<List<Employee>> response = rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
		});
		List<Employee> employees = response.getBody();
		System.out.println(employees);
		return employees;
	}
	
	public Employee findEmployeeById(String employeeId) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId);
		URI url = b.build().toUri();
		System.out.println(url);
		ResponseEntity<Employee> response = rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
		});
		Employee employee = response.getBody();
		System.out.println(employee);
		return employee;
	}
	
	public void addEmployee(ArrayList<String> adder) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		URI url = b.build().toUri();
		System.out.println(adder.toString());
		rt.put(url, adder);
	}
	
	public void updateEmployeeById(String employeeId, ArrayList<String> adder) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId);
		URI url = b.build().toUri();
		rt.put(url, adder);
	}
	
	public void deleteEmployeeById(String employeeId) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId);
		URI url = b.build().toUri();
		rt.execute(url, HttpMethod.DELETE, null, null);
	}
	
	public Skill findSkillByEmployeeAndSkillId(String employeeId, String skillId) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId + "/");
		b.path("skills/");
		b.path(skillId);
		URI url = b.build().toUri();
		ResponseEntity<Skill> response = rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Skill>() {
		});
		Skill skill = response.getBody();
		return skill;
	}
	
	public void addSkillByEmployee(String employeeId, @RequestBody ArrayList<String> newSkill) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId);
		b.path("/skills");
		URI url = b.build().toUri();
		rt.postForLocation(url, newSkill);
		
	}
	
	public List<Skill> findAllSkillsByEmployee(String employeeId) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId + "/skills");
		URI url = b.build().toUri();
		ResponseEntity<List<Skill>> response = rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Skill>>() {
		});
		List<Skill> skills = response.getBody();
		return skills;
	}
	
	public void updateSkillByEmployeeAndSkillId(String employeeId, String skillId, @RequestBody ArrayList<String> upSkill) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId + "/");
		b.path("skills/");
		b.path(skillId);
		URI url = b.build().toUri();
		rt.put(url, upSkill);
	}
	
	public void deleteSkillById(String employeeId, String skillId) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/employees/");
		b.path(employeeId + "/");
		b.path("skills/");
		b.path(skillId);
		URI url = b.build().toUri();
		rt.delete(url);
	}
	
	
	
	
}