<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Currency</title>
</head>
<body>
<form action="/input-bt1" method="post">
    <label >VNĐ:</label>
    <input type="text" name="amount" placeholder="Enter amount" required />
    <br />
    <label>Rate:</label>
    <input type="text" name="rate" placeholder="Enter rate" required />
    <br />
    <button type="submit">CONVERT</button>
</form>
</body>
</html>
