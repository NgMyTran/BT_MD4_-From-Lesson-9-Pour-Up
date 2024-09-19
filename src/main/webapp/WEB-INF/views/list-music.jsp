<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Bài Hát</title>
</head>
<body>

<h1>Danh Sách Bài Hát</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên Bài Hát</th>
        <th>Ca Sĩ</th>
        <th>Thể Loại</th>
        <th>File</th>
    </tr>
    <c:forEach items="${songs}" var="song">
        <tr>
            <td>${song.id}</td>
            <td>${song.songName}</td>
            <td>${song.singer}</td>
            <td>${song.genre}</td>
            <td>
                <audio controls>
                    <source src="${song.source}" type="audio/mpeg">
                    Your browser does not support the audio element.
                </audio>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/up-music">Upload Bài Hát Mới</a>

</body>
</html>
