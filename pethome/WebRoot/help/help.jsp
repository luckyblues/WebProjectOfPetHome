<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帮助中心</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/help.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/images/icon.png " />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.litem>a').click(function() {
			$(this).next('.uitem').slideToggle();
		});
	})
</script>
</head>

<body>
	<ul class="umenu">
		<li class="litem"><a href="javascript:;">支付方式</a>
			<ul class="uitem">
				<li><a
					href="${pageContext.request.contextPath }/help/help11.jsp">货到付款</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/help/help12.jsp">在线支付</a>
				</li>
			</ul></li>
		<li class="litem"><a href="javascript:;">配送方式</a>
			<ul class="uitem">
				<li><a
					href="${pageContext.request.contextPath }/help/help13.jsp">pethome快递</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/help/help14.jsp">物流运输</a>
				</li>
			</ul></li>
		<li class="litem"><a href="javascript:;">购物指南</a>
			<ul class="uitem">
				<li><a
					href="${pageContext.request.contextPath }/help/help15.jsp">购物保障</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/help/help16.jsp">订单说明</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/help/help17.jsp">常见问题</a>
				</li>
			</ul></li>
		<li class="litem"><a href="javascript:;">关于我们</a>
			<ul class="uitem">
				<li><a
					href="${pageContext.request.contextPath }/help/help18.jsp">人才理念</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath }/help/help19.jsp">联系我们</a>
				</li>
			</ul></li>
	</ul>

</body>
</html>
