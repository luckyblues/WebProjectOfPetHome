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
	margin: 40px auto;
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

	<!--地址，收货人，手机号的填写，-->
	<form
		action="${pageContext.request.contextPath }/order_payOrder.action"
		method="post" id="orderForm">
		<input type="hidden" name="oid"
			value="<s:property value="model.oid"/>" />
		<div class="bank">
			<p>&nbsp;请选择支付银行：</p>

			<ul class="bank-detail">
				<li><input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"
					checked="checked" /> <img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_gsyh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_zgyh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_nyyh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_jtyh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_payh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_jsyh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_gdyh.png" />
				</li>

				<li><input type="radio" name="pd_FrpId"
					value="CMBCHINA-NET-B2C" /> <img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_zsyh.png" />
				</li>
			</ul>
		</div>
		<div class="pay-box">
			<a href="javascript:document.getElementById('orderForm').submit();">
				去付款 </a>
		</div>
	</form>

</body>
</html>
