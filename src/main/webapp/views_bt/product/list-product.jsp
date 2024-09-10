<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Products</title>
    <style>
        .crossed-out td{
            text-decoration: line-through;
            color: red; /* Optional: to make it more visible */
        }
         .hidden-column {
             display: none;
         }
    </style>
    <script>
        function toggleColumn() {
            var statusColumn = document.querySelectorAll('th:nth-child(5), td:nth-child(5)');
            statusColumn.forEach(function(cell) {
                cell.classList.toggle('hidden-column');
            });
        }
    </script>
</head>
<body>
<h1>Danh sách Products</h1>
<a href="/views_bt/product/add-product.jsp">+ Thêm mới Product</a>
<%--<table border="1" cellspacing="0" cellpadding="10">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>ID</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Price</th>--%>
<%--        <th>Stock</th>--%>
<%--        <th colspan="3">Action</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${products}" var="p">--%>
<%--        <tr class="${p.status ? '' : 'crossed-out'}">--%>
<%--            <td>${p.id}</td>--%>
<%--            <td>${p.name}</td>--%>
<%--            <td>${p.price}</td>--%>
<%--            <td>${p.stock}</td>--%>
<%--            <td><a href="/ProductServlet?action=DETAIL&id=${p.id}">DETAIL</a></td>--%>
<%--            <td><a href="/ProductServlet?action=EDIT&id=${p.id}">Edit</a></td>--%>
<%--            <td><a href="/ProductServlet?action=DELETE&id=${p.id}">Delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th class="hidden-column">Status</th> <!-- Cột Status bị ẩn -->
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td class="hidden-column">
                <c:choose>
                    <c:when test="${product.status}">
                        <span>Active</span>
                    </c:when>
                    <c:otherwise>
                        <span style="text-decoration: line-through; color: red;">Inactive</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
