<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/18/2024
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculate/save" method="post">

    <label for="num1">Number 1:</label>
    <input type="number" name="num1" id="num1" step="any"><br/>
    <label for="num2">Number 2:</label>
    <input type="number" name="num2" id="num2" step="any"><br/>
    <label>Operation:</label><br/>
    <input type="radio" name="operator" value="add"> Addition(+)<br/>
    <input type="radio" name="operator" value="subtract"> Subtract(-)<br/>
    <input type="radio" name="operator" value="multiply"> Multiply(*)<br/>
    <input type="radio" name="operator" value="divide"> Divide /)<br/>

    <button type="submit">Calculate</button>
</form>
</body>
</html>
