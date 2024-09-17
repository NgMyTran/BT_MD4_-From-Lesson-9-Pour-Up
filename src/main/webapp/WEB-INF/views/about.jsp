<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello </title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>ABOUT</h1>
<table>
    <tr>
        <th>Name</th>
        <th>price</th>
    </tr>
    <tbody>
    <c:forEach items="${name},${price}" var="pro">
        <tr>
            <td>${pro.name}</td>
    <td>${pro.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

