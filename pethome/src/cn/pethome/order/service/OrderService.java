package cn.pethome.order.service;

import cn.pethome.order.dao.OrderDao;

/**
 * ������ҵ���߼���
 * 
 * @author Administrator
 *
 */
public class OrderService {
	// ע��OrderDao,���ṩset����
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
