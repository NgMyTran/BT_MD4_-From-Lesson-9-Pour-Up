
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME </title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<a href=""></a>
<h1>HELLO SPRING HOME</h1>
<%--<a href="/customers">Danh sách Cusstomer</a>--%>
<%--</div>--%>
<%--<div><a href="/views/account/login.jsp">Đăng nhập TK ngân hàng</a></div>--%>

<a href="/input">Nhập thông tin cá nhân</a>
<div>
    <a href="/input-bt1">BT1</a>
</div>
<div>
    <a href="/library">BT2</a>
</div>
<div>
    <a href="/employee">BT3 EMPLOYEE</a>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
    </tr>
    <tbody>
    <c:forEach items="${list}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.name}</td>
            <td><img src="${pro.imgURL}" alt="${pro.name}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
