package cn.pethome.order.service;

import java.util.List;

import cn.pethome.order.dao.OrderDao;
import cn.pethome.order.domain.Order;
import cn.pethome.util.PageBean;

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

	public boolean save(Order orders) {
		if (orderDao.save(orders)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户id查询所有的订单
	 * 
	 * @param uid
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllOrder(int uid, int currentPage) {
		// 进行分页封装
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		int pageSize = 1;
		pageBean.setPageSize(pageSize);
		int totalCount = orderDao.findOrderCount(uid);
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int startIndex = (currentPage - 1) * pageSize;
		List<Order> list = orderDao.findAllOrder(uid, startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据编号删除订单
	 * 
	 * @param orders
	 * @return
	 */
	public boolean delOrder(Order orders) {
		if (orderDao.deleteOrder(orders)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据订单编号找到订单
	 * 
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid) {

		return orderDao.findByOid(oid);
	}

	/**
	 * 支付完成修改状态
	 * 
	 * @param currOrder
	 * @return
	 */
	public boolean update(Order order2) {
		if (orderDao.update(order2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查看后台已付款的订单
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllAlreadyPaid(int currentPage) {
		// 创建PageBean对象，并封装相应的属性
		PageBean pageBean = new PageBean();
		// 封装当前页属性
		pageBean.setCurrentPage(currentPage);
		int pageSize = 1;
		// 每页显示1条属性
		pageBean.setPageSize(pageSize);
		// 设置总共有多少条数据
		int totalCount = orderDao.findOrderCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置当前页的第一条数据是第多少条数据
		int startIndex = (currentPage - 1) * pageSize;
		// 设置pageBean中List中的订单数据
		List<Order> list = orderDao.findAllAlreadyPaid(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 查看后台未付款的订单
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllNoPaid(int currentPage) {
		// 创建PageBean对象，并封装相应的属性
		PageBean pageBean = new PageBean();
		// 封装当前页属性
		pageBean.setCurrentPage(currentPage);
		int pageSize = 1;
		// 每页显示1条属性
		pageBean.setPageSize(pageSize);
		// 设置总共有多少条数据
		int totalCount = orderDao.findNoPayOrderCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置当前页的第一条数据是第多少条数据
		int startIndex = (currentPage - 1) * pageSize;
		// 设置pageBean中List中的订单数据
		List<Order> list = orderDao.findAllNoPaid(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
