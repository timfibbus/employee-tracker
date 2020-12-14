package com.timfibbus.perficiency;


import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.timfibbus.perficiency.entity.Employee;

@Service
public class EmployeeService {
	
	private RestTemplate rt;
	
	
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "admin");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	public List<Employee> findAllEmployees() {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/emps");
		URI url = b.build().toUri();
		ResponseEntity<List<Employee>> response = rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
		});
		List<Employee> employees = response.getBody();
		System.out.println(employees);
		return employees;
	}
	
	public Employee findEmployeeById(String id) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/emps");
		URI url = b.build().toUri();
		b.query(id);
		ResponseEntity<List<Employee>> response = rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
		});
		List<Employee> employees = response.getBody();
		return employees.get(0);
		
	}
	
	public Employee updateEmployeeById(String id) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/emps");
		URI url = b.build().toUri();
		b.query(id);
		ResponseEntity<Employee> response = rt.exchange(url, HttpMethod.PUT, null, new ParameterizedTypeReference<Employee>() {
		});
		Employee employee = response.getBody();
		return employee;
	}
	
	public HashMap<String, Boolean> deleteEmployeeById(String id) {
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/emps");
		URI url = b.build().toUri();
		b.query(id);
		ResponseEntity<HashMap<String, Boolean>> response = rt.exchange(url, HttpMethod.DELETE, null, new ParameterizedTypeReference<HashMap<String, Boolean>>() {
		});
		HashMap<String, Boolean> newMap = response.getBody();
		return newMap;
	}
	
	
}
