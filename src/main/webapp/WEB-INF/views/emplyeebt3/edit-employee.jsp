<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/employee/edit" method="post">
    <input type="hidden" name="id" value="${employee.id}"> <!-- ID nhân viên, không thay đổi -->

    <label for="name">Name: </label>
    <input type="text" id="name" name="name" value="${employee.name}" required><br><br>

    <label for="address">Address: </label>
    <input type="text" id="address" name="address" value="${employee.address}" required><br><br>

    <label for="phone">Phone: </label>
    <input type="text" id="phone" name="phone" value="${employee.phone}" required><br><br>

    <label for="status">Status: </label>
    <select id="status" name="status">
        <option value="true" ${employee.status ? 'selected' : ''}>Active</option>
        <option value="false" ${!employee.status ? 'selected' : ''}>Inactive</option>
    </select><br><br>

    <input type="submit" value="Cập nhật">
</form>
<div>
    <a href="/">Back to list</a>
</div>

</body>
</html>
