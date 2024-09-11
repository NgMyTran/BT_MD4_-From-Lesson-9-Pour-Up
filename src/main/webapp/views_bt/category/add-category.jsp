
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Them moi Category</h1>
<form action="/CategoryServlet" method="post">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="status">Status</label>
        <input type="checkbox" name="status" id="status" checked>
    </div>
    <input type="submit" name="action" value="ADD">
</form>
</body>
</html>
