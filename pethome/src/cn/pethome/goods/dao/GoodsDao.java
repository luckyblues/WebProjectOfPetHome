package cn.pethome.goods.dao;

import java.util.List;

import javax.mail.Session;
import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.goods.domain.Goods;
import cn.pethome.util.PageCallBackImpl;

/**
 * ��Ʒ�ĳ־ò�ʵ�� ʵ��ģ������
 * 
 * @author Administrator
 * 
 */

public class GoodsDao extends HibernateDaoSupport {

	/**
	 * ������Ʒ�������Ҿ�����Ʒ��ʵ��
	 * 
	 * @param gid
	 * @return
	 */
	public Goods findDetailGoods(Integer gid) {
		return this.getHibernateTemplate().get(Goods.class, gid);
	}

	/**
	 * Daoʵ�� ��ѯ����Ķ��������µ���Ʒ��¼����
	 * 
	 * @param scid
	 * 
	 * @return
	 */

	public int findGoodsCount(Integer scid) {

		// hql��䣬��ѯĳ���������µ�������Ʒ��¼��
		String hql = "SELECT COUNT(*) FROM Goods g WHERE g.categorySecond.scid=?";
		// ִ��getHibernateTemplate��find��������hql���Ͷ���������������룬�÷������ص���List���͵�����
		List<Long> countlist = this.getHibernateTemplate().find(hql, scid);
		// ���countlist��Ϊ�գ�����һ������ȡ������ת����int����

		if (countlist != null) {
			return countlist.get(0).intValue();
		}
		return 0;
	}

	/**
	 * Dao��ʵ�� ���ݶ�������͵�ǰҳ�Ĳ�������ѯ���ж��������µ���Ʒ������ҳ��ʾ
	 * 
	 * @param scid
	 *            �������������
	 * @param currentPage
	 *            ��ǰҳ
	 * @return
	 */

	public List<Goods> findGoodsByScid(Integer scid, int startIndex,
			int pageSize) {
		// ����Ԫ�ش���Ʒ���и��ݶ��������������ѯ��Ʒ����
		String hql = "select g from Goods g join g.categorySecond  cs where cs.scid=?";
		List<Goods> glist = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, new Object[] { scid },
						startIndex, pageSize));
		return glist;
	}

	/**
	 * ����һ�������������ѯ����һ����������Ʒ���ܼ�¼��
	 * 
	 * @param cid
	 * @return
	 */
	public int findCountByCid(Integer cid) {
		// ����һ�������������ѯһ����������Ʒ����������Ϊ��Щ��Ĺ�ϵhql�������д
		String hql = "select count(*) from Goods g where g.categorySecond.category.cid=?";
		// ִ��hql��䣬����������List��Long����
		List<Long> countlist = this.getHibernateTemplate().find(hql, cid);
		if (countlist != null) {
			// �Ӽ�����ȡ������ת����int����
			return countlist.get(0).intValue();
		}
		return 0;
	}

	/**
	 * �־ò� ����һ�������������ѯ�÷��������е���Ʒ
	 * 
	 * @param cid
	 *            һ�����������
	 * @param ÿһҳ�ĵ�һ�������Ǽ�startIndex
	 * @param ÿҳ��ʾ����������
	 *            pageSize
	 * @return
	 */
	public List<Goods> findGoodsByCid(Integer cid, int startIndex, int pageSize) {
		// ����ѯ
		String hql = "select g from Goods g join g.categorySecond cs join cs.category c where c.cid=? ";
		// ����execute������������ʵ����HibernateCallBack�ӿڵ��࣬���洫���ĸ�����������List����
		List<Goods> glist = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, new Object[] { cid },
						startIndex, pageSize));
		// ���������
		return glist;
	}

	/**
	 * ��ҳ����ʾ20��������Ʒ
	 * 
	 * @param cid
	 * @return
	 */
	public List<Goods> findHotGoods() {
		// �Ȼ�ȡ��Ʒ��
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
		// ��Ӳ�ѯ�����Ǳ��е�is_hot=1����Щ��Ʒ
		criteria.add(Restrictions.eq("is_hot", 1));
		// ÿҳ���ö�����Ʒ��
		List<Goods> hlist = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 20);
		return hlist;
	}

	/**
	 * ��ѯ�����ϼ���Ʒ
	 * 
	 * @return
	 */
	public List<Goods> findNewGoods() {
		// ʹ�����߲�ѯ,�Ȳ�ѯ����Ʒ��
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
		// ��Ӹ�����������������
		criteria.addOrder(Order.desc("gdate"));
		// ����getHibernateTemplate��findByCriteria����������Ʒ����,����ÿҳ��ʾ20����Ʒ��
		List<Goods> nlist = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 20);
		return nlist;
	}

	/**
	 * ==========��̨��ѯ������Ʒ��¼��
	 * 
	 * @return
	 */
	public int findCountAdminGoods() {
		// ��ѯ��Ʒ�����������
		String hql = "select count(*) from Goods";
		// ִ�в�ѯ���
		List<Long> list = this.getHibernateTemplate().find(hql);
		// ���ȡ�����ݵĻ�����list�е��±�ֵΪ0�����ݼ�ΪҪȡ��
		if (list != null) {
			// ��Long��ת��Ϊint����
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * =============��̨����ѯ������Ʒ������ҳ�ķ���
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Goods> findAllAdminGoods(int startIndex, int pageSize) {
		String hql = "from Goods";
		// ����execute��������ʵ�����ҳ��
		List<Goods> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, null, startIndex, pageSize));
		// ����ѯ���������ݷ���
		return list;
	}

	/**
	 * ��̨������Ʒ
	 * 
	 * @param goods
	 * @return
	 */
	public boolean save(Goods goods) {
		this.getHibernateTemplate().save(goods);
		return true;
	}

	/**
	 * ��̨ɾ����Ʒ��Dao��
	 * 
	 * @param goods
	 * @return
	 */
	public boolean delete(Goods goods) {
		this.getHibernateTemplate().delete(goods);
		return true;
	}

	/**
	 * ��̨�޸���Ʒ�ķ���
	 * 
	 * @param goods
	 * @return
	 */
	public boolean update(Goods goods) {
		this.getHibernateTemplate().update(goods);
		return true;
	}

	/**
	 * ģ����ѯ����
	 * 
	 * @param searchName
	 * @return
	 */
	public int findGoodsByName(String searchName) {
		String hql = "select count(*) from Goods g where g.gname like '%"
				+ searchName + "%'";
		System.out.println(hql);
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null) {
			list.get(0).intValue();
		}
		System.out.println(list.get(0).intValue());
		return 0;
	}

	/**
	 * ģ����ѯ
	 * 
	 * @param searchName
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Goods> findGoodsByName(String searchName, int startIndex,
			int pageSize) {
		String hql = "from Goods g where g.gname like '%" + searchName + "%'";
		System.out.println(hql);
		List<Goods> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, null, startIndex, pageSize));
		return list;
	}

}
