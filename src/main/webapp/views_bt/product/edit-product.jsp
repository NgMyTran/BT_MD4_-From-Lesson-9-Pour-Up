<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa Product</title>
</head>
<body>
<h1>Chỉnh sửa Product</h1>

<form action="/ProductServlet" method="post">
    <input type="hidden" name="action" value="UPDATE">
    <input type="hidden" name="id" value="${product.id}">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${product.name}">
    </div>
    <div>
        <label for="price">Price</label>
        <input type="number" step="0.01" name="price" id="price" value="${product.price}">
    </div>
    <div>
        <label for="stock">Stock</label>
        <input type="number" name="stock" id="stock" value="${product.stock}">
    </div>
    <div>
<%--        <label for="status">Status</label>--%>
<%--        <input type="checkbox" name="status" id="status" ${product.status ? 'checked' : ''}>--%>
    <label>Status</label>
    <div>
        <input type="radio" name="status" id="active" value="true" ${product.status ? 'checked' : ''}>
        <label for="active">Active</label>
    </div>
    <div>
        <input type="radio" name="status" id="inactive" value="false" ${!product.status ? 'checked' : ''}>
        <label for="inactive">Inactive</label>
    </div>
    </div>
    <div>
        <label for="categoryId">Category</label>
        <select name="categoryId" id="categoryId">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}" ${c.id == product.category.id ? 'selected' : ''}>${c.name}</option>
            </c:forEach>
        </select>
    </div>
    <input type="submit" value="Update Product">
</form>
</body>
</html>
