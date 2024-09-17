<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Categories</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 20px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        table {
            width: 90%;
            margin: 0 auto;
            background-color: #ffffff;
            border-collapse: separate;
            border-spacing: 0;
        }
        th, td {
            text-align: center;
            padding: 16px;
        }
        th {
            background-color: #343a40;
            color: #ffffff;
        }
        tbody tr:nth-child(odd) {
            background-color: #f9f9f9;
        }
        tbody tr:nth-child(even) {
            background-color: #ffffff;
        }
        .btn-sm {
            margin: 0 2px;
        }
        .btn-danger {
            margin-left: 5px;
        }
    </style>
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
                <td colspan="3" class="text-center">No categories found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<script>
    function confirmDelete(id, name) {
        if (confirm("Are you sure you want to delete the category '" + name + "'? This action will also delete all books in this category if there are any.")) {
            window.location.href = "CategoryServlet?action=DELETE&id=" + id;
        }
    }
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
