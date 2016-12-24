<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台一级分类</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
	font-size: 14px;
}

.list {
	width: 1090px;
	margin: 20px auto;
}

.list thead {
	width: 100%;
	height: 50px;
	background: #e2f0f7;
}

.list thead tr {
	border: 1px solid #ddd;
	height: 60px;
}

.list thead tr th {
	font-size: 15px;
	font-weight: 500;
	color: #333;
	height: 60px;
}

.list thead tr .li-id {
	width: 80px;
}

.list thead tr .li-img {
	width: 120px;
}

.list thead tr .li-name {
	width: 180px;
}

.list thead tr .li-price {
	width: 100px;
}

.list thead tr .li-desc {
	width: 210px;
}

.list thead tr .li-hot {
	width: 70px;
}

.list thead tr .li-date {
	width: 160px;
}

.list thead tr .li-action {
	width: 180px;
}

.list tbody {
	width: 1090px;
	height: 60px;
}

.list tbody tr {
	width: 1090px;
	height: 75px;
	background: #f5f5f5;
}

.list tbody tr td {
	font-size: 14px;
	color: #666;
	text-align: center;
}

.list tbody tr:hover {
	background: rgba(255, 51, 51, 0.3);
}

.list tbody tr .li-id {
	width: 80px;
}

.list tbody tr .li-img {
	width: 120px;
}

.list tbody tr .li-name {
	width: 180px;
}

.list tbody tr .li-price {
	width: 100px;
}

.list tbody tr .li-desc {
	width: 210px;
}

.list tbody tr .li-hot {
	width: 70px;
}

.list tbody tr .li-date {
	width: 160px;
}

.list tbody tr .li-action {
	width: 180px;
}

.list tbody tr .li-action a {
	color: #00C;
	text-decoration: none;
}

.page {
	width: 300px;
	height: 40px;
	margin: 0 auto;
}

.page a {
	width: 80px;
	height: 30px;
	display: block;
	line-height: 30px;
	background: #fff;
	text-align: center;
	text-decoration: none;
	float: left;
	color: #009;
}

h1 {
	font-size: 16px;
	color: #009;
	text-align: center;
	margin: 10px auto;
}

span {
	padding-top: 15px;
	padding-left: 20px;
	color: #009;
}
</style>
<script type="text/javascript">
	function confirmDel() {
		if (!confirm("确定要删除该商品吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<h1>所有商品</h1>
	<span>共有：<s:property value="pageBean.totalCount" />个商品 </span>
	<table border="0" bordercolor="#999999" class="list">
		<thead>
			<tr>
				<th class="li-id">编号</th>
				<th class="li-img">图片</th>
				<th class="li-name">商品名称</th>
				<th class="li-price">价格</th>
				<th class="li-desc">描述</th>
				<th class="li-hot">热卖</th>
				<th class="li-date">上架日期</th>
				<th class="li-action">操作提示</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pageBean.list" var="l" status="s">
				<tr>
					<td class="li-id"><s:property value="#s.count" /></td>
					<td class="li-img"><img width="100px" height="65px"
						src="${pageContext.request.contextPath }/<s:property value="#l.gimage"/>" />
					</td>
					<td class="li-name"><s:property value="#l.gname" /></td>
					<td class="li-price"><s:property value="#l.gprice" /></td>
					<td class="li-desc"><s:property value="#l.gdesc" /></td>
					<td class="li-hot"><s:property value="#l.is_hot" /></td>
					<td class="li-date"><s:property value="#l.gdate" /></td>
					<td class="li-action"><a
						href="${pageContext.request.contextPath }/adminGoods_editGoods.action?gid=<s:property value="#l.gid"/>">编辑&nbsp|</a>
						<a
						href="${pageContext.request.contextPath }/adminGoods_delGoods.action?gid=<s:property value="#l.gid"/>"
						onclick="confirmDel()">删除</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="page">

		<s:if test="pageBean.currentPage==1">
			<a style="color: #f03"
				href="${pageContext.request.contextPath }/adminGoods_findAllAdminGoods.action?currentPage=1">首页</a>
		</s:if>
		<s:else>
			<a
				href="${pageContext.request.contextPath }/adminGoods_findAllAdminGoods.action?currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
		</s:else>
		<s:if test="pageBean.currentPage==pageBean.totalPage">
			<a
				href="${pageContext.request.contextPath }/adminGoods_findAllAdminGoods.action?currentPage=<s:property value="pageBean.totalPage"/>">尾页</a>

		</s:if>
		<s:else>
			<a
				href="${pageContext.request.contextPath }/adminGoods_findAllAdminGoods.action?currentPage=<s:property value="pageBean.currentPage+1"/>">下一页</a>

		</s:else>
	</div>
</body>
</html>
