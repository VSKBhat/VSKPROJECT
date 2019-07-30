<%@ page language="java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/Login" modelAttribute="login" >
		<table>
			<tr>

				<td><form:label path="name">UserName</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" />
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password"></form:errors>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>
	<form:form method="POST" action="/register" modelAttribute="test">
	<h3>Not Registered?</h3><input type="submit" value="Register Now">
	</form:form>
</body>
</html>