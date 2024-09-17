<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="my-4">Edit Book</h2>
    <form action="/BookServlet?action=UPDATE" method="post">
        <input type="hidden" id="id" name="id" value="${book.id}">

        <div class="form-group">
            <label for="category_id">Category ID</label>
            <input type="number" class="form-control" id="category_id" name="category_id" value="${book.category_id}" readonly>
        </div>

        <div class="form-group">
            <label for="name">Book Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${book.name}" required>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" value="${book.price}" required>
        </div>

        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="number" class="form-control" id="stock" name="stock" value="${book.stock}" required>
        </div>

        <div class="form-group">
            <label for="total_pages">Total Pages</label>
            <input type="number" class="form-control" id="total_pages" name="totalPages" value="${book.totalPages}" required>
        </div>

        <div class="form-group">
            <label for="year_created">Year Created</label>
            <input type="number" class="form-control" id="year_created" name="yearCreated" value="${book.yearCreated}" required>
        </div>

        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" class="form-control" id="author" name="author" value="${book.author}" required>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <select class="form-control" id="status" name="status" required>
                <option value="true" ${book.status ? "selected" : ""}>Active</option>
                <option value="false" ${!book.status ? "selected" : ""}>Inactive</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Update Book</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
