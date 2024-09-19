<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 1:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Shopping Cart</title>
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
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-4">Add New Shopping Cart</h1>
    <form action="ShoppingCartServlet?action=ADD" method="post">
        <div class="mb-3">
            <label for="userId" class="form-label">User ID</label>
            <input type="number" id="userId" name="userId" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="productId" class="form-label">Product ID</label>
            <input type="number" id="productId" name="productId" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="number" id="quantity" name="quantity" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Shopping Cart</button>
    </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
