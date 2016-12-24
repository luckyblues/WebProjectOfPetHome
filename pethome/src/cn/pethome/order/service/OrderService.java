package cn.pethome.order.service;

import java.util.List;

import cn.pethome.order.dao.OrderDao;
import cn.pethome.order.domain.Order;
import cn.pethome.util.PageBean;

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

	public boolean save(Order orders) {
		if (orderDao.save(orders)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �����û�id��ѯ���еĶ���
	 * 
	 * @param uid
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllOrder(int uid, int currentPage) {
		// ���з�ҳ��װ
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
	 * ���ݱ��ɾ������
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
	 * ���ݶ�������ҵ�����
	 * 
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid) {

		return orderDao.findByOid(oid);
	}

	/**
	 * ֧������޸�״̬
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
	 * �鿴��̨�Ѹ���Ķ���
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllAlreadyPaid(int currentPage) {
		// ����PageBean���󣬲���װ��Ӧ������
		PageBean pageBean = new PageBean();
		// ��װ��ǰҳ����
		pageBean.setCurrentPage(currentPage);
		int pageSize = 1;
		// ÿҳ��ʾ1������
		pageBean.setPageSize(pageSize);
		// �����ܹ��ж���������
		int totalCount = orderDao.findOrderCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ���õ�ǰҳ�ĵ�һ�������ǵڶ���������
		int startIndex = (currentPage - 1) * pageSize;
		// ����pageBean��List�еĶ�������
		List<Order> list = orderDao.findAllAlreadyPaid(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * �鿴��̨δ����Ķ���
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllNoPaid(int currentPage) {
		// ����PageBean���󣬲���װ��Ӧ������
		PageBean pageBean = new PageBean();
		// ��װ��ǰҳ����
		pageBean.setCurrentPage(currentPage);
		int pageSize = 1;
		// ÿҳ��ʾ1������
		pageBean.setPageSize(pageSize);
		// �����ܹ��ж���������
		int totalCount = orderDao.findNoPayOrderCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ���õ�ǰҳ�ĵ�һ�������ǵڶ���������
		int startIndex = (currentPage - 1) * pageSize;
		// ����pageBean��List�еĶ�������
		List<Order> list = orderDao.findAllNoPaid(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
