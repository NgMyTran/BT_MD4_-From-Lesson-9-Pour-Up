<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới Product</title>
</head>
<body>
<h1>Thêm mới Product</h1>
<form action="/ProductServlet" method="post">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="price">Price</label>
        <input type="number" step="0.01" name="price" id="price">
    </div>
    <div>
        <label for="stock">Stock</label>
        <input type="number" name="stock" id="stock">
    </div>
    <div>
        <label for="status">Status</label>
        <input type="checkbox" name="status" id="status" checked>
    </div>
    <div>
        <label for="categoryId">Category</label>
        <select name="categoryId" id="categoryId">
            <!-- Populate categories here -->
        </select>
    </div>
    <input type="submit" name="action" value="ADD">
</form>
</body>
</html>
