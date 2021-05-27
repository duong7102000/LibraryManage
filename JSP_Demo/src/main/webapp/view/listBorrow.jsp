<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Borrow</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<div id="leftcol">
		<ul class="navbar">
			<li><a href="UserListController?action=ViewInfo&&UserID=${UserID}">Thông tin cá nhân</a></li>
			<li><a href="BookController?action=GetAll&&UserID=${UserID}">Tất cả sách</a></li>
			<li><a href="UserListController?action=BookBorrowed&&UserID=${UserID}">Sách đã mượn</a></li>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
	<table>
		<thead>
			<th>Ngày mượn sách</th>
			<th>Ngày trả sách</th>
			<th>Tên sách</th>
		</thead>
		<tbody>
			<c:forEach items="${listBorrow }" var="Borrow">
				<tr>
					<td>${Borrow.borrowDate }</td>
					<td>${Borrow.returnDate }</td>
					<td>${Borrow.bookName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>