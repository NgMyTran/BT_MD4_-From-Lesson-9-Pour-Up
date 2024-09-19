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
    <title>Xóa Giỏ Hàng</title>
</head>
<body>

<h1>Xóa Giỏ Hàng</h1>
<p>Bạn có chắc chắn muốn xóa giỏ hàng với ID <strong>${cart.id}</strong> không?</p>
<form action="/shopping-cart/delete" method="post">
    <input type="hidden" name="id" value="${cart.id}">
    <input type="submit" value="Xóa" class="btn btn-danger">
</form>
<br>
<a href="/shopping-cart/list">Quay lại danh sách giỏ hàng</a>
</body>
</html>
