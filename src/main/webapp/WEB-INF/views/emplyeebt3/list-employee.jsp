<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>EMPLOYEE LIST</h1>
<body>
<a href="/employee/add">+ ADD NEW EMPLOYEE</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>ADDRESS</th>
        <th>PHONE</th>
        <th>STATUS</th>
        <th colspan="2">ACTION</th>
    </tr>
    <tbody>
    <c:forEach items="${list}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.address}</td>
            <td>${e.phone}</td>
            <td>${e.status ? "Active":"Inactive"}</td>
            <td><a href="">Edit</a></td>
            <td><a href="">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
