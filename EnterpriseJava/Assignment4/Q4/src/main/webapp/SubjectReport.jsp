<%-- 
    Document   : SubjectReport
    Created on : 12 Mar 2026, 11:48:52 am
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
        <h2>Subjectwise Students</h2>

        <c:forEach var="sub" items="${subjects}">

        <h3>${sub.name}</h3>

        <ul>
        <c:forEach var="stu" items="${sub.studentCollection}">
        <li>${stu.name}</li>
        </c:forEach>
        </ul>

        </c:forEach>
    </body>
</html>
