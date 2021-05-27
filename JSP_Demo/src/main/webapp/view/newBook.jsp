<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Book</title>
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
	<form action="<%=request.getContextPath() %>/BookController" method="post">
		<input type="hidden" name="UserID" value="${UserID }">
		<table>
			<tr>
				<td>Tên sách</td>
				<td><input type="text" name="bookName"/></td>
			</tr>
			<tr>
				<td>Thể loại</td>
				<td><input type="text" name="genre"/></td>
			</tr>
			<tr>
				<td>Tác giả</td>
				<td><input type="text" name="author"/></td>
			</tr>
			<tr>
				<td>Tổng số lượng</td>
				<td><input type="text" name="totalQuantity"/></td>
			</tr>
			<tr>
				<td>Số lượng đã mượn</td>
				<td><input type="text" name="borrowedQuantity"/></td>
			</tr>
			<tr>
				<td>Số lượng còn lại</td>
				<td><input type="text" name="remainingAmount"/></td>
			</tr>
			<tr>
				<td>Thông tin về sách</td>
				<td><input type="text" name="information"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create" name="action"></td>
			</tr>
		</table>
	</form>
</body>
</html>