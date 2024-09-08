<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculation</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    double discountAmount = 0.0;
    double discountPrice = 0.0;
    float price = 0.0f;
    float percent = 0.0f;

    String priceParam = request.getParameter("price");
    if (priceParam != null && !priceParam.trim().isEmpty()) {
        price = Float.parseFloat(priceParam);
    }

    String percentParam = request.getParameter("discount");
    if (percentParam != null && !percentParam.trim().isEmpty()) {
        percentParam = percentParam.replace("%", "").trim();
        percent = Float.parseFloat(percentParam);
    }

    discountAmount= price*percent*0.01;
    discountPrice= price-discountAmount;
%>
<h1>Kết quả</h1>
<h3>Name: <%= name %></h3>
<h3>Description: <%= description %></h3>
<h3>Price: <%= price %></h3>
<h3>Discount Amount (USD): <%= discountAmount %></h3>
<h3>Discounted Price (USD): <%= discountPrice %></h3>
</body>
</html>