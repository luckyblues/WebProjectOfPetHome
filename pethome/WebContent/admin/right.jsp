<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
	font-size: 16px;
}

h1 {
	width: 300px;
	height: 70px;
	color:#009;
	margin: 120px auto;
}
</style>
</head>

<body>
	<h1>
		<s:property value="#session.existAdmin.aname" />
		你好，欢迎回来！
	</h1>
</body>
</html>
