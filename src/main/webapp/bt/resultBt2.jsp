<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/9/2024
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result calculate</title>
</head>
<body>
<h1 className="text-2xl font-bold text-foreground mb-4">Result</h1>
<c:choose>
    <c:when test="${not empty error}">
        <p style="color: red">Error: ${error}</p>
    </c:when>
    <c:otherwise>
        <p>The result of ${operation} is: ${result}</p>
    </c:otherwise>
</c:choose>
</body>
</html>
