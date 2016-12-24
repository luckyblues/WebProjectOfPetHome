<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帮助中心</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/help.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
</head>

<body>
	<%@include file="/WEB-INF/jsp/head.jsp"%>
	<div class="box">
		<%@include file="help.jsp"%>
		<div class="help-right">
			<div class="title">
				<span>常见问题</span>
			</div>
			<div class="detail">
				<p class="titlep">问：宝贝的商品从哪里发出去？</p>
				<p>答:您好，宝贝的商品是从重庆发货，因为商城在重庆哦。</p>

				<p class="titlep">问： 哪个时间段可以致电去拨打客服呢？</p>
				<p>答 您好，商城的客服电话拨打时间是：周一至周日，09:00 - 21:00</p>
				<p class="titlep">问： 想知道商城是满多少钱包邮吗？包邮快递有那些？</p>
				<p>答
					您好，在线支付以后，四川和重庆满38元包邮。除此之外，广西，贵州，海南，湖北，江西，陕西，云南，安徽，北京，福建，甘肃，广东，河北，河南，湖南，江苏，辽宁，青海，山东，山西，上海，天津，浙江，宁夏，内蒙古，黑龙江，吉林，西藏，新疆满58元包邮。包邮快递有韵达，申通，顺丰陆运。</p>
				<p class="titlep">问： 商城的大件物品是指什么？</p>
				<p>答 （1）长度超过75cm以上的笼子； （2）航空箱、10kg以上储量桶、豪华猫砂盆等大体积塑料性产品；
					（3）40kg以上产品，比如4袋10kg猫砂、3袋15kg狗粮等。</p>
				<p class="titlep">问： 登录密码和支付密码忘记了怎么办？</p>
				<p>答
					您好，需要您致电客服热线4008889200，并告诉客服，您绑定账户的姓名以及地址以及手机号，核对无误后，客服会告知您新密码。</p>
				<p class="titlep">问： 客服电话是免费的吗？</p>
				<p>答 您好，客服电话不是免费的，但不收取长途费，按照您当地的市话费收取。</p>
			</div>
		</div>
	</div>
</body>
</html>
