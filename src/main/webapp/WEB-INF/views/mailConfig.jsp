<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* General form styling */
        form {
            margin: 20px;
        }
        label {
            margin-right: 10px;
        }
        input, select {
            margin-bottom: 10px;
            border: 1px solid #ccc; /* Default border for all input fields */
            padding: 8px;
        }
        input[type="text"] {
            border: 2px solid #4CAF50; /* Green border for text inputs */
        }
    </style>
</head>
<body>
<form:form action="/createMail" modelAttribute="mailConfig" method="post">
    <form:label path="language">Ngôn ngữ:</form:label>
    <form:select path="language">
        <form:option value="">
            <c:forEach items="${languages}" var="lang">
                <form:option value="${lang}">${lang}</form:option>
            </c:forEach>
        </form:option>
    </form:select> <br/>


    <form:label path="pageSize">Số lượng email trên mỗi trang: </form:label>
    <form:select path="pageSize">
        <c:forEach items="${pageSizes}" var="page">
<%--            <form:option value="${size}">${size}</form:option>--%>
            <form:option value="${page}">${page}</form:option>
        </c:forEach>
    </form:select> <br/>

    <form:label path="spamFilter">Bộ lọc spam:</form:label>
    <form:checkbox path="spamFilter" /> Bật <br/>

    <form:label path="signature">Chữ ký:</form:label>
    <form:input path="signature" /> <br/>

<%--    <p style="border: 1px solid black; padding: 10px; margin: 10px;">--%>
<%--        &lt;p&gt;.--%>
<%--    </p>--%>

    <input type="submit" value="Lưu Cài Đặt" />
</form:form>
</body>
</html>
