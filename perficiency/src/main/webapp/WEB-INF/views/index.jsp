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
<title>Employeez</title>
</head>
<body>

<div class="container">
		
  <table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Company Email</th>
      <th scope="col">Hired Date</th>
      <th scope="col">Role</th>
    </tr>  
  </thead>
  <tbody>
  <c:forEach items="${employees}" var="employee" >
  	 
    <tr>
      <th scope="row"><form action="/employees/${employee.id }"><a class="nav-link" href="/">${employee.id }</a></form></th>
      <td>${employee.firstName }</td>
      <td>${employee.lastName }</td>
      <td>${employee.companyEmail }</td>
      <td>${employee.hiredDate }</td>
      <td>${employee.role }</td>
      <td><form action="/delete/${employee.id }" method="post"><button class="btn-warning" value="${employee.id }">DELETE EMPLOYEE</button></form></td>
    </tr>
    
  </c:forEach>
  </tbody>
  </table>
  
  <a class="nav-link" href="/create-employee">Add Employee</a>
		
</div>

</body>
</html>