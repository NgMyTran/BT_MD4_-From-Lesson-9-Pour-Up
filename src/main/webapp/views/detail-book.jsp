<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Book Details</h1>

    <a href="BookServlet?action=GETALL" class="btn btn-secondary mb-3">Back to List</a>

    <c:if test="${not empty book}">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${book.name}</h5>
                <p class="card-text">Category: I ${book.category_id}</p>
                <p class="card-text">Price:${book.price}</p>
                <p class="card-text">Stock:${book.stock}</p>
                <p class="card-text">Total Page: ${book.totalPages}</p>
                <p class="card-text">Year Create: ${book.yearCreated}</p>
                <p class="card-text">Author:${book.author}</p>
                <p class="card-text">Status:${book.status ? 'Active' : 'Inactive'}</p>
            </div>
        </div>
    </c:if>
    <c:if test="${empty book}">
        <div class="alert alert-warning" role="alert">
            No book details available.
        </div>
    </c:if>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
