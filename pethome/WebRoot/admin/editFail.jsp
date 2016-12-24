<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'delFail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
	background: #f5f5f5;
}

.box {
	width: 400px;
	height: 100px;
	margin: 200px auto;
}

.box h1 {
	font-size: 30px;
	color: rgba(0, 0, 0, 0.5);
	margin: 50px auto;
}

.box a {
	display: block;
	width: 100px;
	height: 40px;
	text-align: center;
	text-decoration: none;
	color: #fff;
	line-height: 40px;
	background: #f03;
}
</style>
</head>

<body>
	<div class="box">
		<h1>编辑失败！</h1>
		<a href="#" onclick="javascript :history.go(-1);"> 确定 </a>
	</div>
</body>
</html>
