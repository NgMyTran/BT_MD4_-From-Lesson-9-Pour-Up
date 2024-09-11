<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<a href="/th_bt/create-user.jsp">+ Them moi khach hang</a>
<table border="10" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach
            items="${listUser}"
            var="cus"
            varStatus="loop"
    >
        <tr>
            <td>${loop.count}</td>
            <td>${cus.name}</td>
            <td><a href="/UserServlet?action=edut&id=${cus.id}">Edit</a></td>
            <td><a href="/UserServlet?action=delete&id=${cus.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>