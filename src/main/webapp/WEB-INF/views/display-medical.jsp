<%--
  Created by IntelliJ IDEA.
  User: TRAN
  Date: 9/20/2024
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông tin tờ khai y tế</h2>
<p>Họ tên: ${medical.fullName}</p>
<p>Số CMND: ${medical.idCard}</p>
<p>Ngày sinh: ${medical.birthDate}</p>
<p>Trạng thái sức khỏe: ${medical.healthStatus}</p>
<p>Lịch sử đi lại: ${medical.travelHistory}</p>

<a href="/update">Cập nhật thông tin</a>
<a href="/add">Thêm thông tin mới</a>
</body>
</html>
