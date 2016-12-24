<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台首页</title>
</head>
<!--框架cols代表纵向切 rows代表横向切-->
<s:if test="#session.existAdmin.aname!=null">
	<frameset rows="88,*" border="1" bordercolor="#0072bc"> <frame
		src="${pageContext.request.contextPath }/admin/top.jsp" name="top"
		scrolling="no" frameborder="0" noresize="noresize"></frame> <frameset
		cols="210,*" border="1" bordercolor="#e2f0f7"> <frame
		src="${pageContext.request.contextPath }/admin/left.jsp"
		scrolling="no" name="left" frameborder="0" noresize="noresize"></frame>
	<frame src="${pageContext.request.contextPath }/admin/right.jsp"
		name="right" frameborder="0" noresize="noresize"></frame> </frameset> </frameset>
</s:if>
<s:else>
	<%@include file="login.jsp"%>
</s:else>
</html>
