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
<form action="/employee-profile/${id}/add-skill">

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Skill Summary</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="summary"></textarea>
</div>
<label class="form-label">Skill Info</label>
<div class="input-group mb-3">
  <span class="input-group-text">Experience, In Months</span>
  <input type="number" name="experience" class="form-control" required>
  <span class="input-group-text">Field Name</span>
  <input type="text" name="name" class="form-control" required>
  <span class="input-group-text">Field Type</span>
  <input type="text" name="type" class="form-control"  required>
</div>
<input type="submit" value="add skill" />

</form>
</div>
<br>
<div>
<a class="nav-link" href="/employee-list">Return To Employee Index</a>
</div>
</body>
</html>