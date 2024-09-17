
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/10/2024
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Them moi khach hang</h1>
<%--<form action="/CustomerServlet" method="post">--%>
<form action="/customers/add">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="address">Address</label>
        <input type="text" name="address" id="address">
    </div>
    <div>
        <label for="email">Email</label>
        <input type="email" name="email" id="email">
    </div>
<%--    <input type="submit" name="action" value="ADD">--%>
    <input type="submit" value="ADD">
</form>
</body>
</html>