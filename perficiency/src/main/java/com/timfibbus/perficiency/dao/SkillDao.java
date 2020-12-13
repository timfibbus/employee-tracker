package com.timfibbus.perficiency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.timfibbus.perficiency.entity.Skill;


@Repository
public interface SkillDao extends JpaRepository<Skill, Long>{

	Skill  findSkillFromEmployeeByEmployee(String employeeId);
	
	//Skill  updateSkillFromEmployeeByEmployeeId(String employeeId);
	
	//Skill  removeSkillFromEmployeeByEmployeeId(String employeeId);
	
	//Skill  deleteSkillFromEmployeeByEmployeeId(String employeeId);
	
}
