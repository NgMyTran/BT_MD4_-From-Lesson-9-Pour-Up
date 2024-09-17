<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/17/2024
  Time: 7:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Xóa Nhân viên</h1>
<p>Bạn có chắc chắn muốn xóa nhân viên <strong>${employee.name}</strong> không?</p>
<form action="/employee/delete" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="submit" value="Xóa">
</form>
<br>
<a href="/">Quay lại danh sách</a>
</body>
</html>
