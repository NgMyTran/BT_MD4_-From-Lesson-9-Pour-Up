<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tittle</title>
</head>
<body>
<%--<%--%>
<%--float rate= Float.parseFloat(request.getParameter("rate"));--%>
<%--    float usd= Float.parseFloat(request.getParameter("usd"));--%>
<%--    float vnd= rate*usd;--%>
<%--%>--%>
<%--<h1>Rate: <%=rate%></h1>--%>
<%--<h1>USD: <%=usd%></h1>--%>
<%--<h1>VND: <%=vnd%></h1>--%>


<%
    float rate= Float.parseFloat(request.getParameter("rate"));
    float usd= Float.parseFloat(request.getParameter("usd"));
    float vnd= rate*usd;
%>
<h1>Rate: <%=rate%></h1>
<h1>USD: <%=usd%></h1>
<h1>VND: <%=vnd%></h1>
</body>
head
</html>