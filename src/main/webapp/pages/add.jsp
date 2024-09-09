<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/9/2024
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h1>Thêm Công Việc Mới</h1>

<form action='/TodoServlet?action=ADD' method='post'>
    <input type='hidden' name='action' value='ADD'>
    <label for='content'>Nội dung công việc:</label>
    <input type='text' name='content' id='content' required>
    <input type='submit' value='Thêm'>
    </form>
</body>
</html>
