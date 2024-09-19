<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/20/2024
  Time: 1:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Cập nhật thông tin tờ khai y tế</h2>
<form:form  action="/updated" modelAttribute="medical" method="post">
    <label>Họ tên:</label>
    <form:input path="fullName" />
    <form:errors path="fullName" cssClass="error" />
    <br />

    <label>Số CMND:</label>
    <form:input path="idCard" />
    <form:errors path="idCard" cssClass="error" />
    <br />

    <label>Ngày sinh:</label>
    <form:input path="birthDate" type="date" />
    <form:errors path="birthDate" cssClass="error" />
    <br />

    <label>Trạng thái sức khỏe:</label>
    <form:input path="healthStatus" />
    <br />

    <label>Lịch sử đi lại:</label>
    <form:input path="travelHistory" />
    <br />

    <input type="submit" value="Cập nhật" />
</form:form>
</body>
</html>
