<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main_page.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/main_page.js"></script>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />

</head>
</head>
<body>
	<!-- 整个网站的topBar-->
	<div class="allhead-box">
		<div class="site-topbar">
			<!--topbar里面的内容-->
			<div class="container">
				<!--左边的部分-->
				<span class="topbar-nav"> <a href="index.action">PetHome</a>
					<a
					href="${pageContext.request.contextPath }/order_myaccount.action">我的账户</a>
					<a
					href="${pageContext.request.contextPath}/advice_knowledge.action">宠物知识</a>
					<a href="advice_help.action">帮助中心</a> <a href="#">留言板</a> <a
					href="${pageContext.request.contextPath}/advice_inputadvice.action">建议</a>
				</span>
				<!--右边内容部分-->

				<span class="topbar-info"> <a
					href="${pageContext.request.contextPath }/cart_mycart.action">购物车
				</a> <s:if test="#session.existUser == null">
						<a
							href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>
						<a
							href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>
					</s:if> <s:else>
						<a href="${ pageContext.request.contextPath }/user_exit.action">退出</a>
						<a style="width: 100px" href="javascript:;"> <s:property
								value="#session.existUser.uname" /></a>
					</s:else>
				</span>

			</div>
		</div>
		<!--  第二头部部分-->
		<div class="site-header">
			<div class="container">
				<!--      logo部分-->
				<div class="head-logo">
					<a href="index.action"><img
						src="${pageContext.request.contextPath }/images/pethome.png"
						title="pethome" width="230px" height="80px" /></a>
				</div>
				<!--  导航-->
				<div class="head-nav">
					<ul class="nav-list">
						<li class="nav-item"><a href="#">全球特卖</a></li>
						<li class="nav-item"><a href="#">国家馆</a></li>
						<li class="nav-item"><a href="#">服装城</a></li>
						<li class="nav-item"><a href="#">热卖礼包</a></li>
						<li class="nav-item"><a href="#">清仓特价</a></li>
					</ul>
				</div>
				<!--     搜索-->
				<div class="head-search">
					<form class="search-form"
						action="${pageContext.request.contextPath }/goods_findGoodsByName.action?currentPage=1"
						method="post">
						<input class="search-text" type="text" name="searchName" /> <input
							class="search-btn" type="submit" value="搜索"
							style="font-size: 16px" />

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>