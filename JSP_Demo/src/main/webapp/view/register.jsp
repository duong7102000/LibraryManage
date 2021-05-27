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
		<div class="container">
                <div class="register-form">
                    <form action="<%=request.getContextPath() %>/UserListController" method="post">
                        <h1>Đăng ký tài khoản mới</h1>
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
                            <button type="submit" value="Register" name="action">
                                Đăng ký
                            </button>
                            <button type="submit" value="Đăng nhập" name="action">
                                Đăng nhập
                            </button>
                        </div>
                    </form>
                </div>
            </div>
</body>
</html>