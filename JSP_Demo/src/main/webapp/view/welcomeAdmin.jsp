<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Admin</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<div id="leftcol">
		<ul class="navbar">
			<li><a href="UserListController?action=ViewInfoAdmin&&UserID=${user.userID }">Thông tin cá nhân</a></li>
			<li><a href="BookController?action=GetAllAdmin&&UserID=${user.userID }">Tất cả sách</a></li>
			<li><a href="UserListController?action=AllUser&&UserID=${user.userID }">Danh sách user</a></li>
			<li><a href="UserListController?action=registerAdmin&&UserID=${user.userID }">Thêm thủ thư</a>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
	<div id="content">
		<c items="${user }" var="user">
			<h1>Xin chào Admin ${user.name }</h1>
		</c>
	</div>
</body>
</html>