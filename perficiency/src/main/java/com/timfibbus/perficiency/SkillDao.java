package com.timfibbus.perficiency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository <Skill, Long>{

	Skill  findSkillFromEmployeeByEmployee(String employeeId);
	
	//Skill  updateSkillFromEmployeeByEmployeeId(String employeeId);
	
	//Skill  removeSkillFromEmployeeByEmployeeId(String employeeId);
	
	//Skill  deleteSkillFromEmployeeByEmployeeId(String employeeId);
	
}
