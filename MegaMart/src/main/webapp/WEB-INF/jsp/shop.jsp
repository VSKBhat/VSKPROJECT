<%@ page language="java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Welcome</h2>
	<form:form method="POST" action="/shop" modelAttribute="product">
		<input type="submit" value="Start Shopping">
	</form:form>
</body>
</html>