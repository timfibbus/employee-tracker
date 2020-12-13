package com.timfibbus.perficiency.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.timfibbus.perficiency.entity.Employee;


@Repository
public interface EmpDao extends JpaRepository<Employee, String> {

	Employee findEmployeeById(String id);
	
	//List<Employee> findAllBySkills(Skill skill);
	
	
	
}
