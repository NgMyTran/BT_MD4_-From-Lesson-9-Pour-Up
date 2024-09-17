
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Books</title>
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
            text-align: center; /* Center content in the container */
        }
        table {
            width: 90%; /* Increase width of the table */
            margin: 0 auto; /* Center the table horizontally */
            background-color: #ffffff;
            border-collapse: separate; /* Add spacing between cells */
            border-spacing: 0; /* Remove default spacing */
        }
        th, td {
            text-align: center; /* Center text in cells */
            padding: 16px; /* Increase padding */
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
        .table-striped tbody tr:nth-child(odd) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-4">List of Books</h1>
<div>
    <a href="BookServlet?action=ADD" class="btn btn-primary mb-3">Add New Book</a>
</div>
    <br/>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Book's Name</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
<%--                <td>${book.category_id}</td>--%>
                <td>
                    <c:forEach var="category" items="${categories}">
                        <c:if test="${category.id == book.category_id}">
                            ${category.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.stock}</td>
                <td>${book.status ? "Active" : "Inactive"}</td>
                <td>
                    <a href="BookServlet?action=DETAIL&id=${book.id}" class="btn btn-info btn-sm">Detail</a>
                    <a href="BookServlet?action=EDIT&id=${book.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="BookServlet?action=DELETE&id=${book.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this book?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty books}">
            <tr>
                <td colspan="7" class="text-center">No books found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
