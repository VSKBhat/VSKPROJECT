<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h4>Product Details</h4>

 <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Delivery Charge</th>
            <th>Average rating</th>
            <th>Seller Name</th>
        </tr>
	<c:forEach items="${ProductSearch}" var="product" varStatus="tagStatus">
	<tr>
		<td>${product.pid}</td>
		<td>${product.pname}</td>
		<td>${product.description}</td>
		<td>${product.price}</td>
		<td>${product.discount}</td>
		<td>${product.delivery_charge}</td>
		<td>${product.avg_rating}</td>
		<td>${product.seller_name}</td>
		<td>
                <a href="${pageContext.request.contextPath }/cart/${product.pid}">Add to Cart</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/buy?pid=${product.pid}">Buy Product </a>
                 &nbsp;&nbsp;&nbsp;
                <a href="/addtoWishList/${product.pid }">Add to WishList</a>
            </td>
		</tr>
		</c:forEach>
		</table>
		</div>
</body>
</html>