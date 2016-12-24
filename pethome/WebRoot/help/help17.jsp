<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>常见问题</title>
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
				<span style="width: 150px">常见问题</span>
			</div>
			<div class="detail">
				<p class="titlep">问：不能登陆网站？</p>
				<p>答：有可能是浏览器异常。可以选择其他版本浏览器。或者重启浏览器。</p>
				<p class="titlep">问：收货时发现问题可以拒收吗？</p>
				<p>答：在签收货物时如发现货物有损坏，请直接拒收退回我公司，相关人员将为您重新安排发货。</p>
				<p class="titlep">问：如果我刚刚下单商品就降价了，能给我补偿吗？</p>
				<p>答：pethome商城的商品价格随市场价格的波动每日都会有涨价、降价或者优惠等变化。所以对于因此造成的价格变化，是不能给您补偿的。</p>
				<p class="titlep">问：商城的工作时间是什么时候呢？</p>
				<p>答：订单处理时间为：周一至周日9：00—21：00；自提接待时间为周一至周日9：00—18：00。
					注：如遇国家法定节假日，则以E宠商城新闻发布放假时间为准，请大家届时关注。</p>

			</div>
		</div>
	</div>
</body>
</html>