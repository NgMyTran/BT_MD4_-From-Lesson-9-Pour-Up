<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Category</title>
    <link href="http://localhost:999/webapp/css/app.css" rel="stylesheet" />
</head>
<body>
<div class="container mt-4">
    <h2>Add New Category</h2>
    <form action="/CategoryServlet?action=ADD" method="post">
        <div class="mb-3">
            <label for="category_name" class="form-label">Category Name</label>
            <input type="text" class="form-control" id="category_name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="category_status" class="form-label">Category Status</label>
            <select id="category_status" name="status" class="form-select" required>
                <option value="true">Active</option>
                <option value="false">Inactive</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
        <a href="/CategoryServlet?action=GETALL" class="btn btn-secondary">Back to List</a>
    </form>
</div>
<script src="http://localhost:999/webapp/js/app.js"></script>
</body>
</html>
