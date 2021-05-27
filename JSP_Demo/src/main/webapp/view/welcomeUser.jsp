<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<c items="${user }" var="user">
	<div id="leftcol">
		<ul class="navbar">
			<li><a href="UserListController?action=ViewInfo&&UserID=${user.userID }">Thông tin cá nhân</a></li>
			<li><a href="BookController?action=GetAll&&UserID=${user.userID }">Tất cả sách</a></li>
			<li><a href="UserListController?action=BookBorrowed&&UserID=${user.userID }">Sách đã mượn</a></li>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
	<div id="content">
		
			<h1>Xin chào bạn đọc ${user.name }</h1>
		
	</div>
	</c>
</body>
</html>