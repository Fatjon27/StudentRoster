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
    <title>All Classes</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>All Classes</h1>
    <hr>
    <a href="/">Dashboard</a>
    <hr>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th class="col">Class</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allClasses}" var="currClass">
                <tr>
                    <td><a href="/classes/${currClass.id}"><c:out value="${currClass.name}"/></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>