<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Registration</title>
</head>
<body>
<h1 align = "center">Book Registration Form</h1>
<hr>
<spring:form action = "books" method = "post" modelAttribute = "books" >
	<table align = "center">
	<spring:hidden path="bid"/>
		<tr>
			<td><spring:label path="bname">Book Name:</spring:label></td>
			<td><spring:input path="bname"/></td>
		</tr>
		<tr>
			<td><spring:label path="bprice">Book Price:</spring:label></td>
			<td><spring:input path="bprice"/></td>
		</tr>
		<tr>
			<td><spring:label path="bauthor">Book Author</spring:label></td>
			<td><spring:input path="bauthor"/></td>
		</tr>
		<tr>
		
			<td><input type = "submit" value = "Save Book"></td>
		</tr>
	</table>
	
</spring:form>
</body>
</html>