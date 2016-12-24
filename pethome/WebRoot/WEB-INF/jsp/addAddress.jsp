<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addAddress.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
/*填写地址，姓名和手机号*/
* {
	margin: 0px;
	padding: 0px;
	font-family: "微软雅黑";
}

.message {
	width: 1228px;
	height: 300px;
	margin: 50px auto;
}

.message div {
	width: 900px;
	height: 60px;
	margin-left: 50px;
	margin-top: 30px;
}

.message p {
	font-size: 20px;
	color: #434343;
	padding-top: 20px;
	padding-left: 20px;
}

.message span {
	font-size: 18px;
	color: #f33;
	margin-left: 200px;
}

.message input {
	width: 550px;
	height: 50px;
	color: #309;
}

.pay-box {
	width: 1228px;
	height: 50px;
	background: #fff;
}

.pay-box button {
	width: 200px;
	height: 50px;
	text-decoration: none;
	line-height: 50px;
	display: block;
	color: #fff;
	background: #f03;
	font-size: 16px;
	text-align: center;
	display: block;
	margin-left: 450px;
	border: 1px solid #f03;
}

.no-cart {
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

.no-cart h2 {
	color: #DDD;
	font-size: 35px;
	text-align: center;
	font-weight: bold;
	margin-top: 100px;
}

.no-cart a {
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

.no-cart a:hover {
	transform: translateY(-1px);
}
</style>
<script type="text/javascript">
	function confirmAdd() {
		if (!confirm("确定要添加吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<%@include file="head.jsp"%>
	<s:if test="#session.existUser!=null">

		<!--地址，收货人，手机号的填写，-->
		<form
			action="${pageContext.request.contextPath }/address_addUserInfo.action"
			method="post" id="orderForm">
			<input type="hidden" name="addid"
				value="<s:property value="model.addid"/>" />
			<div class="message">
				<p>&nbsp;请填写签收信息！</p>
				<div>
					<span>地址：</span><input name="address" type="text"
						placeholder="填写您的地址" />
				</div>
				<div>
					<span> 姓名：</span><input name="realName" type="text"
						placeholder="请填写收货人姓名" />
				</div>
				<div>
					<span> 手机：</span><input name="tele" type="text"
						placeholder="请填写签收手机号" />
				</div>
			</div>
			<div class="pay-box">
				<button type="submit" value="确定" onclick="confirmAdd()">确定</button>
			</div>
		</form>
	</s:if>
	<s:else>
		<div class="no-cart">
			<h2>您还没登录，快去登录吧！</h2>
			<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>
		</div>
	</s:else>
</body>
</html>
