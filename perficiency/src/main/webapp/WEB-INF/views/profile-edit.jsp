<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Edit Profile</title>
</head>
<body>

<div class="container card">
<form action="/employee-update/${thatOne.id}" method="post">
<p>
</p>
<label class="form-label">Personal Info</label>
<div class="input-group mb-3">
  <span class="input-group-text">First</span>
  <input type="text" name="firstName" class="form-control" value="${thatOne.firstName }" >
  <span class="input-group-text">Last</span>
  <input type="text" name="lastName" class="form-control" value="${thatOne.lastName }" >
  <span class="input-group-text">Contact Email</span>
  <input type="email" name="contactEmail" class="form-control" value="${thatOne.contactEmail }" >
</div>

<div class="input-group mb-3">
<span class="input-group-text">Birth Date</span>
  <input id="txtDate" name="birthDate" type="text" class="form-control date-input" value="${thatOne.birthDate }">
  <span class="input-group-text">Hired Date</span>
  <input id="txtDate" name="hiredDate" type="text" class="form-control date-input" value="${thatOne.hiredDate }">
  <span class="input-group-text">Company Email</span>
  <input type="email" name="companyEmail" class="form-control" value="${thatOne.companyEmail }">
</div>


<label for="basic-url" class="form-label">Business Info</label>

 <div class="input-group mb-3">
  <span class="input-group-text">Role</span>
  <select name="role" >
                <option >Select Role</option>
                <option value="Technical Consultant">Technical Consultant</option>
				<option value="Project Manager">Project Manager</option>
				<option value="Director">Director</option>
				<option value="Chief">Chief</option>
			
  </select>
    <span class="input-group-text">Business Unit</span>
  <select name="businessUnit" >
                <option >Select Business Unit</option>
                <option value="Digital Experience Group">Digital Experience Group</option>
				<option value="Adobe">Adobe</option>
				<option value="IBM NBU">IBM NBU</option>
				<option value="API Management">API Management</option>
  </select>

  <span class="input-group-text">Assigned To</span>
  <input type="email" class="form-control" value="${thatOne.assignedTo }" >
</div>

<label for="basic-url" class="form-label">Address</label>
<div class="input-group mb3">
    <span class="input-group-text">Street</span>
<input type="text" name="street" class="form-control" value="${thatOne.address.street }" >
    <span class="input-group-text">Apt/Suite</span>

<input type="text" name="suite" class="form-control" value="${thatOne.address.suite }" >
    <span class="input-group-text">City</span>

<input type="text" name="city" class="form-control" value="${thatOne.address.city }" >
</div>

<div class="input-group-text mb3">
    <span class="input-group-text">Region</span>
<input type="text" name="region" class="form-control" value="${thatOne.address.region }" >

    <span class="input-group-text">Postal Code</span>
<input type="text" name="postal" class="form-control" value="${thatOne.address.postal }" >

    <span class="input-group-text">Country (i.e. USA, UK)</span>
<input type="text" name="country" class="form-control" value="${thatOne.address.country }" >
</div>
<p>
</p>
<div>
	<input type="submit" class="button btn-primary" value="Submit Changes">
</div>
</form>
<p>
</p>
</div>

</body>
</html>