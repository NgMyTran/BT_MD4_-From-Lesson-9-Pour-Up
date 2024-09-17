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
<h1>PRODUCT</h1>

<form action="/product/form" method="post">
    <input type="text" placeholder="input product's name" name="name">

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" required/>
    <br/>

    <input type="submit"  value="ADD">
</form>
</body>
</html>
