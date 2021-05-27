<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dang Ky</title>
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
			<li><a hrel="UserListController?action=registerAdmin&&UserID=${UserID }">Thêm thủ thư</a>
			<li><a href="UserListController?action=LogOut">Đăng xuất</a></li>
		</ul>
	</div>
		<div class="container">
                <div class="register-form">
                    <form action="<%=request.getContextPath() %>/UserListController" method="post">
                        <h1>Đăng ký tài khoản mới</h1>
                        <input type="hidden" name="UserID" value="${UserID }">
                        <div class="input-box">

                            <input type="text" placeholder="Nhập họ và tên" name="name">
                        </div>
                        <div class="input-box">

                            <input type="text" placeholder="Nhập ngày sinh" name="dOB">
                        </div>
                        <div class="input-box">
                            
                               <input type="text" placeholder="Nhập địa chỉ" name="address">
                            
                            
                        </div>
                        <div class="input-box">
                            <input type="text" placeholder="Nhập tên đăng nhập" name="userName">
                        </div>
                        <div class="input-box">
                            <input type="text" placeholder="Nhập mật khẩu" name="passWord">
                        </div>
                        
                        <div class="btn-box">
                            <button type="submit" value=" Register " name="action">
                                Đăng ký
                            </button>
                        </div>
                    </form>
                </div>
            </div>
</body>
</html>