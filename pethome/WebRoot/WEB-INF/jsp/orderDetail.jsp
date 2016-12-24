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

<title>My JSP 'orderDetail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/orders.css" />
</head>

<body>
	<%@include file="head.jsp"%>
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
			<div class="box">
				<s:iterator value="model.orderItems" var="oItem">
					<div class="addressInfo">
						<div class="person">
							收货人：
							<s:property value="model.address.realName" />
						</div>
						<div class="tele">
							电话：
							<s:property value="model.address.tele" />
						</div>
						<div class="address">
							收货地址：
							<s:property value="model.address.address" />
						</div>
					</div>
					<div class="orderDes">
						<div class="number">
							<div class="date">
								日期：
								<s:property value="model.ordertime" />
							</div>
							<div class="orderNum">
								订单号：
								<s:property value="model.oid" />
							</div>
						</div>

						<table>
							<tbody>

								<tr>
									<td>
										<div class="pic">
											<img src="<s:property value="#oItem.goods.gimage"/>" alt="" />
										</div>
										<div class="descript">
											<s:property value="#oItem.goods.gname" />
										</div>
									</td>
									<td>
										<div style="height:67px; line-height:67px;">
											<s:property value="#oItem.goods.gprice" />
											元
										</div>
										<div style="height:67px; line-height:67px;">
											×
											<s:property value="#oItem.count" />
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<div class="money">
							<div class="relMoney">
								实付款：
								<s:property value="#oItem.subtotal" />
								元
							</div>
						</div>

					</div>
				</s:iterator>
			</div>
		</div>

	</div>
</body>
</html>
