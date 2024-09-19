<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/upload" method="post" enctype="multipart/form-data" modelAttribute="uploadModel">

    <form:label path="single">Upload 1</form:label>
    <form:input path="single" type="file" id="single"/> <br>

    <form:label path="multiple">Upload n</form:label>
    <%--        <form:input path="multiple" type="file" mutiple="multiple"/> <br>--%>
    <input type="file" name="multiple" id="multiple" multiple/>

    <button type="submit">Gửi</button>
</form:form>
</body>
</html>
