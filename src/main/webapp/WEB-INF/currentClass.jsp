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
    <title><c:out value="${currentClass.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Students taking <c:out value="${currentClass.name}"/></h1>
    <hr>
    <a href="/">Dashboard</a>
    <hr>
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><a href="/students/${student.id}"><c:out value="${student.name}"/></a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>