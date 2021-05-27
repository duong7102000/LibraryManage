<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Error</title>
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
	<h1>Không thể xóa sách do có bạn đọc đang mượn</h1>
	<table>
		<thead>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Genre</th>
			<th>Information</th>
			<th>Author</th>
			<th>Total Quantity</th>
			<th>Borrowed Quantity</th>
			<th>Remaining Amount</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${lisBook }" var="Book">
				<tr>
					<td>${Book.bookID }</td>
					<td>${Book.name }</td>
					<td>${Book.genre }</td>
					<td>${Book.information }</td>
					<td>${Book.author }</td>
					<td>${Book.totalQuantity }</td>
					<td>${Book.borrowedQuantity }</td>
					<td>${Book.remainingAmount }</td>
					<td><a href="BookController?action=getBookById&&BookID=${Book.bookID }&&UserID=${UserID}">Cập nhật</a></td>
					<td><a href="BookController?action=Delete&&BookID=${Book.bookID }&&UserID=${UserID}">Xóa sách</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<a href="BookController?action=newBook&&UserID=${UserID }">Thêm sách mới</a>
	</table>
</body>
</html>