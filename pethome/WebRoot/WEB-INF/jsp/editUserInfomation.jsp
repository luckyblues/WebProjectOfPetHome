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
<script type="text/javascript">
	function comfirmUpdate() {
		if (!confirm("确定要修改个人信息吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<%@include file="head.jsp"%>
	<!--我的账户页面-->
	<s:if test="#session.existUser!=null">
		<div class="my-account-box">
			<!--左边显我的账户示分类-->
			<div class="span-left">
				<!--我的订单-->
				<div class="uc-nav-box">
					<div class="uc-nav-head">
						<h3>我的订单</h3>
					</div>
					<div class="uc-nav-body">
						<a
							href="${pageContext.request.contextPath }/order_findAllOrder.action?uid=<s:property value="#session.existUser.uid"/>currentPage=1">查看订单</a>
						<a href="${pageContext.request.contextPath }/help/help16.jsp">常见问题</a>
					</div>
				</div>
				<!--个人信息管理-->
				<div class="uc-nav-box">
					<div class="uc-nav-head">
						<h3>个人信息管理</h3>
					</div>
					<div class="uc-nav-body">
						<a
							href="${pageContext.request.contextPath}/user_findUserInfo.action?uid=<s:property value="#session.existUser.uid"/>">查看个人信息</a>
						<a
							href="${pageContext.request.contextPath}/user_editUserInfo.action?uid=<s:property value="#session.existUser.uid"/>">修改个人信息</a>
						<a href="#">修改密码</a>
					</div>
				</div>

				<!--收货地址-->
				<!--个人信息管理-->
				<div class="uc-nav-box">
					<div class="uc-nav-head">
						<h3>收货信息</h3>
					</div>
					<div class="uc-nav-body">
						<a
							href="${pageContext.request.contextPath }/address_addPage.action">添加收货信息</a>
						<a
							href="${pageContext.request.contextPath }/address_findAllAddress.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=1">查看收货信息</a>
					</div>
				</div>
			</div>
			<div class="span-right">
				<div class="uc-main-box">
					<div class="personRight">
						<div class="name">
							<p>个人信息</p>
						</div>
						<div class="info">
							<form
								action="${pageContext.request.contextPath}/user_updateUserInfo.action"
								method="post" id="userInfoForm">
								<input type="hidden" name="uid"
									value="<s:property value="model.uid"/>" /> <input
									type="hidden" name="upwd"
									value="<s:property value="model.upwd"/>" />
								<table>
									<tr>
										<td>登录账号名：</td>
										<td><input class="in" type="text" name="uname"
											value="<s:property value="model.uname" />" /></td>
									</tr>
									<tr>
										<td>邮箱：</td>
										<td><input class="in" type="text" name="email"
											value="<s:property value="model.email" />" /></td>
									</tr>
									<tr>
										<td>真实姓名：</td>
										<td><input class="in" type="text" name="relname"
											value="<s:property value="model.relname" />" /></td>
									</tr>
									<tr>
										<td>手机号码：</td>
										<td><input class="in" type="text" name="tel"
											value="<s:property value="model.tel" />" /></td>
									</tr>
								</table>
								<button type="submit" class="ensure1" onclick=comfirmUpdate();>
									保存</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:if>
	<s:else>
		<div class="notlogin">
			<h2>您还没登录，快去登录吧！</h2>
			<a href="${pageContext.request.contextPath }/user_loginPage.action">登录</a>
		</div>
	</s:else>
</body>
</html>
