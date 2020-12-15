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

<h3>Skills</h3>

	<c:forEach var="skill" items="${allSkills }">
	<form action="/employee-profile/${id }/delete/${skill.id }">
		<p><c:out value="${skill.summary }"/></p>
		<p><c:out value="${skill.experience }"/></p>
		<p><c:out value="${skill.field.name }"/></p>
		<p><c:out value="${skill.field.type }"/></p>
		<br>
		<input type="hidden" value="${skill.id }"/>
		<button class="btn-warning" type="submit">DELETE SKILL</button>
	</form>
	</c:forEach>
	<a class="nav-link" href="/skill-form/${id }" >ADD SKILL</a>
<br>
<div>
<a class="nav-link" href="/employee-list">Return To Employee Index</a>
</div>
</body>
</html>