<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login</title>
</head>
<body>

       
<div align="center">
    <h2>Product List</h2>
    <form:form method="get" action="/search" modelAttribute="search">
        <input type="text" name="pname" /> &nbsp;
        <form:errors name="pname"></form:errors>
        <input type="submit" value="Search" />
    </form:form>
    
    <br/>
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
        <c:forEach items="${Products}" var="product" varStatus="tagStatus">
        <tr>
            <td>${product.pid}</td>
            <td>${product.pname}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.discount}</td>
            <td>${product.delivery_charge}</td>
            <td>${product.avg_rating}</td>
            <td>${product.seller_name}</td>
            <td><form:form action="/Addtocart/${product.pid}" method="post" modelAttribute="productInfo">
                <input type="submit" value="Add to cart"/>
                </form:form>
                &nbsp;&nbsp;&nbsp;
                <a href="/buy?pid=${product.pid}">Buy Product </a>
            </td>
        </tr>
        </c:forEach>
    </table>


  </div>
</body>
</html>