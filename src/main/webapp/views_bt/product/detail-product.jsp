<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/10/2024
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Detail Product</h1>
<a href="/ProductServlet?action=GETALL">Back</a>
<table border="1" cellspacing="0" cellpadding="10">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Status</th>
        <th>Category</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${pro.id}</td>
        <td>${pro.name}</td>
        <td>${pro.price}</td>
        <td>${pro.stock}</td>
        <td>${pro.status ? 'Active' : 'Inactive'}</td>
        <td>${pro.category.name}</td>
        <td><a href="/ProductServlet?action=EDIT&id=${pro.id}">Edit</a></td>
        <td><a href="/ProductServlet?action=DELETE&id=${pro.id}">Delete</a></td>
    </tr>
</body>
</html>
