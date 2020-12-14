package com.timfibbus.perficiency.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timfibbus.perficiency.entity.Skill;


@Repository
public interface SkillDao extends JpaRepository<Skill, Long>{

	Skill  findSkillFromEmployeeByEmployee(String employeeId);
	
	List<Skill>  findAllByEmployeeId(String employeeId);
	
	Skill  findByEmployeeIdAndId(String emp, String ski);
	
	//Skill  updateSkillFromEmployeeByEmployeeId(String employeeId);
	
	//Skill  removeSkillFromEmployeeByEmployeeId(String employeeId);
	
	//Skill  deleteSkillFromEmployeeByEmployeeId(String employeeId);
	
}
