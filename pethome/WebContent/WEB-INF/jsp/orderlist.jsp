<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/myaccount.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
</head>

<body>
	<%@include file="head.jsp"%>
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
					<a href="#">查看订单</a> <a href="#">常见问题</a>
				</div>
			</div>
			<!--个人信息管理-->
			<div class="uc-nav-box">
				<div class="uc-nav-head">
					<h3>个人信息管理</h3>
				</div>
				<div class="uc-nav-body">
					<a href="#">查看个人信息</a> <a href="#">修改个人信息</a> <a href="#">修改密码</a>
				</div>
			</div>

			<!--收货地址-->
			<!--个人信息管理-->
			<div class="uc-nav-box">
				<div class="uc-nav-head">
					<h3>收货地址</h3>
				</div>
				<div class="uc-nav-body">
					<a href="#">添加收货地址</a> <a href="#">查看收货地址</a>
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
					<div class="order-body">
						<ul class="order-list">
							<li class="order-item">
								<div class="order-summary">
									<a href="#">已支付</a>
								</div>
								<table class="order-table">
									<thead>
										<tr>
											<th class="col-main">
												<p class="info">
													2016年10月24日 19:13 <span>jack</span> <span>订单号:&nbsp;<a
														href="#"> 1161024280864610</a></span>

												</p>
											</th>
											<th class="col-sub">
												<p>订单金额：59元</p>
											</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="td-item">
												<ul>
													<li>
														<p>
															<img src="images/goods16.jpg" width="80" height="80" />
														</p>
														<p>小米羊毛触屏手套 男款 深蓝/浅米 均码</p>
														<h2>49元</h2>
													</li>
												</ul>
											</td>
											<td class="td-action"><a href="#">订单详情</a> <a href="#">删除订单</a>
											</td>
										</tr>
									</tbody>
								</table>
							</li>
						</ul>
					</div>
					<div class="page">
						<a href="#">上页</a> <a href="#">1</a> <a href="#">下页</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
