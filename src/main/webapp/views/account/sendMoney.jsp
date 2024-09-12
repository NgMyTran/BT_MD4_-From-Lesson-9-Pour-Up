<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 9/12/2024
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/AccountServlet" method="post">
    Tai khoản ngươi nhận
    <input type="number" name="idReceiver" />
    so tien
    <input type="number" name="amount" />
    <input type="submit" value="SEND" name="action">
</form>
<c:if test="${error!=null}">
    <p class="text-success">${error}</p>
</c:if>
</body>
</html>