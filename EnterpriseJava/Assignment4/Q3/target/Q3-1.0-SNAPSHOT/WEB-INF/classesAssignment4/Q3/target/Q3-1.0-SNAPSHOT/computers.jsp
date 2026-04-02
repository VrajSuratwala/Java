<%-- 
    Document   : computers
    Created on : 9 Mar 2026, 7:04:52 pm
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
        <h3>Computer Store</h3>
        <c:forEach var="c" items="${computerList}">
        <table border="1">

        <tr>
        <td>${c.name}</td>
        <td>${c.price}</td>

        <td>
        <a href="CartServlet?id=${c.id}">
        Add To Cart
        </a>
        </td>

        </tr>

        </table>
        </c:forEach>
    </body>
</html>
