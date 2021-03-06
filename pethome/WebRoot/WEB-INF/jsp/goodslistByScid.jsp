<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有二级分类下商品页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/goodsInFrontByScid.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/icon.png" />
</head>

<body>
	<%@include file="head.jsp"%>
	<div class="goods-box">
		<div class="back">
			<a href="index.action">首页/</a> <a href="index.action"><s:property
					value="scname" /></a>
		</div>
		<div class="box">
			<ul>
				<s:iterator value="pageBean.list" var="p">
					<!-- 第一张图片-->
					<li><a
						href="${pageContext.request.contextPath }/goods_findDetailGoods.action?gid=<s:property value="#p.gid"/>">
							<img
							src="${pageContext.request.contextPath }/<s:property value="#p.gimage"/>"
							alt="" width="150px" height="150px" />
					</a>
						<h2>
							<s:property value="#p.gname" />
						</h2>
						<h3>
							<s:property value="#p.gprice" />
							元
						</h3></li>
				</s:iterator>
			</ul>
		</div>
		<div class="page">
			<s:if test="scid!=null">
				<a
					href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="scid"/>&currentPage=1"
					class="indexPage">首页</a>
				<s:if test="pageBean.currentPage!=1">

					<a
						href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="scid"/>&currentPage=<s:property value="currentPage-1"/>"
						class="indexPage">上页</a>
				</s:if>
				<s:iterator var="pi" begin="1" end="pageBean.totalPage">
					<s:if test="pageBean.currentPage!=#pi">
						<a
							href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="scid"/>&currentPage=<s:property value="#pi"/>"
							class="page-normal"><s:property value="#pi" /></a>
					</s:if>
					<s:else>
						<a style="color: #fff; background: #f66"
							href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="scid"/>&currentPage=<s:property value="#pi"/>"
							class="page-normal"><s:property value="#pi" /></a>
					</s:else>
				</s:iterator>

				<s:if test="pageBean.currentPage!=pageBean.totalPage">
					<a
						href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="scid"/>&currentPage=<s:property value="pageBean.currentPage+1"/>"
						class="lastPage">下页</a>

				</s:if>
				<a
					href="${pageContext.request.contextPath }/goods_findGoodsByScid.action?scid=<s:property value="scid"/>&currentPage=<s:property value="pageBean.totalPage"/>"
					class="lastPage">尾页</a>
			</s:if>
		</div>
	</div>

</body>
</html>
