<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Book</title>
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
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Genre</th>
			<th>Information</th>
			<th>Author</th>
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
					<td><a href="BorrowController?action=borrowByID&&BookID=${Book.bookID }&&UserID=${UserID}">Mượn sách</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>