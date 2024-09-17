<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>Amount: ${amount}</li>
    <li>Rate: ${rate}</li>
    <li>USD: ${rate != 0 ? amount / rate : 'Invalid Rate'}</li>
</ul>
</body>
</html>
