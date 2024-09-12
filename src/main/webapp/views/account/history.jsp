<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/12/2024
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>id_account</td>
        <td>FullName</td>
        <td>Balance</td>
        <td>Date</td>//created_time
    </tr>
    </thead>
    <tbody>
    <c:forEach items="histories" var="acc" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${acc.username}</td>
            <td>${acc.balance}</td>
            <td>${acc.created_time}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
