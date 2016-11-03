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
 * 商品的持久层实现
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
	 * 根据商品的一级分类的主键查询热卖商品===================还没实现
	 * 
	 * @param cid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> findHotGoodsByScid(Integer cid) {
		String hql = "select g from Goods g join g.categorySecond cs join cs.category c where c.cid=?";

		// 使用离线查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
		// 添加约束条件，is_hot是否是热卖商品，1为热卖，0为非热卖
		criteria.add(Restrictions.eq("is_hot", 1));
		// 条件约束条件，根据新上架的日期，最新上架的日期放在最前面
		criteria.addOrder(Order.desc("gdate"));
		// 根据二级分类的主键查询十条商品记录
		List<Goods> hlist = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return hlist;
	}

	/**
	 * 根据商品主键查找具体商品的实现
	 * 
	 * @param gid
	 * @return
	 */
	public Goods findDetailGoods(Integer gid) {
		return this.getHibernateTemplate().get(Goods.class, gid);
	}

	/**
	 * Dao实现 查询点击的二级分类下的商品记录总数
	 * 
	 * @param scid
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int findGoodsCount(Integer scid) {

		// hql语句，查询某二级分类下的所有商品记录数
		String hql = "SELECT COUNT(*) FROM Goods g WHERE g.categorySecond=?";
		// 执行getHibernateTemplate的find方法，将hql语句和二级分类的主键传入，该方法返回的是List类型的数据
		List<Long> countlist = this.getHibernateTemplate().find(hql, scid);
		// 如果countlist不为空，将第一个对象取出，并转换成int类型

		if (countlist != null) {
			return countlist.get(0).intValue();
		}
		return 0;
	}

	/**
	 * Dao层实现 根据二级分类和当前页的参数，查询所有二级分类下的商品，并分页显示
	 * 
	 * @param scid
	 *            二级分类的主键
	 * @param currentPage
	 *            当前页
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<Goods> findGoodsByScid(Integer scid, int startIndex, int pageSize) {
		// 外联元素从商品类中根据二级分类的主键查询商品集合
		String hql = "select g from Goods g join g.categorySecond  cs where cs.scid=?";
		List<Goods> glist = (List<Goods>) this.getHibernateTemplate()
				.execute(new PageCallBackImpl(hql, new Object[] { scid }, startIndex, pageSize));
		return glist;
	}

}
