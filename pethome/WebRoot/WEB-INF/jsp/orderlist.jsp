<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/myaccount.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
<script type="text/javascript">
	function confirmDel() {
		if (!confirm("确定要删除该订单吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<%@include file="head.jsp"%>
	<s:if test="#session.existUser!=null">
		<!--我的账户页面-->
		<div class="my-account-box">
			<!--返回首页-->
			<div class="back"></div>
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
							href="${pageContext.request.contextPath}/user_editUserInfo.action?uid=<s:property value="#session.existUser.uid"/>">修改个人信息</a><a
							href="#">修改密码</a>
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
			<!-- 右边 -->
			<div class="span-right">
				<div class="uc-main-box">
					<div class="order-list-box">
						<div class="order-head">
							<h1>
								我的订单 <small>|&nbsp;&nbsp;请谨防钓鱼链接或诈骗电话</small>
							</h1>
							<div class="more">
								<h2>全部有效订单</h2>
							</div>
						</div>
						<!--全部订单列表-->
						<s:if test="pageBean.list!=null">
							<div class="order-body">
								<ul class="order-list">
									<s:iterator value="pageBean.list" var="l">

										<li class="order-item">
											<div class="order-summary">
												<s:if test="#l.status==1">
													<a href="${pageContext.request.contextPath }/order_payOrder.action?oid=<s:property value="#l.oid"/>" style="color:#009">未付款</a>
												</s:if>
												<s:if test="#l.status==2">
													<a href="#" style="color:#009">已付款</a>
												</s:if>

											</div>

											<table class="order-table">
												<thead>
													<tr>
														<th class="col-main">
															<p class="info">
																<s:property value="#l.ordertime" />
																<span><s:property value="#l.address.realName" />
																</span> <span>订单号:&nbsp;<a href="javascript:;"><s:property
																			value="#l.oid" /> </a> </span>

															</p>
														</th>
														<th class="col-sub">
															<p>
																订单金额：
																<s:property value="#l.total" />
																元
															</p>
														</th>
													</tr>
												</thead>

												<tbody>
													<s:iterator value="#l.orderItems" var="oItem">
														<tr>
															<td class="td-item">
																<ul>
																	<li>
																		<p>
																			<img src="<s:property value="#oItem.goods.gimage"/>"
																				width="80" height="80" />
																		</p>
																		<p>
																			<s:property value="#oItem.goods.gname" />
																		</p>
																		<p style="color:#f03">

																			<s:property value="#oItem.count" />
																			件
																		</p>
																		<h2>
																			<s:property value="#oItem.subtotal" />
																			元
																		</h2>
																	</li>
																</ul>
															</td>
															<td class="td-action"
																style="border-bottom:1px solid #f5f5f5"><a
																href="${pageContext.request.contextPath }/order_detailOrder.action?oid=<s:property value="#l.oid"/>">订单详情</a>
																<a
																href="${pageContext.request.contextPath }/order_delOrder.action?oid=<s:property value="#l.oid"/>"
																onclick="confirmDel()">删除订单</a>
															</td>
														</tr>
													</s:iterator>

												</tbody>

											</table></li>

									</s:iterator>
								</ul>

							</div>
							<div class="page">

								<s:if test="pageBean.currentPage==1">
									<a style="color: #f03"
										href="${pageContext.request.contextPath }/order_findAllOrder.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=1">首页</a>
								</s:if>
								<s:else>
									<a
										href="${pageContext.request.contextPath }/order_findAllOrder.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
								</s:else>
								<s:if test="pageBean.currentPage==pageBean.totalPage">
									<a
										href="${pageContext.request.contextPath }/order_findAllOrder.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=<s:property value="pageBean.totalPage"/>">尾页</a>

								</s:if>
								<s:else>
									<a
										href="${pageContext.request.contextPath }/order_findAllOrder.action?uid=<s:property value="#session.existUser.uid"/>&currentPage=<s:property value="pageBean.currentPage+1"/>">下一页</a>

								</s:else>
							</div>
						</s:if>
						<s:else>
							<h2 id="noOrder">您还没有订单，快去购物吧</h2>
						</s:else>
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
