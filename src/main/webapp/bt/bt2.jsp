<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/9/2024
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BT 2</title>
</head>
<body>
<div className="p-4 bg-card rounded-lg shadow-md">
    <h1 className="text-2xl font-bold text-foreground mb-4">Simple Calculator</h1>
    <form className="space-y-4" method="post" action="/CalculateServlet">
        <div>
            <label className="block text-muted-foreground" htmlFor="firstOperand">
                First operand:
            </label>
            <input type="number" name="firstOperand" id="firstOperand" className="border border-border rounded p-2 w-full" placeholder="Enter first operand" value="231" />
        </div>
        <div>
            <label className="block text-muted-foreground" htmlFor="operator">
                Operator:
            </label>
            <select id="operator" name="operator" className="border border-border rounded p-2 w-full">
                <option value="addition">Addition</option>
                <option value="subtraction">Subtraction</option>
                <option value="multiplication">Multiplication</option>
                <option value="division">Division</option>
            </select>
        </div>
        <div>
            <label className="block text-muted-foreground" htmlFor="secondOperand">
                Second operand:
            </label>
            <input type="number" name="secondOperand" id="secondOperand" className="border border-border rounded p-2 w-full" placeholder="Enter second operand" value="234" />
        </div>
        <input type="submit" id="submit" value="Calculate" >
    </form>
</div>
</body>
</html>
