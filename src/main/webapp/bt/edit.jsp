<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin học sinh</title>
</head>
<body>
<h1>Chỉnh sửa thông tin học sinh</h1>
<form action="/StudentServlet" method="post">
    <div>
        <label for="id">ID</label>
        <input type="text" name="id" id="id" value="${student.id}" readonly>
    </div>
    <div>
        <label for="fullName">Họ tên</label>
        <input type="text" name="fullName" id="fullName" value="${student.fullName}">
    </div>
    <div>
        <label for="email">Email</label>
        <input type="email" name="email" id="email" value="${student.email}">
    </div>
    <div>
        <label for="address">Địa chỉ</label>
        <input type="text" name="address" id="address" value="${student.address}">
    </div>
    <div>
        <label for="phone">Số điện thoại</label>
        <input type="text" name="phone" id="phone" value="${student.phone}">
    </div>
    <div>
        <label for="status">Trạng thái</label>
        <input type="checkbox" name="status" id="status" value="true" ${student.status ? 'checked' : ''}>
        <label for="status">Trạng thái</label>
    </div>
    <input type="submit" name="action" value="UPDATE">
</form>
</body>
</html>
