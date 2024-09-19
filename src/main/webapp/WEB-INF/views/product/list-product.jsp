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
    <title>List of Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">List of Products</h1>
    <a href="ProductServlet?action=ADD" class="btn btn-primary mb-3">Add New Product</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Category ID</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.stock}</td>
                <td>${product.categoryId}</td>
                <td>${product.status ? 'Available' : 'Unavailable'}</td>
                <td>
                    <a href="ProductServlet?action=EDIT&id=${product.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="ProductServlet?action=DELETE&id=${product.id}" class="btn btn-danger btn-sm" onclick="confirmDelete('${product.id}', '${product.name}'); return false;">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty products}">
            <tr>
                <td colspan="7" class="text-center">No products found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
