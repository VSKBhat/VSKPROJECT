<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>

	<h3>Cart Page</h3>
	<form action="/cart/update" method="post">
		<table cellpadding="2" cellspacing="2" border="1">
			<tr>
				<th>Option</th>
				<th>Id</th>
				<th>Name</th>

				<th>Price</th>
				<th>
				Quantity
				<input type="submit" value="Update Items">
				</th>
				<th>Sub Total</th>
			</tr>
			<c:set var="total" value="0"></c:set>
			<c:forEach var="item" items="${sessionScope.cart }">
				<c:set var="total"
					value="${total + item.product.price * item.quantity }"></c:set>
				<tr>
					<td align="center"><a
						href="${pageContext.request.contextPath }/cart/remove/${item.product.pid }"
						onclick="return confirm('Are you sure?')">Remove</a></td>
					<td>${item.product.pid }</td>
					<td>${item.product.pname }</td>
					<td>${item.product.price }</td>
					<td><input type="number" value=${item.quantity }
						name="quantity"></td>
					<td>${item.product.price * item.quantity }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right">Sum</td>
				<td>${total }</td>
			</tr>
		</table>
	</form>
	<br>
	<form action="/shop" method="post">
		<input type="submit" value="Continue Shopping">
	</form>
	<form:form action="/cart/checkout" method="post" modelAttribute="login">
		<input type="submit" value="Check Out">
	</form:form>



</body>
</html>