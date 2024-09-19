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
    <title>List of Shopping Carts</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">List of Shopping Carts</h1>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Product ID</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cart" items="${carts}">
            <tr>
                <td>${cart.id}</td>
                <td>${cart.userId}</td>
                <td>${cart.productId}</td>
                <td>${cart.quantity}</td>
                <td>
                    <a href="ShoppingCartServlet?action=DELETE&id=${cart.id}" class="btn btn-danger btn-sm" onclick="confirmDelete('${cart.id}', 'Product ID: ${cart.productId}'); return false;">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty carts}">
            <tr>
                <td colspan="5" class="text-center">No shopping carts found.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
