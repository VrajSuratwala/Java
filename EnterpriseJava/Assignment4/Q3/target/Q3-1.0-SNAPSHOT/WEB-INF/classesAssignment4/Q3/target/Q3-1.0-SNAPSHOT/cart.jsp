<%-- 
    Document   : cart
    Created on : 9 Mar 2026, 7:05:40 pm
    Author     : riya vesuwala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Shopping Cart</h2>

        <table border="1">

        <tr>
        <th>Computer</th>
        <th>Price</th>
        <th>Qty</th>
        <th>Total</th>
        </tr>

        <c:set var="grandTotal" value="0"/>

        <c:forEach var="entry" items="${sessionScope.cart}">

        <tr>

        <td>${entry.key.name}</td>
        <td>${entry.key.price}</td>
        <td>${entry.value}</td>

        <td>${entry.key.price * entry.value}</td>

        <c:set var="grandTotal"
        value="${grandTotal + (entry.key.price * entry.value)}"/>

        </tr>

        </c:forEach>

        </table><br>
        <a href="ComputerServlet">Continue Shopping</a>

        <h3>Total Bill : ${grandTotal}</h3>
    </body>
</html>
