<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa Người Dùng</title>
</head>
<body>

<h1>Xóa Người Dùng</h1>
<p>Bạn có chắc chắn muốn xóa người dùng <strong>${user.fullName}</strong> không?</p>
<form action="/user/delete" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <input type="submit" value="Xóa" class="btn btn-danger">
</form>
<br>
<a href="/user/list">Quay lại danh sách người dùng</a>
</body>
</html>
