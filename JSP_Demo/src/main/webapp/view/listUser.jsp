<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<div id="leftcol">
		<ul class="navbar">
			<li><a href="UserListController?action=ViewInfoAdmin&&UserID=${UserID }">Thông tin cá nhân</a></li>
			<li><a href="BookController?action=GetAllAdmin&&UserID=${UserID }">Tất cả sách</a></li>
			<li><a href="UserListController?action=AllUser&&UserID=${UserID }">Danh sách user</a></li>
			<li><a href="UserListController?action=registerAdmin&&UserID=${UserID }">Thêm thủ thư</a>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
	<table>
		<thread>
			<th>User ID</th>
			<th>Họ và tên</th>
			<th>Ngày sinh</th>
			<th>Địa chỉ</th>
			<th>Tên đăng nhập</th>
			<th>Mật khẩu</th>
			<th></th>
		</thread>
		<tbody>
			<c:forEach items="${listUs }" var="User">
				<tr>
					<td>${User.userID }</td>
					<td>${User.name }</td>
					<td>${User.address }</td>
					<td>${User.dOB }</td>
					<td>${User.userName }</td>
					<td>${User.passWord }</td>
					<td><a href="UserListController?action=ListBorrow&&UserID=${User.userID }&&AdminID=${UserID }">Sách đã mượn</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>