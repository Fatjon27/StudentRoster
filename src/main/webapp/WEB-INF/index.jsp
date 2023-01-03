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
    <title>Dorms</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1 class="text-md-center">Dorms</h1>
    <a href="/dorms/new" class="text-center">Add a new dorm</a>
    <hr>
    <a href="/students/new" class="text-center">Add a new student</a>
    <hr>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>Dorm</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allDorms}" var="currentDorm">
                <tr>
                    <td><c:out value="${currentDorm.name}"/></td>
                    <td><a href="/dorms/${currentDorm.id}">See Students</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>