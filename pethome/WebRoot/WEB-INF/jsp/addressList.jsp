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
	function confirmDel() {
		if (!confirm("确定要删除该地址吗？")) {
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
							href="${pageContext.request.contextPath }/order_findAllOrder.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=1">查看订单</a>
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
						<h3>收货地址</h3>
					</div>
					<div class="uc-nav-body">
						<a
							href="${pageContext.request.contextPath }/address_addPage.action">添加收货地址</a>
						<a
							href="${pageContext.request.contextPath }/address_findAllAddress.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=1">查看收货地址</a>
					</div>
				</div>
			</div>
			<div class="span-right">
				<div class="uc-main-box">
					<div class="order-list-box">
						<div class="order-head">
							<h1>
								我的地址 <small>|&nbsp;&nbsp;请谨防钓鱼链接或诈骗电话</small>
							</h1>
						</div>
						<!--全部订单列表-->
						<ul class="address-list">
							<s:iterator value="pageBean.list" var="l">
								<li class="address-item">
									<dl>
										<dt>
											<em class="uname"><s:property value="#l.realName" /> </em>
										</dt>
										<dd class="utel">
											<s:property value="#l.tele" />
										</dd>
										<dd class="uaddress">
											<s:property value="#l.address" />
										</dd>
										<div class="hidden-action">
											<a
												href="${pageContext.request.contextPath }/address_delAddress.action?addid=<s:property value="#l.addid"/>"
												onclick="confirmDel()">删除</a> <a
												href="${pageContext.request.contextPath }/address_editAddress.action?addid=<s:property value="#l.addid"/>">修改</a>
										</div>
									</dl>
								</li>
							</s:iterator>
						</ul>
					</div>
					<div class="page">

						<s:if test="pageBean.currentPage==1">
							<a style="color: #f03"
								href="${pageContext.request.contextPath }/address_findAllAddress.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=1">首页</a>
						</s:if>
						<s:else>
							<a
								href="${pageContext.request.contextPath }/address_findAllAddress.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
						</s:else>
						<s:if test="pageBean.currentPage==pageBean.totalPage">
							<a
								href="${pageContext.request.contextPath }/address_findAllAddress.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=<s:property value="pageBean.totalPage"/>">尾页</a>

						</s:if>
						<s:else>
							<a
								href="${pageContext.request.contextPath }/address_findAllAddress.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=<s:property value="pageBean.currentPage+1"/>">下一页</a>

						</s:else>
					</div>
				</div>
			</div>
		</div>
	</s:if>
	<s:else>
		<div class="notlogin">
			<h2>您还没登录，快去登录吧！</h2>
			<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>
		</div>

	</s:else>
</body>
</html>
