<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线支付</title>
<link rel="stylesheet" type="text/css" href="/pethome/css/help.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
</head>
<body>
	<%@include file="/WEB-INF/jsp/head.jsp"%>
	<div class="box">
		<%@include file="help.jsp"%>
		<div class="help-right">
			<div class="title">
				<span>在线支付</span>
			</div>
			<div class="detail">
				<img alt="在线支付" src="/pethome/images/help/helpimage.png" width="950px"
					height="300px;">
				<p style="height: 40px; color: #333">温馨提示:</p>
				<p>
					本平台为宠友提供安全无虑、便利舒适的购物环境，特別采用SSL电子安全机制，以及与网络银行等级相同的128bit伺服器数位凭证来提高网站的安全性。使您的支付过程绝对的安全，不用担心私人信息泄漏出去。</p>
			</div>
		</div>
	</div>
</body>
</html>