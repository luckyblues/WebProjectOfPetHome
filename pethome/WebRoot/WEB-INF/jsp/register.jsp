<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath}/css/register.css">
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
	<div id="divTittle">
		<span id="spanLogo"><a href=""><img id="imgLogo"
				src="${ pageContext.request.contextPath}/images/logo.jpg" width="99"
				height="62""></a></span> <span id="spanTittle1">· 新用户注册</span> <span
			id="spanTittle2">已有账号？</span> <span id="spanTittle3"><a
			href="${ pageContext.request.contextPath}/user_loginPage.action">
				登录</a></span>
	</div>
	<div id="divMain">
		<form id="registerForm" method="post"
			action="${ pageContext.request.contextPath}/user_register.action">
			<input type="hidden" name="method" value="register" />
			<table id="tableForm">
				<tr>

					<td class="tdText">用户名：</td>

					<td class="tdInput"><input class="inputClass" type="text"
						id="uname" name="uname" onblur="checkUname()" /></td>
					<td class="tdError"><label id="unameError" class="errorClass"></label>
					</td>
					<td class="classError">
						<div>
							<s:fielderror fieldName="uname" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="tdText">密码：</td>
					<td><input class="inputClass" type="password" id="upwd"
						name="upwd" /></td>
					<td><label id="upwdError" class="errorClass"></label></td>
					<td class="classError">
						<div>
							<s:fielderror fieldName="upwd" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="tdText">确认密码：</td>
					<td><input class="inputClass" type="password" id="affpwd"
						name="affpwd" /></td>
					<td><label id="affpwdError" class="errorClass"></label></td>
					<td class="classError">
						<div>
							<s:fielderror fieldName="affpwd" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="tdText">电子邮箱：</td>
					<td><input class="inputClass" type="text" id="email"
						name="email"></td>
					<td><label id="emailError" class="errorClass"><s:fielderror
								fieldName="email" /></label> <span style="color: red"></span></td>
					<td class="classError">
						<div>
							<s:fielderror fieldName="email" />
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="tdText"><input class="submit" type="submit"
						name="submit" value="立即注册"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="divFoot">
		<div id="divA">
			<a class="aClass" href="" target="_blank">宠爱有家&nbsp;|</a> <a
				class="aClass" href="" target="_blank">宠物知识&nbsp;|</a> <a
				class="aClass" href="" target="_blank">关于我们&nbsp;|</a> <a
				class="aClass" href="" target="_blank">帮助&nbsp;|</a> <a
				class="aClass" href="" target="_blank">联系我们 </a>
		</div>
		<div class="pClass">Copyright &copy 2008-2016 pethome.com
			&nbsp;宠爱有家科技有限公司</div>
	</div>
</body>
</html>