<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的账户</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/myaccount.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
</head>

<body>

	<!--我的账户页面-->
	<div class="my-account-box">
		<!--左边显我的账户示分类-->
		<div class="span-left">
			<!--我的订单-->
			<div class="uc-nav-box">
				<div class="uc-nav-head">
					<h3>我的订单</h3>
				</div>
				<div class="uc-nav-body">
					<a href="#">查看订单</a> <a href="#">常见问题</a>
				</div>
			</div>
			<!--个人信息管理-->
			<div class="uc-nav-box">
				<div class="uc-nav-head">
					<h3>个人信息管理</h3>
				</div>
				<div class="uc-nav-body">
					<a href="#">查看个人信息</a> <a href="#">修改个人信息</a> <a href="#">修改密码</a>
				</div>
			</div>

			<!--收货地址-->
			<!--个人信息管理-->
			<div class="uc-nav-box">
				<div class="uc-nav-head">
					<h3>收货地址</h3>
				</div>
				<div class="uc-nav-body">
					<a href="#">添加收货地址</a> <a href="#">查看收货地址</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
