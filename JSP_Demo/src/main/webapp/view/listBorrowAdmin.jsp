<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Borrow User</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<div id="leftcol">
		<ul class="navbar">
			<li><a href="UserListController?action=ViewInfoAdmin&&UserID=${AdminID }">Thông tin cá nhân</a></li>
			<li><a href="BookController?action=GetAllAdmin&&UserID=${AdminID }">Tất cả sách</a></li>
			<li><a href="UserListController?action=AllUser&&UserID=${AdminID }">Danh sách user</a></li>
			<li><a href="UserListController?action=registerAdmin&&UserID=${AdminID }">Thêm thủ thư</a>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
	<table>
		<thread>
			<th>ID Sách</th>
			<th>Tên sách</th>
			<th>Ngày mượn</th>
			<th>Ngày trả</th>
			<th>Thủ thư nhận sách</th>
			<th></th>
		</thread>
		<tbody>
			<c:forEach items="${listBorrow }" var="listBorrow">
				<tr>
					<td>${listBorrow.bookID }</td>
					<td>${listBorrow.bookName }</td>
					<td>${listBorrow.borrowDate }</td>
					<td>${listBorrow.returnDate }</td>
					<td>${listBorrow.adminName }</td>
					<td><a href="BorrowController?action=returnBook&&AdminID=${AdminID }&&BorrowID=${listBorrow.borrowID}&&UserID=${listBorrow.borrowerID}&&BookID=${listBorrow.bookID}">Trả sách</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>