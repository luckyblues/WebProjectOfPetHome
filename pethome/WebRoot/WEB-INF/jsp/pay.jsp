<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>支付页面</title>
<link rel="stylesheet" type="text/css" href="css/goodslist_cart.css" />
<style type="text/css">
/*填写地址，姓名和手机号*/
* {
	margin: 0px;
	padding: 0px;
	font-family: "微软雅黑";
}

.box {
	width: 1228px;
	height: 100px;
	background: #fff;
	margin: 10px auto;
}

.box .box1 {
	width: 800px;
	height: 70px;
	padding-top: 30px;
	margin-left: 300px;
}

.box1 span {
	font-size: 18px;
	color: #f03;
	padding-top: 30px;
	padding-left: 40px;
}

.box1 select {
	width: 400px;
	height: 40px;
	color: #333;
	border: 1px solid #009;
	outline: none;
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
</head>

<body>
	<%@include file="head.jsp"%>
	<!--订单盒子-->
	<s:if test="#session.cart.cartItems.size()!=0">
		<div class="Jcart-Box">
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
				<!--订单开始-->
				<div class="list-body" id="JCartListBody">
					<s:iterator value="#session.cart.cartItems" var="citem">
						<div class="item-box">
							<div class="item-table J-CartGoods">
								<div class="item-row">
									<div class="col col-img">
										<a href="javascript:;"><img
											src="<s:property value="#citem.goods.gimage"/>" width="80px"
											height="80px" /> </a>
									</div>
									<div class="col col-name">
										<h3 class="name">
											<a href="javascript:;"> <s:property
													value="#citem.goods.gname" /> </a>
										</h3>
									</div>
									<div class="col col-price">
										<s:property value="#citem.goods.gprice" />
										元
									</div>
									<div class="col col-num">
										<s:property value="#citem.num" />
									</div>
									<div class="col col-total">
										<s:property value="#citem.subtotal" />
										元
									</div>
									<div class="col col-action">
										<a
											href="${pageContext.request.contextPath }/cart_deleteOneCartItem.action?gid=<s:property value="#citem.goods.gid"/>"
											onclick="delOne()">删除</a>
									</div>
								</div>
							</div>

						</div>
					</s:iterator>

					<!-- 订单结束 -->



					<div class="raise-tobuy"></div>
					<!--结算部分-->
					<div class="cart-bar">
						<div class="topay"></div>
						<span class="total">合计：<span><s:property
									value="#session.cart.totalamount" />元</span> </span>
					</div>
				</div>
			</div>
		</div>

		<!--地址，收货人，手机号的填写，-->
		<form
			action="${pageContext.request.contextPath }/order_saveOrder.action"
			method="post" id="orderForm">
			<div class="box">
				<div class="box1">
					<span>选择地址：</span><select name="addid">
						<s:iterator value="list" var="l">
							<option value="<s:property value="#l.addid"/>">
								<s:property value="#l.realName" />
							</option>
						</s:iterator>
					</select>
				</div>
			</div>
			<div class="pay-box">
				<a href="javascript:document.getElementById('orderForm').submit();">
					确认订单</a>
			</div>
		</form>
	</s:if>
	<s:else>
		<div class="no-cart">
			<h2>您还没有订单</h2>
			<a href="index.action">先去购物吧</a>
		</div>
	</s:else>
</body>
</html>
