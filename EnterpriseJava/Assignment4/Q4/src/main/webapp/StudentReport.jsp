<%-- 
    Document   : StudentReport
    Created on : 12 Mar 2026, 11:45:00 am
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
        <h2>Studentwise Subjects</h2>

        <c:forEach var="stu" items="${students}">

        <h3>${stu.name}</h3>

        <ul>
        <c:forEach var="sub" items="${stu.subjectCollection}">
        <li>${sub.name}</li>
        </c:forEach>
        </ul>

        </c:forEach>    
    </body>
</html>
