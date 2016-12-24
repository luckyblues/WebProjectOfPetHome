<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath}/css/login.css">
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
	<div id="divTittle">
		<span id="spanLogo"><a href=""><img id="imgLogo"
				src="${ pageContext.request.contextPath}/images/logo.jpg" width="99"
				height="62""></a></span> <span id="spanTittle1">· 用户登录</span> <span
			id="spanTittle2"><a href="">宠爱有家</a></span>
	</div>

	<div id="divMain">
		<div id="spanLeft">
			<img src="${ pageContext.request.contextPath}/images/logindog2.jpg"
				width="80%" height="300px">
		</div>

		<div id="spanRight">
			<div style="color: red">
				<s:actionerror />
			</div>
			<form id="loginForm"
				action="${ pageContext.request.contextPath}/user_login.action"
				method="post">
				<table id="tableLogin">
					<tr>
						<td class="tdText">用户名：</td>
						<td class="tdInput"><input class="inputClass" type="text"
							id="uname" name="uname" /></td>
					</tr>
					<tr>
						<td class="tdText">密码：</td>
						<td class="tdInput"><input class="inputClass" type="password"
							id="upwd" name="upwd" /></td>
					</tr>

					<tr>
						<td></td>
						<td class="tdText"><input class="submit" type="submit"
							name="submit" value="登录"></td>
					</tr>

					<tr>
						<td></td>
						<td class="tdText2"><a
							href="${ pageContext.request.contextPath}/user_registPage.action">立即注册</a>
						</td>
					</tr>


				</table>
			</form>
		</div>
	</div>

	<div id="divFoot">
		<div id="divA">
			<a class="aClass" href="" target="_blank">宠爱有家&nbsp;|</a> <a
				class="aClass" href="" target="_blank">宠物知识&nbsp;|</a> <a
				class="aClass" href="" target="_blank">关于我们&nbsp;|</a> <a
				class="aClass" href="" target="_blank">帮助&nbsp;|</a> <a
				class="aClass" href="" target="_blank">联系我们 </a>
		</div>
		<div class="pClass">Copyright &copy 2008-2016 homepet.com
			&nbsp;宠爱有家科技有限公司</div>
	</div>
</body>
</html>