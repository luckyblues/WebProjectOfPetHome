<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加二级分类</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-size: 14px;
	font-family: "微软雅黑";
}

h1 {
	font-size: 16px;
	font-weight: 600;
	color: #009;
	margin-top: 100px;
	text-align: center;
}

.box {
	width: 300px;
	height: 300px;
	margin: 50px auto;
}

.box span {
	font-size: 15px;
	color: #009;
}

.box input {
	width: 300px;
	height: 45px;
	display: block;
	margin-top: 15px;
	border: 1px solid rgba(0, 0, 255, 0.6);
	outline: none;
}

.box input:hover {
	border: 1px solid rgba(0, 0, 255, 0.2);
}

.box .box1 {
	margin-top: 40px;
	width: 300px;
	height: 70px;
}

.box1 button {
	width: 100px;
	height: 40px;
	display: block;
	background: rgba(0, 0, 255, 0.2);
	border: 1px solid rgba(0, 0, 255, 0.2);
	margin-left: 50px;
	color: #000;
}

.box1 button:hover {
	background: rgba(0, 0, 255, 0.6);
	border: 1px solid rgba(0, 0, 255, 0.6);
	color: #fff;
}

.box select {
	width: 150px;
	height: 45px;
	display: block;
	cursor: pointer;
	border: 1px solid rgba(0, 0, 255, 0.6);
	display: block;
}

.box select option {
	width: 150px;
	height: 45px;
}

.box select:hover {
	border: 1px solid rgba(255, 51, 51, 0.5);
}
</style>
<script type="text/javascript">
	function confirmAdd() {
		if (!confirm("确定要添加该二级分类吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<form
		action="${pageContext.request.contextPath }/adminCS_addCategorySecond.action"
		method="post" enctype="multipart/form-data">
		<h1>添加二级分类</h1>
		<div class="box">
			<span>名称：</span> <input type="text" name="scname"
				placeholder="请输入二级分类名称" /> <span> 上传二级分类图片</span> <input
				type="file" name="upload" /> <span> 所属一级分类：</span> <select
				name="cid">
				<s:iterator value="list" var="l">
					<option value="<s:property value="#l.cid"/>">
						<s:property value="#l.cname" />
					</option>
				</s:iterator>
			</select>

			<div class="box1">
				<button type="submit" value="确定" onclick="confirmAdd()">确定</button>
			</div>
		</div>
	</form>
</body>
</html>

