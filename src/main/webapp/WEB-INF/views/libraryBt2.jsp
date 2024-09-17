<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/16/2024
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="/search" method="post">
    <label>Search: </label>
    <input type="text" name="word"/>
    <button type="submit">SEARCH</button>
</form>
<p>Translation: ${translation}</p>
</body>
</html>
