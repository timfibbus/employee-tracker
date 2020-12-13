package com.timfibbus.perficiency;


import java.net.URI;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
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
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://localhost8081/employees");
		URI url = b.build().toUri();
		EmployeeResponse response = rt.getForObject(url, EmployeeResponse.class);
		System.out.println(url);
		return response.getEmployees();
	}

	
}
