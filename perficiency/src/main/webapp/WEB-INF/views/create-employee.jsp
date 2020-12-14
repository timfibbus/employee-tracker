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
<body class="container">

<form method="post" action="/employees">
 <div class="mb-3">
    <label class="form-label">First Name</label>
    <input type="text" name="firstName" class="form-control">
  </div>
   <div class="mb-3">
    <label class="form-label">Last Name</label>
    <input type="text" name="lastName" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">Company Email Address</label>
    <input type="email" name="companyEmail" class="form-control" aria-describedby="emailHelp">
  </div>
   <div class="mb-3">
    <label class="form-label">Birth Date</label>
    <input type="text" name="birthDate" class="form-control">
  </div>
   <div class="mb-3">
    <label class="form-label">Hire Date</label>
    <input type="text" name="hiredDate" class="form-control">
  </div>
   <div class="mb-3">
    <label class="form-label">Role</label>
    <input type="text" name="role" class="form-control">
  </div>
  <div>
  	<h2>Address</h2>
  </div>
   <div class="mb-3">
    <label class="form-label">Street</label>
    <input type="text" name="street" class="form-control">
  </div>
   <div class="mb-3">
    <label class="form-label">Apt/Suite</label>
    <input type="text" name="suite" class="form-control">
  </div>
   <div class="mb-3">
    <label class="form-label">City</label>
    <input type="text" name="city" class="form-control">
  </div>
     <div class="mb-3">
    <label class="form-label">Region/State</label>
    <input type="text" name="region" class="form-control">
  </div>
      <div class="mb-3">
    <label class="form-label">Country</label>
    <input type="text" name="country" class="form-control">
  </div>
      <div class="mb-3">
    <label class="form-label">Postal Code</label>
    <input type="text" name="postal" class="form-control">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>