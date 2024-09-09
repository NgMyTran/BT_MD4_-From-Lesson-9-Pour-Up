<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/9/2024
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BT1</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<div className="container mx-auto p-4">
    <h1 className="text-2xl font-bold text-center mb-4">Danh sách khách hàng</h1>
    <table className="min-w-full bg-white border border-zinc-300">
        <thead>
        <tr className="bg-zinc-200">
            <th className="py-2 px-4 border-b">Tên</th>
            <th className="py-2 px-4 border-b">Ngày sinh</th>
            <th className="py-2 px-4 border-b">Địa chỉ</th>
            <th className="py-2 px-4 border-b">Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="cus">
            <tr className="hover:bg-zinc-100">
                <td className="py-2 px-4 border-b">${cus.name}</td>
                <td className="py-2 px-4 border-b">${cus.birthDay}</td>
                <td className="py-2 px-4 border-b">${cus.address}</td>
                <td className="py-2 px-4 border-b">
                    <img alt="${cus.name}" src="${cus.imageUrl}" style="max-width: 100px; max-height: 100px;" />
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
