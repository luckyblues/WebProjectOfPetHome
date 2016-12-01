<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建议详情</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
	font-size: 14px;
}

.detail {
	width: 900px;
	height: 600px;
	margin: 20px auto;
}

.detail h1 {
	font-size: 16px;
	text-align: center;
	color: #009;
	font-size: 16px;
	margin-bottom: 30px;
	margin-top: 70px;
}

.detail h2 {
	width: 700px;
	height: 200px;
	margin: 0 auto;
	font-size: 15px;
	font-weight: normal;
	text-align: left;
	vertical-align: middle;
	border: 1px solid #ddd;
}

.detail h3 {
	width: 700px;
	height: 50px;
	margin: 0 auto;
	border-bottom: 1px solid #ddd;
	text-align: right;
	line-height: 50px;
}
</style>
</head>

<body>

	<div class="detail">
		<h1>建议详情</h1>
		<h2>
			<s:property value="model.content" />
		</h2>
		<h3>
			时间：<s:property value="model.adate" />
		</h3>
	</div>

</body>
</html>
