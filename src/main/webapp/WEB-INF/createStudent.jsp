<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>New Student</h1>
    <hr>
    <a href="/dorms">Dashboard</a>
    <hr>
    <form:form action="/students/new" method="post" modelAttribute="student" >
        <div>
            <form:label path="name">Name:</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </div>
        <form:label path="dorm">Select Dorm:</form:label>
        <form:select path="dorm">
            <c:forEach items="${allDorms}" var="currentDorm">
                <option value="${currentDorm.id}"><c:out value="${currentDorm.name}"/></option>
            </c:forEach>
        </form:select>
        <hr>
        <input type="submit" value="Add">
    </form:form>
</body>
</html>