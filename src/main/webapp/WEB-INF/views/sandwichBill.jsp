<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/18/2024
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Condiments Bill</h1>
  <ul>
    <c:forEach items="${selectedCondiments}" var="cond" >
      <ol>
        <li>${cond}</li>
      </ol>
    </c:forEach>
  </ul>
  <a href="/sandwich">Select Again</a>
  </body>
</html>
