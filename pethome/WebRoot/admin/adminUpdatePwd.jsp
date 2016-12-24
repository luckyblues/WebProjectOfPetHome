<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员修改密码</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-size: 16px;
	font-family: "微软雅黑";
}

h1 {
	color: #009;
	font-size: 17px;
	text-align: center;
	margin-top: 40px;
}

.box {
	width: 380px;
	height: 250px;
	margin: 60px auto;
}

.box span {
	width: 70px;
	height: 40px;
	line-height: 40px;
	color: #009;
	font-size: 15px;
	display: block;
	margin-top: 20px;
	float: left;
}

.box input {
	width: 270px;
	height: 40px;
	display: block;
	float: right;
	outline: none;
	border: 1px solid rgba(51, 51, 153, 0.5);
	margin-top: 20px;
}

.box .box1 {
	width: 400px;
	height: 50px;
	/*background:#ddd;*/
	padding-top: 220px;
}

.box1 button {
	width: 120px;
	height: 40px;
	margin-left: 110px;
	color: #333;
	font-size: 15px;
	background: rgba(51, 51, 204, 0.5);
	display: block;
	border: 1px solid rgba(51, 51, 204, 0.5);
}
</style>
<script type="text/javascript">
	document.formpwd.focus();
	function check() {
		var f = document.formpwd;
		var newPwd = f.new_apwd.value;
		var confirmPwd = f.confirm_apwd.value;
		if (newPwd == "" || confirmPwd == "") {
			alert("密码为空");
			return false;
		} else if (newPwd != confirmPwd) {
			alert("两次输入密码不同！");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body>
	<h1>修改密码</h1>
	<form
		action="${pageContext.request.contextPath }/admin_updatePwd.action"
		target="_top" method="post" name="formpwd" onsubmit="return check();">
		<input type="hidden" name="aid"
			value="<s:property value="model.aid"/>" /> <input type="hidden"
			name="aname" value="<s:property value="model.aname"/>" />
		<div class="box">
		    
			<span>新密码:</span><input type="password" name="new_apwd" id="new_apwd" />
			<span>确认密码:</span><input type="password" name="confirm_apwd"
				id="confirm_apwd" />
			<div class="box1">
				<button type="submit">确定</button>
			</div>
		</div>
	</form>
</body>
</html>
