<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>具体商品详情页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/detail_goodsinfo.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon175x175.png " />

</head>

<body>
<%@include file="head.jsp" %>
	<!--具体商品页面-->
	<div class="goods-box">
		<div class="back">
			<a href="index.action">返回</a>
		</div>
		<div class="goods-detail">
			<div class="goods-detail-info">
				<div class="goods-container">
					<div class="goods-left">
						<div class="big-goods-pic">
							<img
								src="${pageContext.request.contextPath }/images/goodsImage/<s:property value="model.gimage"/>"
								width="200px" height="200px" />
						</div>

						<div class="small-goods-pic">
							<img
								src="${pageContext.request.contextPath }/images/goodsImage/<s:property value="model.gimage"/>"
								width="100px" height="100px" />
						</div>
					</div>
					<div class="goods-right">
						<h1>
							<s:property value="model.gname" />
						</h1>
						<h2>
							<s:property value="model.gdesc" />
						</h2>
						<h3>
							<span><s:property value="model.gprice" /></span>元
						</h3>
						<a href="#">加入购物车</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
