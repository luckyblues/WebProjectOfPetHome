package cn.pethome.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.order.domain.Order;
import cn.pethome.util.PageCallBackImpl;

/**
 * 订单Dao层，继承HibernateDaoSupport并且实现模型驱动，可以很方便的获取订单的属性
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
	 * 根据用户编号查询该用户的订单个数
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
	 * 根据用户编号查询所有的订单
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
	 * 根据订单编号删除订单
	 * 
	 * @param orders
	 * @return
	 */
	public boolean deleteOrder(Order orders) {
		this.getHibernateTemplate().delete(orders);
		return true;
	}

	/**
	 * 根据订单编号找到订单
	 * 
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	/**
	 * 完成订单，修改订单状态
	 * 
	 * @param currOrder
	 * @return
	 */
	public boolean update(Order order2) {
		this.getHibernateTemplate().update(order2);
		return true;
	}

	/**
	 * 后台查询已付款订单的个数
	 * 
	 * @return
	 */
	public int findOrderCount() {
		String hql = "select count(*) from Order o where o.status=2";
		// 调用find方法，返回List集合
		List<Long> list = this.getHibernateTemplate().find(hql);
		// 如果集合不为空的话，说明查询出了总记录数，并取出该集合中的下标值为0的第一个值
		if (list != null) {
			// 取出第一个值，并转化为int型
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 后台查看已付款订单
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
	 * 查看未付款的个数
	 * 
	 * @return
	 */
	public int findNoPayOrderCount() {
		String hql = "select count(*) from Order o where o.status=1";
		// 调用find方法，返回List集合
		List<Long> list = this.getHibernateTemplate().find(hql);
		// 如果集合不为空的话，说明查询出了总记录数，并取出该集合中的下标值为0的第一个值
		if (list != null) {
			// 取出第一个值，并转化为int型
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 查看后台未付款订单
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
