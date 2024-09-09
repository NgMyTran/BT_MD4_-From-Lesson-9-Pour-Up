<%@ page import="ra.jsp.Todo" %><%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/9/2024
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Sửa Công Việc </h1>
<% Todo todoEdit= (Todo) request.getAttribute("todoEdit");%>

<form action='/TodoServlet?action=UPDATE' method='post'>
<%--    <input type='hidden' name='id' value='<%=todoEdit.getId()%>'>--%>
    <label for='content'>Nội dung công việc:</label>
    <input type='text' name='id' value=' <%=todoEdit.getId()%>' readOnly>
    <input type='text' name='content' value='<%=todoEdit.getContent()%>'id='content'>
    <input type='radio'<%= todoEdit.isStatus()?"checked":""%> value='true' name='status'> Xong
    <input type='radio'<%= !todoEdit.isStatus()?"checked":""%> value='true' name='status'> Chưa Xong
    <input type='submit' name='action' value='UPDATE'>
    </form>
</body>
</html>
