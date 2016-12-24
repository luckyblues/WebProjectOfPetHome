<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>已付款</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/orders.css" />
</head>
<body>

	<s:iterator value="pageBean.list" var="l">
		<div class="box">
			<s:iterator value="#l.orderItems" var="oItem">
				<div class="addressInfo">
					<div class="person">
						收货人：
						<s:property value="#l.address.realName" />
					</div>
					<div class="tele">
						电话：
						<s:property value="#l.address.tele" />
					</div>
					<div class="address">
						收货地址：
						<s:property value="#l.address.address" />
					</div>
				</div>
				<div class="orderDes">
					<div class="number">
						<div class="date">
							日期：
							<s:property value="#l.ordertime" />
						</div>
						<div class="orderNum">
							订单号：
							<s:property value="#l.oid" />
						</div>
					</div>

					<table>
						<tbody>

							<tr>
								<td>
									<div class="pic">
										<img src="<s:property value="#oItem.goods.gimage"/>" alt="" />
									</div>
									<div class="descript">
										<s:property value="#oItem.goods.gname" />
									</div>
								</td>
								<td>
									<div style="height:67px; line-height:67px;">
										<s:property value="#oItem.goods.gprice" />
										元
									</div>
									<div style="height:67px; line-height:67px;">
										×
										<s:property value="#oItem.count" />
									</div>
								</td>
							</tr>

						</tbody>
					</table>
					<div class="money">
						<div class="relMoney">
							实付款：
							<s:property value="#oItem.subtotal" />
							元
						</div>
					</div>

				</div>
			</s:iterator>
		</div>
	</s:iterator>
	<div class="page">
		<s:if test="pageBean.currentPage==1">

			<a style="color: #f03"
				href="${pageContext.request.contextPath}/adminOrder_findAllNoPaid.action?currentPage=1">首页</a>
		</s:if>
		<s:else>
			<a
				href="${pageContext.request.contextPath}/adminOrder_findAllNoPaid.action?currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
		</s:else>
		<s:if test="pageBean.currentPage==pageBean.totalPage">
			<a
				href="${pageContext.request.contextPath}/adminOrder_findAllNoPaid.action?currentPage=<s:property value="pageBean.totalPage"/>">尾页
			</a>

		</s:if>
		<s:else>
			<a
				href="${pageContext.request.contextPath}/adminOrder_findAllNoPaid.action?currentPage=<s:property value="pageBean.currentPage+1"/>">下

				一页</a>
		</s:else>

	</div>
</body>
</html>

