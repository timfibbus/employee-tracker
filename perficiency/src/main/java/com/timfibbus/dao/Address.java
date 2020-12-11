package com.timfibbus.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "employee_id")
	private String employeeId;
	private String street;
	private String suite;
	private String city;
	private String region;
	private String postal;
	private String country;

	
	public Address(Long id, String employeeId, String street, String suite, String city, String region, String postal,
			String country) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.region = region;
		this.postal = postal;
		this.country = country;
	}

	public Address() {
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
		return "Address [id=" + id + ", employeeId=" + employeeId + ", street=" + street + ", suite=" + suite
				+ ", city=" + city + ", region=" + region + ", postal=" + postal + ", country=" + country + "]";
	}

}
