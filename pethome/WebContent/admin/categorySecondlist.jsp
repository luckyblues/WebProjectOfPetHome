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
	width: 1000px;
	margin: 30px auto;
}

.list thead {
	width: 100%;
	height: 40px;
	background: #e2f0f7;
}

.list thead tr {
	border: 1px solid #ddd;
	width: 1000px;
	height: 40px;
}

.list thead tr th {
	font-size: 15px;
	font-weight: 500;
	color: #333;
}

.list thead tr .li-check {
	width: 120px;
}

.list thead tr .li-id {
	width: 120px;
}

.list thead tr .li-image {
	width: 300px;
}

.list thead tr .li-name {
	width: 300px;
}

.list thead tr .li-action {
	width: 300px;
}

.list tbody {
	width: 1000px;
	height: 40px;
}

.list tbody tr {
	width: 1000px;
	height: 40px;
	background: #f5f5f5;
}

.list tbody tr td {
	font-size: 14px;
	color: #666;
	height: 40px;
	text-align: center;
}

.list tbody tr:hover {
	background: rgba(255, 51, 51, 0.2);
}

.list tbody tr .li-id {
	width: 120px;
}

.list tbody tr .li-name {
	width: 300px;
}

.list tbody tr .li-image {
	width: 100px;
}

.list tbody tr .li-image img {
	width: 50px;
	height: 50px;
}

.list tbody tr .li-cname {
	width: 250px;
}

.list tbody tr .li-action {
	width: 250px;
}

.list tbody tr .li-action a {
	color: #00C;
	text-decoration: none;
}

.page {
	width: 200px;
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
	padding-top: 10px;
	color: #009;
	text-align: center;
}
</style>
<script>
	function ConfirmDel() {
		if (!confirm("确定要删除该二级分类吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>

	<h1>所有二级分类</h1>
	<span>共有：<s:property value="pageBean.totalCount" />条数据
	</span>
	<table align="center" border="0" bordercolor="#999999" class="list">
		<thead>
			<tr>
				<th class="li-id">编号</th>
				<th class="li-image">二级分类名称</th>
				<th class="li-name">二级分类名称</th>
				<th class="li-cname">所属一级分类</th>
				<th class="li-action">操作提示</th>
			</tr>
		</thead>

		<tbody>
			<s:iterator value="pageBean.list" var="l" status="s">

				<tr>
					<td class="li-id"><span><s:property value="#s.count" /></span></td>
					<td class="li-image"><img
						src="${pageContext.request.contextPath }/images/categoryImage/<s:property value="#l.scimg"/>"
						width="50px" height="50px" /></td>
					<td class="li-name"><s:property value="#l.scname" /></td>
					<td class="li-cname"><s:property value="#l.category.cname" /></td>
					<td class="li-action"><a
						href="${pageContext.request.contextPath }/adminCS_edit.action?scid=<s:property value="#l.scid"/>">编辑&nbsp;|</a>
						<a
						href="${pageContext.request.contextPath }/adminCS_delCategorySecond.action?scid=<s:property value="#l.scid"/>"
						onclick="ConfirmDel()">删除</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="page">
		<s:if test="pageBean.currentPage==1">
			<a style="color: #f03"
				href="${pageContext.request.contextPath }/adminCS_findAllCategorySecond.action?currentPage=1">首页</a>
		</s:if>
		<s:else>
			<a
				href="${pageContext.request.contextPath }/adminCS_findAllCategorySecond.action?currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
		</s:else>
		<s:if test="pageBean.currentPage==pageBean.totalPage">
			<a
				href="${pageContext.request.contextPath }/adminCS_findAllCategorySecond.action?currentPage=<s:property value="pageBean.totalPage"/>">尾页</a>

		</s:if>
		<s:else>
			<a
				href="${pageContext.request.contextPath }/adminCS_findAllCategorySecond.action?currentPage=<s:property value="pageBean.currentPage+1"/>">下一页</a>
		</s:else>

	</div>
</body>
</html>
