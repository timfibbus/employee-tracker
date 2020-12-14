package com.timfibbus.perficiency.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	@Id @GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy = "uuid2")
	private String id;
	@OneToOne(mappedBy = "address")
	private Employee employee;
	private String street;
	private String suite;
	private String city;
	private String region;
	private String postal;
	private String country;

	
	public Address(String id, Employee employee, String street, String suite, String city, String region, String postal,
			String country) {
		super();
		this.id = id;
		this.employee = employee;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.region = region;
		this.postal = postal;
		this.country = country;
	}

	public Address(String id, Employee employee, String street, String city, String region, String postal,
			String country) {
		super();
		this.id = id;
		this.employee = employee;
		this.street = street;
		this.city = city;
		this.region = region;
		this.postal = postal;
		this.country = country;
	}

	public Address() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId() {
		UUID uuid = UUID.randomUUID();
		id = uuid.toString();
	}
	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [  street=" + street + ", suite=" + suite
				+ ", city=" + city + ", region=" + region + ", postal=" + postal + ", country=" + country + "]";
	}

}
