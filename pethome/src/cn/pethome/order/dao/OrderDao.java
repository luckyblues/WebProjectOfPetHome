package cn.pethome.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.order.domain.Order;
import cn.pethome.util.PageCallBackImpl;

/**
 * ����Dao�㣬�̳�HibernateDaoSupport����ʵ��ģ�����������Ժܷ���Ļ�ȡ����������
 * 
 * @author Administrator
 * 
 */
public class OrderDao extends HibernateDaoSupport {

	public boolean save(Order orders) {
		this.getHibernateTemplate().save(orders);
		return true;
	}

	/**
	 * �����û���Ų�ѯ���û��Ķ�������
	 * 
	 * @param uid
	 * @return
	 */
	public int findOrderCount(int uid) {
		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * �����û���Ų�ѯ���еĶ���
	 * 
	 * @param uid
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Order> findAllOrder(int uid, int startIndex, int pageSize) {
		String hql = "from Order o where o.user.uid=?";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Order>(hql, new Object[] { uid },
						startIndex, pageSize));
		return list;
	}

	/**
	 * ���ݶ������ɾ������
	 * 
	 * @param orders
	 * @return
	 */
	public boolean deleteOrder(Order orders) {
		this.getHibernateTemplate().delete(orders);
		return true;
	}

	/**
	 * ���ݶ�������ҵ�����
	 * 
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	/**
	 * ��ɶ������޸Ķ���״̬
	 * 
	 * @param currOrder
	 * @return
	 */
	public boolean update(Order order2) {
		this.getHibernateTemplate().update(order2);
		return true;
	}

	/**
	 * ��̨��ѯ�Ѹ�����ĸ���
	 * 
	 * @return
	 */
	public int findOrderCount() {
		String hql = "select count(*) from Order o where o.status=2";
		// ����find����������List����
		List<Long> list = this.getHibernateTemplate().find(hql);
		// ������ϲ�Ϊ�յĻ���˵����ѯ�����ܼ�¼������ȡ���ü����е��±�ֵΪ0�ĵ�һ��ֵ
		if (list != null) {
			// ȡ����һ��ֵ����ת��Ϊint��
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * ��̨�鿴�Ѹ����
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Order> findAllAlreadyPaid(int startIndex, int pageSize) {
		String hql = "from Order o where  o.status=2 order  by oid asc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Order>(hql, null, startIndex, pageSize));
		return list;
	}

	/**
	 * �鿴δ����ĸ���
	 * 
	 * @return
	 */
	public int findNoPayOrderCount() {
		String hql = "select count(*) from Order o where o.status=1";
		// ����find����������List����
		List<Long> list = this.getHibernateTemplate().find(hql);
		// ������ϲ�Ϊ�յĻ���˵����ѯ�����ܼ�¼������ȡ���ü����е��±�ֵΪ0�ĵ�һ��ֵ
		if (list != null) {
			// ȡ����һ��ֵ����ת��Ϊint��
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * �鿴��̨δ�����
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Order> findAllNoPaid(int startIndex, int pageSize) {
		String hql = "from Order o where  o.status=1 order  by oid asc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Order>(hql, null, startIndex, pageSize));
		return list;
	}
}
