<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Delete</title>
</head>
<body>
<h1>Confirm Deletion</h1>
<p>Category "${categoryToDelete.name}" contains products. You need to delete all products associated with this category first. Do you want to delete this category and all associated products?</p>
<form action="/CategoryServlet" method="get">
    <input type="hidden" name="action" value="CONFIRMDELETE">
    <input type="hidden" name="id" value="${categoryToDelete.id}">
    <button type="submit" name="confirm" value="yes">Yes</button>
    <button type="submit" name="confirm" value="no">No</button>
</form>
</body>
</html>
