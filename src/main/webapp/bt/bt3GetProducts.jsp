<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Products</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<h1>Product List</h1>
<h3><a href="/bt/bt4AddProduct.jsp">Add new product</a></h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="pro">
        <c:if test="${empty products}">
            <p>No products found.</p>
        </c:if>
        <c:if test="${!empty products}">
            <tr>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td><img src="${pro.imgUrl}" alt="${pro.name}" style="max-width: 50px; max-height: 50px;" /></td>
                <td>${pro.price}</td>
                <td>${pro.stock}</td>
                <td>
                    <button class="bg-secondary text-secondary-foreground hover:bg-secondary/80 px-2 py-1 rounded">Edit</button>
                    <button class="bg-destructive text-destructive-foreground hover:bg-destructive/80 px-2 py-1 rounded">Delete</button>
                </td>
            </tr>
        </c:if>


    </c:forEach>
    </tbody>
</table>
</body>
</html>
