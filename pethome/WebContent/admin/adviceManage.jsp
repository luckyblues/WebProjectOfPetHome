<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台查看建议</title>
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
	width: 1000px;
	height: 50px;
}

.list thead tr th {
	font-size: 15px;
	font-weight: 500;
	color: #333;
	height: 50px;
}

.list thead tr .li-id {
	width: 80px;
}

.list thead tr .li-date {
	width: 180px;
}

.list thead tr .li-content {
	width: 180px;
}


.list thead tr .li-action {
	width: 180px;
}

.list tbody {
	width: 1090px;
	height: 50px;
}

.list tbody tr {
	width: 1090px;
	height: 50px;
	background: #f5f5f5;
}

.list tbody tr td {
	font-size: 14px;
	color: #666;
	text-align: center;
}

.list tbody tr:hover {
	background: rgba(255, 51, 51, 0.2);
}

.list tbody tr .li-id {
	width: 80px;
}

.list tbody tr .li-content {
	width: 500px;
}

.list tbody tr .li-date {
	width: 180px;
}


.list tbody tr .li-action {
	width: 180px;
}

.list tbody tr .li-action a {
	color: #00C;
	text-decoration: none;
}
</style>
</head>

<body>
	<table border="0" bordercolor="#999999" class="list">
		<thead>
			<tr>
				<th class="li-id">编号</th>
				<th class="li-content">建议详情</th>
				<th class="li-date">时间</th>
				<th class="li-action">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="l" status="s">
				<tr>
					<td class="li-id"><s:property value="#s.count" /></td>
					<td class="li-content"><s:property value="#l.content" /></td>
					<td class="li-date"><s:property value="#l.adate" /></td>
					<td class="li-action"><a
						href="${pageContext.request.contextPath }/adminAdvice_detailAdvice.action?aid=<s:property value="#l.aid"/>">查看详情</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>

