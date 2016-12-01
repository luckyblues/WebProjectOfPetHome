<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
	font-size: 14px;
}

body {
	background: #0072bc;
}

.top-bar {
	width: 100%;
	height: 100px;
}

.top-bar .logo {
	float: left;
}

.top-bar .logo img {
	width: 210px;
	height: 88px;
}

.top-bar .top-nav {
	width: 400px;
	height: 40px;
	float: right;
}

.top-bar .top-nav ul {
	list-style: none;
}

.top-nav ul li {
	float: left;
	width: 100px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	margin-left: 1px;
	color: #fff;
}

.top-nav ul li a {
	text-decoration: none;
	color: #fff;
	font-size: 14px;
}

.top-nav ul li a:hover {
	color: #F03;
}

.top-bar .nav {
	width: 1156px;
	height: 50px;
	float: right;
}

.top-bar .nav ul {
	list-style: none;
}

.top-nav ul .aname {
	width: 150px;
}

.top-bar .nav ul li {
	float: left;
	text-align: center;
	width: 120px;
	height: 50px;
	line-height: 50px;
	margin-right: 1px;
	text-decoration: none;
}

.top-bar .nav ul li a {
	text-decoration: none;
	color: #fff;
	display: block;
	width: 120px;
	height: 50px;
}

.nav ul li  ul {
	list-style: none;
}

.nav ul li ul li {
	width: 120px;
	height: 40px;
}

.nav ul li  ul li a {
	width: 120px;
	height: 40px;
	display: block;
	text-align: center;
	text-decoration: none;
	line-height: 40px;
	color: #009;
	background: #e2f0f7;
}

.top-bar .nav ul li a:hover {
	background: #fff;
	color: #009;
}
</style>
</head>

<body>
	<div class="top-bar">
		<div class="logo">
			<img src="${pageContext.request.contextPath }/images/pethome.png" />
		</div>
		<div class="top-nav">
			<ul>

				<li class="aname">您好！<s:property
						value="#session.existAdmin.aname" />
				</li>
				<li><a href="login.jsp" target="right">修改密码</a></li>
				<li><a href="${ pageContext.request.contextPath }/index.action"
					target="_blank">商城首页</a></li>
			</ul>
		</div>
		<div class="nav">
			<ul>
				<li><a
					href="${ pageContext.request.contextPath }/admin/right.jsp"
					target="right">首页</a></li>
				<li><a
					href="${ pageContext.request.contextPath }/admin/aboutus.jsp"
					target="right">关于我们</a></li>
				<li class="litem"><a
					href="${pageContext.request.contextPath }/adminAdvice_findAdvice.action"
					target="right">建议管理</a></li>
				<li class="litem"><a href="#">留言板管理</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
