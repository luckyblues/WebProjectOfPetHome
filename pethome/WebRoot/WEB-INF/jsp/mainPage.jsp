<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PetHome</title>

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
	<%@include file="head.jsp"%>
	<!--商品分类导航-->
	<div class="site-topmenu">
		<div class="topmenu-container">
			<div class="topmenu">
				<!--   分类导航上面的文字部分-->
				<div class="toptitle">全部商品分类</div>
				<!--  具体分类导航-->
				<ul>
					<s:iterator value="clist" var="c">
						<li><a
							href="goods_findGoodsByCid.action?cid=<s:property value="#c.cid"/>&currentPage=1"><s:property
									value="#c.cname" />
						</a><span class="s1"></span>
							<div class="submenu">
								<div class="leftmenu">
									<dl>
										<s:iterator value="#c.categorySecond" var="cs">
											<dt>
												<img
													src="${pageContext.request.contextPath }/<s:property value="#cs.scimg"/>"
													width="25px" height="25px" />
											</dt>

											<dd>
												<a
													href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="#cs.scid"/>&currentPage=1"><s:property
														value="#cs.scname" />
												</a>
											</dd>
										</s:iterator>
									</dl>
								</div>
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>

			<div class="home-slider">
				<div class="home-banner">
					<ul class="img-lists">
						<li class="img"><a href="#"><img
								src="${pageContext.request.contextPath }/images/bannerImage/img01.jpg"
								width="990px" height="452px" />
						</a>
						</li>
						<li class="img"><a href="#"><img
								src="${pageContext.request.contextPath }/images/bannerImage/img02.jpg"
								width="990px" height="452px" />
						</a>
						</li>
						<li class="img"><a href="#"><img
								src="${pageContext.request.contextPath }/images/bannerImage/img03.jpg"
								width="990px" height="452px" />
						</a>
						</li>
						<li class="img"><a href="#"><img
								src="${pageContext.request.contextPath }/images/bannerImage/img04.jpg"
								width="990px" height="452px" />
						</a>
						</li>
						<li class="img"><a href="#"><img
								src="${pageContext.request.contextPath }/images/bannerImage/img05.jpg"
								width="990px" height="452px" />
						</a>
						</li>
						<li class="img"><a href="#"><img
								src="${pageContext.request.contextPath }/images/bannerImage/img06.jpg"
								width="990px" height="452px" />
						</a>
						</li>
					</ul>

					<!--  图片上的切换按钮-->
					<div class="buttons">
						<span class="button bg">1</span> <span class="button">2</span> <span
							class="button">3</span> <span class="button">4</span> <span
							class="button">5</span> <span class="button">6</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--热卖商品展示-->


	<div class="page-main">
		<ul class="goods-box">
			<!-- ========开始头部显示以及分类，以及二级分类 -->
			<div class="box-head">
				<h2>热卖商品</h2>
			</div>
			<!-- 开始商品box-body的循环，是真正的十条商品记录 -->
			<li class="box-body">
				<ul class="goods-list">
					<!-- ============开始商品的循环 -->
					<s:iterator value="hlist" var="h">
						<!-- =========开始一条商品 -->
						<li><a
							href="${pageContext.request.contextPath }/goods_findDetailGoods.action?gid=<s:property value="#h.gid"/>"><img
								src="${pageContext.request.contextPath }/<s:property value="#h.gimage"/>"
								alt="" width="150px" height="150px" />
						</a>

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
							</div>
						</li>
						<!-- =======结束一条商品 -->
					</s:iterator>
					<!-- ============结束商品的循环 -->
				</ul></li>
		</ul>
	</div>


	<!-- 最新商品展示 -->


	<div class="page-main">
		<ul class="goods-box">
			<!-- ========开始头部显示以及分类，以及二级分类 -->
			<div class="box-head">
				<h2>最新商品</h2>
			</div>
			<!-- 开始商品box-body的循环，是真正的十条商品记录 -->
			<li class="box-body">
				<ul class="goods-list">
					<!-- ============开始商品的循环 -->
					<s:iterator value="nlist" var="n">
						<!-- =========开始一条商品 -->
						<li><a
							href="${pageContext.request.contextPath }/goods_findDetailGoods.action?gid=<s:property value="#n.gid"/>"><img
								src="${pageContext.request.contextPath }/<s:property value="#n.gimage"/>"
								alt="" width="150px" height="150px" />
						</a>

							<h2>
								<s:property value="#n.gname" />
							</h2>
							<h3>
								￥
								<s:property value="#n.gprice" />
								元
							</h3>
							<div class="hidden">
								<h4>
									<s:property value="#n.gdesc" />
								</h4>
							</div>
						</li>
						<!-- =======结束一条商品 -->
					</s:iterator>
					<!-- ============结束商品的循环 -->
				</ul></li>
		</ul>
	</div>

	<a href="javascript:;" class="top">返回<br />顶部 </a>
</body>
</html>
