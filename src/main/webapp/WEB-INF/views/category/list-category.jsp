<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 12:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="style.css">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Categories</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">List of Categories</h1>
    <a href="CategoryServlet?action=ADD" class="btn btn-primary mb-3">Add New Category</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.status ? 'Active' : 'Inactive'}</td>
                <td>
                    <a href="CategoryServlet?action=EDIT&id=${category.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="CategoryServlet?action=DELETE&id=${category.id}" class="btn btn-danger btn-sm" onclick="confirmDelete('${category.id}', '${category.name}'); return false;">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty categories}">
            <tr>
                <td colspan="4" class="text-center">No categories found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
