package com.timfibbus.perficiency;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDao extends JpaRepository<Employee, String> {

	Employee findEmployeeById(String id);
	
	//List<Employee> findAllBySkills(Skill skill);
	
	
	
}
