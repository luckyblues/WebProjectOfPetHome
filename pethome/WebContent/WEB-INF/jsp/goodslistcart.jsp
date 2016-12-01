<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车商品列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/goodslist_cart.css" />
<link rel="stylesheet" type="text/javascript"
	href="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js" />
<link rel="stylesheet" type="text/javascript"
	href="${pageContext.request.contextPath}/js/goodslist_cart.js" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
<script>
	function delOne() {
		if (!confirm("确定要删除该商品吗？")) {
			window.event.returnValue = false;
		}
	}
	function deleteAll() {
		if (!confirm("确定要清空购物车吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<%@include file="head.jsp"%>
	<s:if test="#session.existUser.uname!=null">
		<s:if test="#session.cart.cartItems.size()!=0">
			<!--购物车商品列表盒子-->
			<div class="Jcart-Box">
				<!--购物车中商品列表-->
				<div class="cart-goods-list">
					<!--列表头部-->
					<div class="list-head">
						<div class="col col-img">&nbsp;</div>
						<div class="col col-name">商品名称</div>
						<div class="col col-price">商品单价</div>
						<div class="col col-num">数量</div>
						<div class="col col-total">小计</div>
						<div class="col col-action">操作</div>
					</div>
					<!--列表body-->

					<div class="list-body" id="JCartListBody">
						<!--放一条商品记录de盒子-->
						<s:iterator value="#session.cart.cartItems" var="cartsession">
							<div class="item-box">
								<div class="item-table J-CartGoods">
									<div class="item-row">
										<div class="col col-img">
											<a href="javascript:;"><img
												src="${pageContext.request.contextPath}/images/goodsImage/<s:property value="#cartsession.goods.gimage"/>"
												width="
										80px" height="80px" /></a>
										</div>
										<div class="col col-name">
											<h3 class="name">
												<a href="javascript:;"> <s:property
														value="#cartsession.goods.gname" />
												</a>
											</h3>
										</div>
										<div class="col col-price">
											<s:property value="#cartsession.goods.gprice" />
											元
										</div>
										<div class="col col-num">
											<s:property value="#cartsession.num" />
										</div>
										<div class="col col-total">
											<s:property value="#cartsession.subtotal" />
											元
										</div>
										<div class="col col-action">
											<a
												href="${pageContext.request.contextPath }/cart_deleteOneCartItem.action?gid=<s:property value="#cartsession.goods.gid"/>"
												onclick="delOne()">删除</a>
										</div>
									</div>
								</div>
							</div>

						</s:iterator>
					</div>

				</div>

				<div class="raise-tobuy"></div>
				<!--结算部分-->
				<div class="cart-bar">
					<a class="select-left" href="index.action">继续购物</a> <a
						class="select-left"
						href="${pageContext.request.contextPath }/cart_deleteAll.action"
						onclick="deleteAll()">清空购物车</a> <span class="total-price">合计：<span><s:property
								value="#session.cart.totalamount" />元</span></span>
					<div class="to-pay">
						<a href="${pageContext.request.contextPath }/order_myorder.action">去结算</a>
					</div>
				</div>

			</div>
		</s:if>
		<s:else>
			<div class="no-cart">
				<h2>您的购物车还是空的！</h2>
				<a href="index.action">去首页看看</a>
			</div>
		</s:else>
	</s:if>
	<s:else>
		<div class="no-cart">
			<h2>您还没登录，快去登录吧！</h2>
			<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>
		</div>

	</s:else>
</body>
</html>
