<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="style.css">


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">List of Users</h1>
    <a href="UserServlet?action=ADD" class="btn btn-primary mb-3">Add New User</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.fullName}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.phone}</td>
                <td>${user.status ? 'Active' : 'Inactive'}</td>
                <td>
                    <a href="UserServlet?action=EDIT&id=${user.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="UserServlet?action=DELETE&id=${user.id}" class="btn btn-danger btn-sm" onclick="confirmDelete('${user.id}', '${user.fullName}'); return false;">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty users}">
            <tr>
                <td colspan="7" class="text-center">No users found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
