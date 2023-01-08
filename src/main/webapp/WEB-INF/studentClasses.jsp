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
    <title><c:out value="${student.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1><c:out value="${student.name}"/>'s classes </h1>
    <hr>
    <a href="/">Dashboard</a>
    <hr>
    <form method="post" action="/students/${student.id}">
        <select id="classId" name="classId">
            <c:forEach items="${leftClasses}" var="currClass">
                <option value="${currClass.id}"><c:out value="${currClass.name}"/></option>
            </c:forEach>
        </select>
        <input type="submit" value="Add">
    </form>
        <hr>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                   <th>Class Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${classes}" var="currClass">
                    <tr>
                        <td><a href="/classes/${currClass.id}"><c:out value="${currClass.name}"/></a> </td>
                        <td><a href="/drop/${student.id}/${currClass.id}">Drop</a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>