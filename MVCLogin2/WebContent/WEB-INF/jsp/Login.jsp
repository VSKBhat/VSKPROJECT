<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form:form method="Post" action="loginUser" commandName="command">
		<h4>
			<spring:message code="login.userid" text="User ID" />
		</h4>
		<form:input path="userID" class="form-control" />
		<form:errors path="userID" />
		<h4>
			<br>
			<spring:message code="register.pwd" text="Password" />
		</h4>
		<form:password path="password" class="form-control" />
		<form:errors path="password" class="red" />
		<br>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>