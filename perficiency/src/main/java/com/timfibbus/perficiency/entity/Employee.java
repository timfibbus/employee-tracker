package com.timfibbus.perficiency.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id @GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy = "uuid2")
	private String id;
	private String firstName;
	private String lastName;
	@OneToOne(mappedBy = "employee")
	private Address address;
	private String contactEmail;
	private String companyEmail;
	private String birthDate;
	private String hiredDate;
	@OneToMany(mappedBy = "employee")
	private List<Skill> skills;
	private String role;
	private String businessUnit;
	private String assignedTo;

	public Employee(String id, String firstName, String lastName, Address address, String contactEmail,
			String companyEmail, String birthDate, String hiredDate, List<Skill> skills, String role, String businessUnit, String assignedTo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactEmail = contactEmail;
		this.companyEmail = companyEmail;
		this.birthDate = birthDate;
		this.hiredDate = hiredDate;
		this.skills = skills;
		this.role = role;
		this.businessUnit = businessUnit;
		this.assignedTo = assignedTo;
	}

	public Employee(String id, String firstName, String lastName, Address address, String companyEmail, String birthDate,
			String hiredDate, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.companyEmail = companyEmail;
		this.birthDate = birthDate;
		this.hiredDate = hiredDate;
		this.role = role;
	}

	public Employee() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		UUID uuid = UUID.randomUUID();
		id = uuid.toString();
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", contactEmail=" + contactEmail + ", companyEmail=" + companyEmail + ", birthDate=" + birthDate
				+ ", hiredDate=" + hiredDate + ", skills=" + skills + ", assignedTo=" + assignedTo + "]";
	}

}
