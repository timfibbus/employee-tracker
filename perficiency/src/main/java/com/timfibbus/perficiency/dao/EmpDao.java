package com.timfibbus.perficiency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timfibbus.perficiency.entity.Employee;


@Repository
public interface EmpDao extends JpaRepository<Employee, String> {

	Employee findEmployeeById(String id);
	
	//List<Employee> findAllBySkills(Skill skill);
	
	
	
}
