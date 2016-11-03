package cn.pethome.goods.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.goods.domain.Goods;
import cn.pethome.util.PageCallBackImpl;

/**
 * ��Ʒ�ĳ־ò�ʵ��
 * 
 * @author Administrator
 *
 */

public class GoodsDao extends HibernateDaoSupport implements ModelDriven<Goods> {

	@Override
	public Goods getModel() {
		return null;
	}

	/**
	 * ������Ʒ��һ�������������ѯ������Ʒ===================��ûʵ��
	 * 
	 * @param cid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> findHotGoodsByScid(Integer cid) {
		String hql = "select g from Goods g join g.categorySecond cs join cs.category c where c.cid=?";

		// ʹ�����߲�ѯ����
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
		// ���Լ��������is_hot�Ƿ���������Ʒ��1Ϊ������0Ϊ������
		criteria.add(Restrictions.eq("is_hot", 1));
		// ����Լ���������������ϼܵ����ڣ������ϼܵ����ڷ�����ǰ��
		criteria.addOrder(Order.desc("gdate"));
		// ���ݶ��������������ѯʮ����Ʒ��¼
		List<Goods> hlist = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return hlist;
	}

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
	@SuppressWarnings("unchecked")
	public int findGoodsCount(Integer scid) {

		// hql��䣬��ѯĳ���������µ�������Ʒ��¼��
		String hql = "SELECT COUNT(*) FROM Goods g WHERE g.categorySecond=?";
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

	@SuppressWarnings("unchecked")
	public List<Goods> findGoodsByScid(Integer scid, int startIndex, int pageSize) {
		// ����Ԫ�ش���Ʒ���и��ݶ��������������ѯ��Ʒ����
		String hql = "select g from Goods g join g.categorySecond  cs where cs.scid=?";
		List<Goods> glist = (List<Goods>) this.getHibernateTemplate()
				.execute(new PageCallBackImpl(hql, new Object[] { scid }, startIndex, pageSize));
		return glist;
	}

}
