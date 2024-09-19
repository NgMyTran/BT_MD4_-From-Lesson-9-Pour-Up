<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1 ảnh</h1>
<img src="${one}" width="100" height="100">

<h2>nhiều ảnh</h2>
<c:forEach items="${many}" var="url">
    <img src="${url}" width="100" height="100">
</c:forEach>

</body>
</html>
