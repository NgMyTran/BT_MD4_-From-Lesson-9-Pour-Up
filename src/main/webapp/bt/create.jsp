<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới học sinh</title>
</head>
<body>
<h1>Thêm mới học sinh</h1>
<form action="/StudentServlet" method="post">
    <div>
        <label for="fullName">Họ tên</label>
        <input type="text" name="fullName" id="fullName">
    </div>
    <div>
        <label for="email">Email</label>
        <input type="email" name="email" id="email">
    </div>
    <div>
        <label for="address">Địa chỉ</label>
        <input type="text" name="address" id="address">
    </div>
    <div>
        <label for="phone">Số điện thoại</label>
        <input type="text" name="phone" id="phone">
    </div>
    <div>
        <label for="status">Trạng thái</label>
        <input type="checkbox" name="status" id="status" value="true">
        <label for="status">Đang học</label>
    </div>
    <input type="submit" name="action" value="ADD">
</form>
</body>
</html>
