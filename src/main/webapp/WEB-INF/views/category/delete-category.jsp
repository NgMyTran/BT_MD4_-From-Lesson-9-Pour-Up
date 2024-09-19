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
    <title>Xóa Danh Mục</title>
</head>
<body>

<h1>Xóa Danh Mục</h1>
<p>Bạn có chắc chắn muốn xóa danh mục <strong>${category.name}</strong> không?</p>
<form action="/category/delete" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <input type="submit" value="Xóa" class="btn btn-danger">
</form>
<br>
<a href="/category/list">Quay lại danh sách danh mục</a>
</body>
</html>
