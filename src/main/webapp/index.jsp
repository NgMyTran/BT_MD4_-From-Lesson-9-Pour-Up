<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%--  <title>BT1: Currency Converter</title>--%>

  <title>BT3: Sign In</title>
  <style>
    .login-container {
      width: 300px;
      margin: 0 auto;
      padding-top: 100px;
    }
    input[type="text"], input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: blue;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    input[type="submit"]:hover {
      background-color: darkblue;
    }
  </style>
</head>
<body>
<%--<a href="/TodoServlet?action=GETALL">DEMO: TODOLIST</a>--%>

<%--<h2>TH: Currency Converter</h2>--%>
<%--<form method="post" action="converter.jsp">--%>
<%--  <label> Rate: </label><br/>--%>
<%--  <input type="text" name="rate" placeholder="RATE" value="2200"/><br/>--%>
<%--  <label> USD: </label><br/>--%>
<%--  <input type="text" name="usd" placeholder="USD" value="0"/><br/>--%>
<%--<input type="submit" id="submit" value="Converter"/><br/>--%>


<%--<h2>BT1</h2>--%>
<%--<form method="post" action="calculateDiscount.jsp">--%>
<%--  <label> Name: </label><br/>--%>
<%--  <input type="text" name="name" placeholder="Product Name" /><br/>--%>

<%--  <label> Description: </label><br/>--%>
<%--  <input type="text" name="description" placeholder="Product Description"/><br/>--%>

<%--  <label> Price: </label><br/>--%>
<%--  <input type="text" name="price" placeholder="Product Price" /><br/>--%>

<%--  <label> Discount Percentage: </label><br/>--%>
<%--  <input type="text" name="discount" placeholder="Discount Percentage" /><br/>--%>

<%--  <input type="submit" id="submit" value="Calculate Discount"/><br/>--%>
<%--</form>--%>


<%--<a href="/UserDataServlet">BT2: User Data</a>--%>


<div class="login-container">
  <h2>SIGN IN</h2>
  <form action="LoginServlet" method="post">
    <input type="text" name="username" placeholder="username" required>
    <input type="password" name="password" placeholder="password" required>
    <input type="submit" value="SIGN IN">
  </form>
</div>
</body>
</html>