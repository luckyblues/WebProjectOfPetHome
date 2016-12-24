<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左边菜单部分</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
}

body {
	background: #e2f0f7;
}

.main-menu {
	padding-top: 10px;
	width: 210px;
}

.main-menu .sort {
	list-style: none;
}

.main-menu .sort .litem {
	width: 210px;
	margin-bottom: 1px;
	text-align: center;
	margin-bottom: 1px;
}

a {
	color: #009;
	text-decoration: none;
}

.main-menu .sort .litem {
	width: 210px;
}

.main-menu .sort .litem>a {
	height: 40px;
	padding-left: 5px;
	background: #e2f0f7;
	display: block;
	margin-top: 2px;
	line-height: 40px;
	border-bottom: 1px solid #fff;
}

.main-menu .sort .litem>a:hover {
	background: #0072bc;
	color: #fff;
}

.main-menu .sort .litem .uitem {
	list-style: none;
}

.litem .uitem li {
	width: 210px;
}

.litem .uitem li a {
	width: 210px;
	height: 40px;
	display: block;
	background: #fff;
	line-height: 40px;
	text-align: center;
	color: #333;
	font-size: 15px;
	border-bottom: 1px solid #ddd;
}

.main-menu ul li a:hover {
	background: #ddd;
	color: #333;
}
</style>
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
	<div class="main-menu">
		<ul class="sort">
			<li class="litem"><a href="javascript:;">商品管理</a>
				<ul class="uitem" style="display: none">
					<li><a
						href="${pageContext.request.contextPath }/adminGoods_findAllAdminGoods.action?currentPage=1"
						target="right">查看商品</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/adminGoods_addPage.action"
						target="right">添加商品</a>
					</li>
				</ul>
			</li>
			<li class="litem"><a href="javascript:;">用户管理</a>
				<ul class="uitem" style="display: none">
					<li><a
						href="${pageContext.request.contextPath }/adminUser_findAllUser.action?currentPage=1"
						target="right">查看用户</a>
					</li>
				</ul>
			</li>
			<li class="litem"><a href="javascript:;">订单管理</a>
				<ul class="uitem" style="display: none">
					<li><a
						href="${pageContext.request.contextPath }/adminOrder_findAllNoPaid.action?currentPage=1"
						target="right">未付款</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/adminOrder_findAllAlreadyPaid.action?currentPage=1"
						target="right">已付款</a>
					</li>
				</ul>
			</li>
			<li class="litem"><a href="javascript:;">一级分类管理</a>
				<ul class="uitem" style="display: none">
					<li><a
						href="${pageContext.request.contextPath }/adminCategory_findAllAdminCategory.action"
						target="right">查看一级分类</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/admin/addCategory.jsp"
						target="right">添加一级分类</a>
					</li>
				</ul>
			</li>
			<li class="litem"><a href="javascript:;">二级分类管理</a>
				<ul class="uitem" style="display: none">
					<li><a
						href="${pageContext.request.contextPath }/adminCS_findAllCategorySecond.action?currentPage=1"
						target="right">查看二级分类</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/adminCS_addPage.action"
						target="right">添加二级分类</a>
					</li>
				</ul>
			</li>
		</ul>

	</div>
</body>
</html>
