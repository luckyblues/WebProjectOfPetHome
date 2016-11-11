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
<body>

	<!--每层热卖商品展示-->


	<div class="page-main">
		<!--每层热卖商品的显示-->
		<!-- 开始第一次循环，是十条商品记录为一次大循环 -->
		<s:iterator value="#session.clist" var="c">
			<ul class="goods-box">
				<div class="first-floor">
					<!-- ========开始头部显示以及分类，以及二级分类 -->
					<div class="box-head">
						<h2>
							热卖
							<s:property value="#c.cname" />
						</h2>
						<div class="category2">
							<ul class="category2-list">
								<s:iterator value="#c.categorySeconds" var="cs">
									<li><a
										href="${pageContext.request.contextPath }/goods_findHotGoods.action?scid=<s:property value="#cs.scid"/>&currentPage=1"><s:property
												value="#cs.scname" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<!-- ======结束头部显示以及分类，以及二级分类 -->


					<!-- 开始商品box-body的循环，是真正的十条商品记录 -->
					<li class="box-body">
						<ul class="goods-list">
							<!-- ============开始商品的循环 -->
							<s:iterator value="pageBean.list" var="h">
								<!-- =========开始一条商品 -->
								<li><a
									href="${pageContext.request.contextPath }/goods_findDetailGoods.action?gid=<s:property value="#h.gid"/>"><img
										src="${pageContext.request.contextPath }/images/goodsImage/<s:property value="#h.gimage"/>"
										alt="" width="150px" height="150px" /></a>

									<h2>
										<s:property value="#h.gname" />
									</h2>
									<h3>
										￥
										<s:property value="#h.gprice" />
										元
									</h3>
									<div class="hidden">
										<h4>
											<s:property value="#h.gdesc" />
										</h4>
									</div></li>
								<!-- =======结束一条商品 -->
							</s:iterator>
							<!-- ============结束商品的循环 -->
						</ul>
					</li>
					<!-- 结束商品box-body的循环，是真正的十条商品记录 -->
				</div>
			</ul>

			<!-- 结束第一次循环，是十条商品记录为一次大循环 -->
		</s:iterator>
	</div>
</body>
</html>