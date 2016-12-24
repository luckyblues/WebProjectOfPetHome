<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
	font-size: 14px;
}

body {
	width: 1288px;
	height: 800px;
}

.login-box {
	width: 350px;
	height: 300px;
	position: absolute;
	top: 20%;
	background: #ddd;
	left: 35%;
	z-index: 2;
	padding: 20px 40px 50px;
}

.login-box .login-form {
	width: 350px;
	height: 350px;
	list-style: none;
	margin: 10px auto;
}

.login-form h1 {
	font-size: 16px;
	color: #333;
	text-align: center;
	font-weight: 500;
}

.login-form li {
	width: 350px;
	height: 45px;
	background: #C69;
	margin-top: 35px;
}

.login-form li input {
	width: 350px;
	height: 45px;
	border: 1px solid #f5f5f5;
	box-shadow: 2px 2px 2px #ccc;
	-webkit-box-shadow: 2px 2px 2px #ccc;
	-moz-box-shadow: 2px 2px 2px #ccc;
	-ms-box-shadow: 2px 2px 2px #ccc;
	-o-box-shadow: 2px 2px 2px #ccc;
}

.login-form .login1 input {
	width: 350px;
	height: 45px;
	background: #f33;
	border: 1px solid #f03;
	color: #fff;
}

.login-form .login1 input:hover {
	transition: all 0.1s ease;
	transform: translateY(-1px);
}
</style>
</head>
<body background="${pageContext.request.contextPath }/images/image.jpg">
	<div class="login-box">
		<form id="login-form"
			action="${pageContext.request.contextPath }/admin_login.action"
			method="post">
			<ul class="login-form">
				<h1>管理员登录</h1>
				<li><input type="text" name="aname" id="aname"
					placeholder="管理员名" autocomplete="off" /></li>
				<li><input type="password" name="apwd" id="apass"
					placeholder="密码" autocomplete="off" /></li>
				<li class="login1"><input type="submit" value="登录" /></li>
			</ul>
		</form>

	</div>
</body>
</html>
