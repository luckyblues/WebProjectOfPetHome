<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pethome快递</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/help.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
</head>
<body>
	<%@include file="/WEB-INF/jsp/head.jsp"%>
	<div class="box">
		<%@include file="help.jsp"%>
		<div class="help-right">
			<div class="title">
				<span style="width: 150px">pethome快递</span>
			</div>
			<div class="detail">
				<img alt="pethome快递" src="${pageContext.request.contextPath }/images/help/help13.jpg"
					width="950px" height="auto">
				<p style="height: 40px; color: #333">开通范围:</p>
				<p>【开通范围】重庆大部分主城区、成都市区三环以内、西安市区三环以内、昆明市二环以内、贵阳三环内和武汉市区三环以内，全场满38元免运费
					(未满38元，收5元送货费)，支持货到付款。</p>
			</div>
		</div>
	</div>
</body>
</html>