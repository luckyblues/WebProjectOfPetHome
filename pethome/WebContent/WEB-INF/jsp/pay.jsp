<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>支付页面</title>
<link rel="stylesheet" type="text/css" href="css/goodslist_cart.css" />
</head>

<body>
	<!--订单盒子-->
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
			<div class="list-body" id="JCartListBody">
				<!--放一条商品记的录盒子-->
				<div class="item-box">
					<div class="item-table J-CartGoods">
						<div class="item-row">
							<div class="col col-img">
								<a href="#"><img
									src="http://i1.mifile.cn/a1/pms_1476004735.12541492!80x80.jpg"
									width="80px" height="80px" /></a>
							</div>
							<div class="col col-name">
								<h3 class="name">
									<a href="#"> 小米羊毛触屏手套 男款 深蓝/浅米 均码 </a>
								</h3>
							</div>
							<div class="col col-price">49元</div>
							<div class="col col-num">1</div>
							<div class="col col-total">49元</div>
							<div class="col col-action">
								<a href="#">删除</a>
							</div>
						</div>
					</div>
				</div>


				<!--第二个订单开始-->

				<div class="item-box">
					<div class="item-table J-CartGoods">
						<div class="item-row">
							<div class="col col-img">
								<a href="#"><img
									src="http://i1.mifile.cn/a1/pms_1476004735.12541492!80x80.jpg"
									width="80px" height="80px" /></a>
							</div>
							<div class="col col-name">
								<h3 class="name">
									<a href="#"> 小米羊毛触屏手套 男款 深蓝/浅米 均码 </a>
								</h3>
							</div>
							<div class="col col-price">49元</div>
							<div class="col col-num">1</div>
							<div class="col col-total">49元</div>
							<div class="col col-action">
								<a href="#">删除</a>
							</div>
						</div>
					</div>
				</div>

				<!--第二个订单结束-->

				<div class="raise-tobuy"></div>
				<!--结算部分-->
				<div class="cart-bar">
					<div class="topay"></div>
					<span class="total">合计：<span>98元</span></span>
				</div>
			</div>
		</div>
	</div>

	<!--地址，收货人，手机号的填写，-->
	<form action="" method="post" id="orderForm">
		<div class="message">
			<p>&nbsp;请填写签收信息！</p>
			<div>
				<span>地址：</span><input name="address" type="text" value=""
					placeholder="填写您的地址" />
			</div>
			<div>
				<span> 姓名：</span><input name="name" type="text" value=""
					placeholder="请填写收货人姓名" />
			</div>
			<div>
				<span> 手机：</span><input name="tel" type="tel" value=""
					placeholder="请填写签收手机号" />
			</div>

		</div>
		<div class="bank">
			<p>&nbsp;请选择支付银行：</p>

			<ul class="bank-detail">
				<li><input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"
					checked="checked" /> <img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_gsyh.png" /></li>

				<li><input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_zgyh.png" /></li>

				<li><input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_nyyh.png" /></li>

				<li><input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_jtyh.png" /></li>

				<li><input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_payh.png" /></li>

				<li><input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_jsyh.png" /></li>

				<li><input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />
					<img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_gdyh.png" /></li>

				<li><input type="radio" name="pd_FrpId"
					value="CMBCHINA-NET-B2C" /> <img
					src="${pageContext.request.contextPath }/images/bankImage/payOnline_zsyh.png" /></li>
			</ul>
		</div>
		<div class="pay-box">
			<a href="javascript:document.getElementById('orderForm').submit();">
				去付款 </a>
		</div>
	</form>
</body>
</html>
