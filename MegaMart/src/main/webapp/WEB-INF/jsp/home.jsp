<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="/register" modelAttribute="test">

<input type="submit" value="Register">
</form:form>
<form:form method="POST" action="/login" modelAttribute="login">
<input type="submit" value="Login">
</form:form>
</body>
</html>