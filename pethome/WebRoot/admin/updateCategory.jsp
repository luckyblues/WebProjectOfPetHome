<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改一级分类</title>
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
	width: 400px;
	height: 400px;
	margin: 50px auto;
}

.box span {
	font-size: 15px;
	color: #009;
}

.box input {
	width: 300px;
	height: 45px;
	border: 1px solid rgba(0, 0, 255, 0.2);
	outline: none;
}

.box input:hover {
	border: 1px solid rgba(0, 51, 204, 0.5);
}

.box .box1 {
	margin-top: 50px;
	width: 400px;
	margin-left: 50px;
	height: 200px;
}

.box1 input {
	width: 100px;
	height: 40px;
	display: block;
	background: rgba(51, 51, 255, 0.3);
	float: left;
	border: 1px solid rgba(51, 51, 255, 0.3);
	margin-left: 30px;
	color: #000;
	cursor: pointer;
}

.box1 button {
	width: 100px;
	height: 40px;
	display: block;
	background: rgba(51, 51, 255, 0.3);
	float: left;
	line-height: 40px;
	text-decoration: none;
	text-align: center;
	border: 1px solid rgba(51, 51, 255, 0.3);
	margin-left: 30px;
	color: #000;
	cursor: pointer;
	border: 1px solid rgba(51, 51, 255, 0.3);
}

.box1 button:hover {
	background: rgba(0, 0, 255, 0.6);
	border: 1px solid rgba(0, 0, 255, 0.6);
	cursor: pointer;
	color: #fff;
}

.box1 input:hover {
	background: rgba(0, 0, 255, 0.6);
	border: 1px solid rgba(0, 0, 255, 0.6);
	cursor: pointer;
	color: #fff;
}
</style>
<script type="text/javascript">
	function confirmUpdate() {
		if (!confirm("确定要修改该分类吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<form
		action="${pageContext.request.contextPath }/adminCategory_updateCategory.action"
		method="post">
		<input type="hidden" name="cid"
			value="<s:property value="model.cid"/>" />
		<h1>修改一级分类</h1>

		<div class="box">
			<span>名称：</span> <input type="text" name="cname"
				value="<s:property value="model.cname"/>" />
			<div class="box1">
				<button type="submit" onclick="confirmUpdate()">确定</button>
				<input type="reset" value="清除" />
			</div>
		</div>
	</form>
</body>
</html>
