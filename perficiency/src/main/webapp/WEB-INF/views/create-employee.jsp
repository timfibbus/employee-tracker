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
<title>Insert title here</title>
</head>
<body>
<div class="container card">
<form action="/employee-add" method="post">
<p>
</p>
<label class="form-label">Personal Info</label>
<div class="input-group mb-3">
  <span class="input-group-text">First</span>
  <input type="text" name="firstName" class="form-control" required>
  <span class="input-group-text">Last</span>
  <input type="text" name="lastName" class="form-control" required>
  <span class="input-group-text">Contact Email</span>
  <input type="email" name="contactEmail" class="form-control"  >
</div>

<div class="input-group mb-3">
<span class="input-group-text">Birth Date</span>
  <input id="txtDate" name="birthDate" type="date" class="form-control date-input" required>
  <span class="input-group-text">Hired Date</span>
  <input id="txtDate" type="date" name="hiredDate" class="form-control date-input" required>
  <span class="input-group-text">Company Email</span>
  <input type="email" name="companyEmail" class="form-control" required>
</div>


<label for="basic-url" class="form-label">Business Info</label>

 <div class="input-group mb-3">
  <span class="input-group-text">Role</span>
  <select name="role" required>
                <option >Select Role</option>
                <option value="Technical Consultant">Technical Consultant</option>
				<option value="Project Manager">Project Manager</option>
				<option value="Director">Director</option>
				<option value="Chief">Chief</option>
			
  </select>
    <span class="input-group-text">Business Unit</span>
  <select name="businessUnit" required>
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
<input type="text" name="street" class="form-control" required>
    <span class="input-group-text">Apt/Suite</span>

<input type="text" name="suite" class="form-control">
    <span class="input-group-text">City</span>

<input type="text" name="city" class="form-control" required>
</div>

<div class="input-group-text mb3">
    <span class="input-group-text">Region</span>
<input type="text" name="region" class="form-control" required maxlength="3" >

    <span class="input-group-text">Postal Code</span>
<input type="text" name="postal" class="form-control" required maxlength="10">

    <span class="input-group-text">Country (i.e. USA, UK)</span>
<input type="text" name="country" class="form-control" required maxlength="3">
</div>
<p>
</p>
<div>
	<input type="submit" class="button btn-primary" value="Add Employee">
</div>
</form>
<p>
</p>
</div>

</body>
</html>