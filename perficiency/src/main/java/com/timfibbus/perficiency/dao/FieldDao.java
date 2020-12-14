package com.timfibbus.perficiency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timfibbus.perficiency.entity.Field;


@Repository
public interface FieldDao extends JpaRepository<Field, Long> {
	
	
	
	

}
