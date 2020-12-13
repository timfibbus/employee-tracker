package com.timfibbus.perficiency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.timfibbus.perficiency.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, String>{

}
