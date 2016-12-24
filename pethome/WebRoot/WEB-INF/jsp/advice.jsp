<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建议</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-size: 16px;
	font-family: "微软雅黑";
}

body {
	background: #f5f5f5;
}

.advice-box {
	width: 1228px;
	height: 500px;
	margin: 50px auto;
	background: #fff;
	box-shadow: 8px 8px 8px #ddd;
}

.text-detail {
	width: 1200px;
	height: 40px;
	display: block;
	font-size: 17px;
	line-height: 40px;
	text-align: center;
	padding-left: 30px;
	padding-top: 30px;
	margin-top: 20px;
	color: #757575;
}

.advice-box input {
	outline: none;
	width: 800px;
	height: 200px;
	color: #f03;
	font-size: 18px;
	margin-top: 80px;
	margin-left: 250px;
}

.advice-box button {
	width: 200px;
	height: 50px;
	display: block;
	background: #f03;
	line-height: 50px;
	color: #fff;
	font-size: 18px;
	text-align: center;
	text-decoration: none;
	border: 1px solid #f03;
	margin: 50px auto;
}

.advice-box button:hover {
	transition: all 0.2s ease;
	transform: translateY(-1px);
}

.notlogin {
	width: 100%;
	height: 450px;
	background: #fff;
	margin-top: 20px;
	border-top: 2px solid #DDD;
	box-shadow: 8px 8px 8px #eee;
	-moz-box-shadow: 8px 8px 8px #eee;
	-ms-box-shadow: 8px 8px 8px #eee;
	-o-box-shadow: 8px 8px 8px #eee;
	-webkit-box-shadow: 8px 8px 8px #eee;
	border-top: 2px solid #DDD;
}

.notlogin h2 {
	color: #DDD;
	font-size: 35px;
	text-align: center;
	font-weight: bold;
	margin-top: 100px;
}

.notlogin a {
	display: block;
	background: #f03;
	color: #fff;
	width: 200px;
	height: 60px;
	font-size: 17px;
	line-height: 60px;
	text-align: center;
	text-decoration: none;
	margin: 70px 550px;
}

.notlogin a:hover {
	transform: translateY(-1px);
}
</style>
<script type="text/javascript">
	function confirmSubmit() {
		if (!confirm("确定提交您的建议吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
</head>

<body>
	<%@include file="head.jsp"%>
	<s:if test="#session.existUser!=null">

		<form
			action="${pageContext.request.contextPath }/advice_saveAdvice.action"
			method="post">
			<input type="hidden" name="aid"
				value="<s:property value="model.aid"/>" />
			<div class="advice-box">
				<span class="text-detail">说明：如果您在商城购物过程中发现任何的使用异常情况、信息有误，如访问出错，无法正常购买，商品文字、图片信息有误或不完善等，欢迎反馈给我们!</span>

				<input type="text" placeholder="请填写您的反馈信息" name="content" />
				<button type="submit" onclick="confirmSubmit()">提交</button>
			</div>
		</form>
	</s:if>
	<s:else>
		<div class="notlogin">
			<h2>您还没登录，快去登录吧！</h2>
			<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>
		</div>

	</s:else>
</body>
</html>
