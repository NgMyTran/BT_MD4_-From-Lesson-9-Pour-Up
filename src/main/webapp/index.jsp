<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%
    response.sendRedirect("/TodoServlet?action=GETALL");
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Tittle</title>
</head>
<body>

<%--<a href="/TodoServlet?action=GETALL">DEMO: TODOLIST</a>--%>
<%--Form upload --%>
<form action="/UploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file">
    <input type="file" name="files" id="files" multiple>
    <button type="submit">upload</button>
</form>


<%--Khai báo biến và khởi tạp g.trị--%>
<%!
    LocalDate today = LocalDate.now();
    String name="Huyen";
    byte age=23;
%>
<p>My name is: <%=name%>. I'm <%=age%> year old</p>
<%--Biểu thức java--%>
<h1><%="Tran"%></h1>


<%--c : out--%>
<h3><c:out value="c:out"></c:out></h3>
<%--c : set--%>
<c:set var="array" value="<%=new int[]{1,2,3,4,5,6}%>"/>
<%--c : forEach--%>
<c:forEach var="num" items="${array}" varStatus="loop">
    <li>Index: ${loop.index} . Element value = ${num}</li>
</c:forEach>


<c:set var="totalPage" value="5"/>
<c:forEach var="page" step="1" items="${array}" varStatus="loop">

</c:forEach>

</body>
</html>