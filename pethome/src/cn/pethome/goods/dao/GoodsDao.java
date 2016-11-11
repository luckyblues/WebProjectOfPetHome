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
 * 商品的持久层实现 实现模型驱动
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
		String hql = "SELECT COUNT(*) FROM Goods g WHERE g.categorySecond.scid=?";
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

	/**
	 * 根据一级分类的主键查询所有一级分类下商品的总记录数
	 * 
	 * @param cid
	 * @return
	 */
	public int findCountByCid(Integer cid) {
		// 根据一级分类的主键查询一级分类下商品的总数量因为这些表的关系hql语句这样写
		String hql = "select count(*) from Goods g where g.categorySecond.category.cid=?";
		// 执行hql语句，返回类型是List的Long类型
		List<Long> countlist = this.getHibernateTemplate().find(hql, cid);
		if (countlist != null) {
			// 从集合中取出，并转换成int类型
			return countlist.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 持久层 根据一级分类的主键查询该分类下所有的商品
	 * 
	 * @param cid
	 *            一级分类的主键
	 * @param 每一页的第一条数据是几startIndex
	 * @param 每页显示多少条数据
	 *            pageSize
	 * @return
	 */
	public List<Goods> findGoodsByCid(Integer cid, int startIndex, int pageSize) {
		// 多表查询
		String hql = "select g from Goods g join g.categorySecond cs join cs.category c where c.cid=? ";
		// 调用execute方法，并调用实现了HibernateCallBack接口的类，里面传入四个参数，返回List类型
		List<Goods> glist = this.getHibernateTemplate()
				.execute(new PageCallBackImpl<>(hql, new Object[] { cid }, startIndex, pageSize));
		// 将结果返回
		return glist;
	}

	/*
	 * 查询商品热卖的记录
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
	 * 根据商品的一级分类的主键查询热卖商品===================还没实现
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
