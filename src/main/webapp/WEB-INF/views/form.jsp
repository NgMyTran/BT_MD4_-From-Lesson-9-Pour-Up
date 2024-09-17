<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/input" method="post">
    <label >Name</label>
    <input type="text" name="name"><br>
    <label >Age</label>
    <input type="number" name="age"><br>
    <label >Phone</label>
    <input type="text" name="phone"><br>
    <label >Email</label>
    <input type="email" name="email"><br>
    <label >Address</label>
    <input type="text" name="address"><br>
    <button type="submit">Gửi</button>
</form>
</body>
</html>
