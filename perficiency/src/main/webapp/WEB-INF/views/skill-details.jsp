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

<form action="/employee-profile/${id }/update/${skill.id}">
	<h2>${skill.summary }</h2>
	<div>
	<p>Field Name:          ${skill.field.name }</p>
	<p>Field Type:          ${skill.field.type }</p>
	<p>Experience(months):  ${skill.experience }</p>
	</div>
	
	<input type = "submit"  value="Update Skill"  />
 </form>
</body>
</html>