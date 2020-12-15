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
<title><c:out value="${thatOne.firstName }"/>'s Profile</title>
</head>
<body>




<div class="container card">
	<div class="card-body">
	<h2 class="text-center"><c:out value="${thatOne.firstName }"/> <c:out value="${thatOne.lastName }"></c:out></h2>
	<div class="row align-items-start">
    <div class="col">
      <h3>Company Details</h3>
      	<p>Employee Id:   <c:out value="${thatOne.id }"/></p>
	<p>Contact Email: <c:out value="${thatOne.contactEmail }"/></p>
	<p>Company Email: <c:out value="${thatOne.companyEmail }"/></p>
	<p>Birth Date:    <c:out value="${thatOne.birthDate }"/></p>
	<p>Hired Date:      <c:out value="${thatOne.hiredDate }"/></p>
	<p>Role:            <c:out value="${thatOne.role }"/></p>
	<p>Business Unit:   <c:out value="${thatOne.businessUnit }"/></p>
	<p>Assigned To:     <c:out value="${thatOne.assignedTo }"></c:out></p>
    </div>
    
    <div class="col">
    
   	<h3>Address</h3>
	<p>Street: <c:out value="${thatOne.address.street }"/></p>
	<p>Apt/Suite: <c:out value="${thatOne.address.suite }"/></p>
	<p>City: <c:out value="${thatOne.address.city }"/></p>
	<p>Region: <c:out value="${thatOne.address.region }"/></p>
	<p>Postal Code: <c:out value="${thatOne.address.postal }"/></p>
	<p>Country: <c:out value="${thatOne.address.country }"/></p>
    </div>
    <div class="col">
      
    <h3>Skills</h3>
	<c:forEach var="skill" items="${thatOne.skills }">
		<p><c:out value="${skill.summary }"/></p>
		<p><c:out value="${skill.experience }"/></p>
		<p><c:out value="${skill.field.name }"/></p>
		<p><c:out value="${skill.field.type }"/></p>
	</c:forEach>
    </div>
  </div>
	<div>
	</div>
	</div>
	<a class="nav-link" href="/employee-profile/${thatOne.id }/edit">Edit Profile</a>
	<a class="nav-link" href="/employee-list">Return To List of All Employees</a>
	<a class="nav-link" href="/skill-form/${thatOne.id}">Add Skill To Employee Profile</a>
</div>	
	
</body>
</html>