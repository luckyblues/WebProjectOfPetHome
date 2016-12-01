package cn.pethome.order.service;

import cn.pethome.order.dao.OrderDao;

/**
 * 订单的业务逻辑层
 * 
 * @author Administrator
 *
 */
public class OrderService {
	// 注入OrderDao,并提供set方法
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
