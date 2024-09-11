<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách USER</title>
</head>
<body>
<h1>Danh sách USER</h1>

<a href="UserServlet?action=create">+ Thêm mới USER</a>
<form action="users" method="get">
    <input type="text" name="searchCountry" value="${searchCountry}" placeholder="Tìm theo quốc gia">
    <input type="submit" value="Tìm kiếm">
</form>

<a href="users?sortOrder=nameAsc">Sắp xếp theo tên (A-Z)</a>
<a href="users?sortOrder=nameDesc">Sắp xếp theo tên (Z-A)</a>

<table border="1" cellspacing="0" cellpadding="5">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUser}" var="user" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${user.name}</td>
            <td><a href="UserServlet?action=edit&id=${user.id}">Edit</a></td>
            <td><a href="UserServlet?action=delete&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
