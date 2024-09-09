<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>List</title>
</head>
<body>
<h1>Danh sách công việc</h1>
<h2><a href="/pages/add.jsp">Thêm Công Việc mới</a></h2>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Content</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="todo" items="${todos}" varStatus="loop">
    <tr>
        <td>${loop.count}</td>
        <td>${todo.content}</td>
        <td>${todo.status?"Xong":"Chưa xong"}</td>
        <td><a href="/TodoServlet?action=EDIT&id=${todo.id}">Edit</a></td>
        <td><a onclick="return confirm('Do you want to delete?')" href="/TodoServlet?action=DELETE&id=${todo.id}">Delete</a></td>
    </tr>
</c:forEach>
    </tbody>
    </table>

<h1><a href="/CustomerServlet?action=getCustomer">BT 1</a></h1>
<h1><a href="/bt/bt2.jsp">BT 2</a></h1>
<h1><a href="/ProductServlet?action=getProducts">BT 3</a></h1>
</body>
</html>
