<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Error</title>
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
	<h1>Không thể thêm sách do sách đã có trong DataBase</h1>
</body>
</html>