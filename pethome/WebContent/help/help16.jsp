<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单说明</title>
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
				<span style="width: 150px">订单说明</span>
			</div>
			<div class="detail">
				<p style="height: 70px">如果您访问"pethome商城"或在"pethome商城"购物，或以任何行为实际使用、享受"pethome商城"的服务，即表示您接受了《pethome商城用户协议》，并同意受本协议各项条款的约束。如果您不同意本协议中的任何内容，您可以选择不使用本网站。</p>
				<p class="titlep">一、查看订单</p>
				<p>提交您选购的订单后，您可以在"我的账户"里面的"我的订单"查看订单，点击"订单详情"可进入详情页面查看订单所有信息。</p>
				<p class="titlep">1、等待付款</p>
				<p>
					当您的订单处于此状态，表示您订单选择的是"在线支付"但是还处于未付款的状态。请您在3个工作日以内付款，否则订单会自动撤销。</p>
				<p class="titlep">2、正在配货</p>
				<p>如果您选择的是"在线支付"，表示您的款已经支付完毕，我们正在给您配货。</p>
				<p class="titlep">3、已送货</p>
				<p>此时您订单上货品已经在给您送货的路上啦。。请耐心等候哦</p>
				<p class="titlep">4、完成</p>
				<p>系统默认订单在已发货状态7天以后，自动进入完成状态。</p>
			</div>
		</div>
	</div>
</body>
</html>