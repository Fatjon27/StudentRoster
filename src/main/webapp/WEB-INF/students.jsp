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
    <title><c:out value="${dorm.name}"/> </title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1><c:out value="${dorm.name}"/> Students</h1>
    <hr>
    <a href="/dorms">Dashboard</a>
    <hr>
<%--    <form:form action="/students/new" method="post" modelAttribute="student">--%>
<%--        <form:label path="name">Name:</form:label>--%>
<%--        <form:errors path="name"/>--%>
<%--        <form:input path="name"/>--%>
<%--        <form:label path="dorm">Students:</form:label>--%>
<%--        <form:select path="dorm">--%>
<%--            <c:forEach items="${dorm.students}" var="student">--%>
<%--                <option value="${student.id}"><c:out value="${student.name}"/> <c:out value="${student.dorm.name}"/></option>--%>
<%--            </c:forEach>--%>
<%--        </form:select>--%>
<%--        <input type="submit" value="Add">--%>
<%--    </form:form>--%>
<%--    <hr>--%>
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Student</th>
                <th>Action</th>
            </tr>
        </thead>
            <tbody>
                <c:forEach items="${dorm.students}" var="student">
                    <tr>
                            <td><a href="/students/${student.id}"><c:out value="${student.name}"/></a></td>
                            <td>
                                <form:form action="/delete/${dorm.id}/${student.id}" method="delete">
                                    <input type="submit" value="Remove">
                                </form:form>
                            </td>
<%--                            <td><a href="http://localhost:8080/delete/${dorm.id}/${student.id}">Remove</a></td>--%>
                    </tr>
                </c:forEach>
            </tbody>
    </table>
</body>
</html>