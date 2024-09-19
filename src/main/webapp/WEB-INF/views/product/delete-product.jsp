<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 1:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa Sản Phẩm</title>
</head>
<body>

<h1>Xóa Sản Phẩm</h1>
<p>Bạn có chắc chắn muốn xóa sản phẩm <strong>${product.name}</strong> không?</p>
<form action="/product/delete" method="post">
    <input type="hidden" name="id" value="${product.id}">
    <input type="submit" value="Xóa" class="btn btn-danger">
</form>
<br>
<a href="/product/list">Quay lại danh sách sản phẩm</a>
</body>
</html>
