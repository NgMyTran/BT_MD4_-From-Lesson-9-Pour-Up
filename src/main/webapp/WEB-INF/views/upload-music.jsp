<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/uploaded-music" modelAttribute="song" enctype="multipart/form-data">
    <form:label path="songName">Tên Bài Hát:</form:label>
    <form:input path="songName" /><br/>

    <form:label path="singer">Ca Sĩ:</form:label>
    <form:input path="singer" /><br/>

    <form:label path="genre">Thể Loại (nhập cách nhau bằng dấu phẩy):</form:label>
    <form:input path="genre" /><br/>

    <label>Chọn File:</label>
<%--    <input type="file" name="file" accept=".mp3,.wav,.ogg,.m4p" required/><br/>--%>
    <audio src="" name="file"></audio>
    <input type="submit" value="Upload"/>
</form:form>

</body>
</html>
