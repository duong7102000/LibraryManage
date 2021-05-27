<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Infor User</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<div id="leftcol">
		<ul class="navbar">
			<li><a href="UserListController?action=ViewInfo&&UserID=${us.userID }">Thông tin cá nhân</a></li>
			<li><a href="BookController?action=GetAll&&UserID=${us.userID }">Tất cả sách</a></li>
			<li><a href="UserListController?action=BookBorrowed&&UserID=${us.userID }">Sách đã mượn</a></li>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
	<form action="<%=request.getContextPath() %>/UserListController" method="post">
		<input type="hidden" name="UserID" value="${us.userID }">
		<table>
			<tr>
				<td>Họ và tên</td>
				<td>${us.name }</td>
			</tr>
			<tr>
				<td>Ngày sinh</td>
				<td>${us.dOB }</td>
			</tr>
			<tr>
				<td>Địa chỉ</td>
				<td>${us.address }</td>
			</tr>
			<tr>
				<td>Username</td>
				<td>${us.userName }</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="passWord" value="${us.passWord }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Đổi mật khẩu" name="action"></td>
			</tr>
		</table>
	</form>
</body>
</html>