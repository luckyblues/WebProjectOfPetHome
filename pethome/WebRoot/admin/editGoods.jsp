<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑商品</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-size: 14px;
	font-family: "微软雅黑";
	color: #009;
}

h1 {
	font-size: 16px;
	font-weight: 600;
	color: #009;
	margin-top: 100px;
	text-align: center;
}

.box {
	width: 320px;
	height: 500px;
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
	margin-top: 10px;
	border: 1px solid rgba(0, 0, 204, 0.5);
	outline: none;
}

.box input:hover {
	border: 1px solid rgba(0, 0, 204, 0.5);
}

.box .box1 {
	margin-top: 40px;
	width: 320px;
	margin-left: 30px;
	height: 400px;
}

.box1 button {
	width: 100px;
	height: 40px;
	background: rgba(0, 0, 204, 0.5);
	border: 1px solid rgba(0, 0, 204, 0.5);
	margin-left: 30px;
	color: #333;
	outline: none;
}

.box select {
	width: 150px;
	height: 45px;
	margin-top: 10px;
	display: block;
	cursor: pointer;
	border: 1px solid rgba(255, 0, 51, 0.5);
}

.box select option {
	width: 150px;
	height: 45px;
}

.box select:hover {
	border: 1px solid rgba(0, 0, 204, 0.5);
}
</style>
<script type="text/javascript">
	function confrimUpdate() {
		if (!confirm("确定要修改该商品吗？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<form
		action="${pageContext.request.contextPath }/adminGoods_updateGoods.action"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="gid"
			value="<s:property value="model.gid"/>" /> <input type="hidden"
			name="gimage" value="<s:property value="model.gimage"/>" />
		<h1>编辑商品</h1>
		<div class="box">

			商品名： <input type="text" name="gname"
				value="<s:property value="model.gname"/>" /> 价格：<input type="text"
				name="gprice" value="<s:property value="model.gprice"/>" /> 描述：<input
				type="text" name="gdesc" value="<s:property value="model.gdesc"/>" />
			是否热卖：<input type="text" name="is_hot"
				value="<s:property value="model.is_hot"/>" /> 上传图片：<input
				type="file" name="upload" /> 所属二级分类： <select name="scid">
				<s:iterator value="list" var="l">
					<option value="<s:property value="#l.scid"/>"
						<s:if test="#l.scid==model.categorySecond.scid">selected</s:if>>
						<s:property value="#l.scname" />
					</option>
				</s:iterator>
			</select>

			<div class="box1">
				<button type="submit" value="确定" onclick="confrimUpdate()">确定</button>
			</div>
		</div>
	</form>
</body>
</html>
