<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/10/2024
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .inactive {
            background-color: #f8d7da; /* Màu đỏ nhạt cho hàng không hoạt động */
            color: #721c24; /* Màu chữ đỏ tối để làm nổi bật hơn trên nền đỏ nhạt */
        }
    </style>
</head>
<body>
<h1>Danh sách Categories</h1>
<a href="/views_bt/category/add-category.jsp">+ Them moi Category</a>
<table border="10" cellspacing="0" cellpadding="15">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach
            items="${categories}"
            var="c"
            varStatus="loop"
    >
        <tr class="${c.status ? '' : 'inactive'}">
            <td>${loop.count}</td>
            <td>${c.name}</td>
            <td>${c.status ? 'Active' : 'Inactive'}</td>
            <td><a href="/CategoryServlet?action=EDIT&id=${c.id}">Edit</a></td>
            <td><a href="/CategoryServlet?action=DELETE&id=${c.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
