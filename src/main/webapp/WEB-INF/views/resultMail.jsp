<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/19/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Kết quả Cài đặt</h2>
<ul>
    <li>Ngôn ngữ ${config.language}</li>
    <li>Số lượng email trên mỗi trang ${config.pageSize}</li>
    <li>Bộ lọc spam ${config.spamFilter ? 'Bật' : 'Tắt'}</li>
    <li>Chữ ký ${config.signature}</li>
</ul>
</body>
</html>
