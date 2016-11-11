package cn.pethome.goods.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.goods.domain.Goods;
import cn.pethome.util.PageBean;
import cn.pethome.util.PageCallBackImpl;

/**
 * ��Ʒ�ĳ־ò�ʵ�� ʵ��ģ������
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

	@SuppressWarnings("unchecked")
	public List<Goods> findGoodsByScid(Integer scid, int startIndex, int pageSize) {
		// ����Ԫ�ش���Ʒ���и��ݶ��������������ѯ��Ʒ����
		String hql = "select g from Goods g join g.categorySecond  cs where cs.scid=?";
		List<Goods> glist = (List<Goods>) this.getHibernateTemplate()
				.execute(new PageCallBackImpl(hql, new Object[] { scid }, startIndex, pageSize));
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
		List<Goods> glist = this.getHibernateTemplate()
				.execute(new PageCallBackImpl<>(hql, new Object[] { cid }, startIndex, pageSize));
		// ���������
		return glist;
	}

	/*
	 * ��ѯ��Ʒ�����ļ�¼
	 * 
	 */
	public int findHotGoodsCount(Integer scid) {
		String hql = "select count(*) from Goods g where g.categorySecond.scid=? and g.is_hot=1";
		List<Long> hotlist = this.getHibernateTemplate().find(hql, scid);
		if (hotlist != null) {
			return hotlist.get(0).intValue();
		}
		return 0;
	}

	/**
	 * ������Ʒ��һ�������������ѯ������Ʒ===================��ûʵ��
	 * 
	 * @param cid
	 * @return
	 */
	public List<Goods> findHotGoodsByScid(Integer scid, int startIndex, int pageSize) {
		String hql = "select g from Goods g join g.categorySecond cs where cs.scid=? and g.is_hot=1";
		List<Goods> hlist = this.getHibernateTemplate()
				.execute(new PageCallBackImpl<>(hql, new Object[] { scid }, startIndex, pageSize));
		return hlist;
	}

}
