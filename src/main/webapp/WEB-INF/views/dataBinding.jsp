<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Trang demo lý thuyết</h1>
<h2><a href="/upload">Uploadfile</a></h2>
<form:form action="/doAdd" method="post" modelAttribute="person">
    <form:label path="id">Id</form:label>
    <form:input path="id" /> <br/>

    <form:label path="name">Name</form:label>
    <form:input path="name" /> <br/>

    <form:label path="age">Name</form:label>
    <form:input type="number" path="age" /> <br/>

    <form:checkbox path="checkbox" value="banana" /> Chuối <br/>  <br/>
    <form:checkboxes path="checkboxes" items="${listcheck}"/><br/>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
