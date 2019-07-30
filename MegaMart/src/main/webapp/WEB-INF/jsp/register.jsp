<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	
	<form:form method="POST" action="/Register" modelAttribute="test">
	
		<table>
			<tr>
			
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name"/>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password"></form:errors>
			</tr>
			<tr>
				<td><form:label path="confirm_password">Confirm Password</form:label></td>
				<td><form:password path="confirm_password" /></td>
				<td><form:errors path="confirm_password"></form:errors>
				
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email"></form:errors>
			</tr>
			<tr>
			<td><input type="submit" name="register">
			</td>
			</tr>
		</table>

	</form:form>
</body>
</html>