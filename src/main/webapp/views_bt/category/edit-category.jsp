<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/10/2024
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Edit Category</h1>
<form action="/CategoryServlet" method="post">
    <input type="number" name="id" value="${category.id}" readonly>
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${category.name}">
    </div>
    <div>
        <label>Status</label>
        <label>
            <input type="radio" name="status" value="true" ${category.status?'checked':''}> Active
        </label>
        <label>
            <input type="radio" name="status" value="false" ${!category.status?'checked':''}> Inactive
        </label>
    </div>
    <input type="submit" name="action" value="UPDATE">
</form>
</body>
</html>
