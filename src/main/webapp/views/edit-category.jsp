<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/17/2024
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Category</title>
    <link href="http://localhost:999/webapp/css/app.css" rel="stylesheet" />
</head>
<body>
<div class="container mt-4">
    <h2>Edit Category</h2>
    <form action="/CategoryServlet?action=UPDATE" method="post">
        <input type="hidden" name="id" value="${category.id}" />
        <label>Name:</label>
        <input type="text" name="name" value="${category.name}" />
        <label>Status:</label>
        <input type="checkbox" name="status" ${category.status ? 'checked' : ''} />
        <button type="submit" name="action" value="UPDATE">Save</button>
    </form>



</div>

<!-- Update JS script link -->
<script src="http://localhost:999/webapp/js/app.js"></script>
</body>
</html>


