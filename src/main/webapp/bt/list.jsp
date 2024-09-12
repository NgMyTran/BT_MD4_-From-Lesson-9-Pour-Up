<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<a href="/bt/create.jsp">+ Thêm học sinhh</a>

<form action="/StudentServlet" method="get">
    <input type="hidden" name="action" value="SEARCH">
    <div>
        <label for="name">Tìm kiếm theo tên:</label>
        <input type="text" name="name" id="name">
    </div>
    <button type="submit">Tìm</button>
</form>

<table border="10" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach
            items="${studentsSer}"
            var="student"
            varStatus="loop"
    >
        <tr>
            <td>${loop.count}</td>
            <td>${student.fullName}</td>
            <td>${student.email}</td>
            <td>${student.address}</td>
            <td>${student.phone}</td>
            <c:choose>
                <c:when test="${student.status}">
                    <td>Học</td>
                </c:when>
                <c:otherwise>
                    <td>Nghỉ học</td>
                </c:otherwise>
            </c:choose>
            <td><a href="/StudentServlet?action=EDIT&id=${student.id}">Edit</a></td>
            <td><a href="/StudentServlet?action=DELETE&id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>