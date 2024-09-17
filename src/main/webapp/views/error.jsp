<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/17/2024
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-4">Error</h1>
    <div class="alert alert-danger">
        <c:out value="${message}" />
    </div>
    <a href="CategoryServlet?action=GETALL" class="btn btn-primary">Back to Categories</a>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
