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
	href="${pageContext.request.contextPath }/images/icon.png " />
<script>
	function saveCart() {
		document.getElementById("submitForm").submit();
	}
</script>
</head>

<body>
	<%@include file="head.jsp"%>
	<!--具体商品页面-->
	<div class="goods-box">
		<div class="back">
			<a href="index.action">返回</a>
		</div>
		<div class="goods-detail">
			<div class="goods-detail-info">
				<form
					action="${pageContext.request.contextPath }/cart_addtoCart.action"
					method="post" id="submitForm">
					<input type="hidden" name="gid"
						value="<s:property value="model.gid"/>" />
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
							<h4>
								<span class="count">购买数量：</span> <input type="text" name="num"
									value="1" maxlength="3" />
							</h4>
							<input id="addto" type="button" onclick="saveCart()"
								value="加入购物车" /> <input id="tobuy" type="button"
								onclick="goingtobuy()" value="立即购买" />

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
