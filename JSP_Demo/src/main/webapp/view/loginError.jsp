<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dang nhap</title>
<link rel="stylesheet" href="view/mystyle.css">
</head>
<body>
	<div id="header">
		<h2>LIBRARY</h2>
	</div>
	<div class="container">
	<div class="login-form">
	<form action="<%=request.getContextPath() %>/UserListController" method="post">
                    <h1>ĐĂNG NHẬP</h1>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" placeholder="Nhập username" name="username">
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="password" placeholder="Nhập mật khẩu" name="password">
                    </div>
                    <div class="btn-box">
                        <button type="submit" value="login" name="action">
                            Đăng nhập
                        </button>
                        <button type="submit" value="register" name="action">
                            Đăng ký
                        </button>
                    </div>
                </form>
	</div>
	</div>
	<h1 style="text-align:center; font-size:40px">Đăng nhập thất bại</h1>
</body>
</html>