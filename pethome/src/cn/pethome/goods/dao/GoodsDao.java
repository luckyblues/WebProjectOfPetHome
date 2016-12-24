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
 * 商品的持久层实现 实现模型驱动
 * 
 * @author Administrator
 * 
 */

public class GoodsDao extends HibernateDaoSupport {

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

	public List<Goods> findGoodsByScid(Integer scid, int startIndex,
			int pageSize) {
		// 外联元素从商品类中根据二级分类的主键查询商品集合
		String hql = "select g from Goods g join g.categorySecond  cs where cs.scid=?";
		List<Goods> glist = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, new Object[] { scid },
						startIndex, pageSize));
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
		List<Goods> glist = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, new Object[] { cid },
						startIndex, pageSize));
		// 将结果返回
		return glist;
	}

	/**
	 * 首页上显示20条热卖商品
	 * 
	 * @param cid
	 * @return
	 */
	public List<Goods> findHotGoods() {
		// 先获取商品类
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
		// 添加查询条件是表中的is_hot=1的那些商品
		criteria.add(Restrictions.eq("is_hot", 1));
		// 每页设置多少商品数
		List<Goods> hlist = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 20);
		return hlist;
	}

	/**
	 * 查询最新上架商品
	 * 
	 * @return
	 */
	public List<Goods> findNewGoods() {
		// 使用离线查询,先查询出商品类
		DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
		// 添加附加条件，根据日期
		criteria.addOrder(Order.desc("gdate"));
		// 调用getHibernateTemplate的findByCriteria方法返回商品集合,并且每页显示20条商品数
		List<Goods> nlist = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 20);
		return nlist;
	}

	/**
	 * ==========后台查询所有商品记录数
	 * 
	 * @return
	 */
	public int findCountAdminGoods() {
		// 查询商品的数量的语句
		String hql = "select count(*) from Goods";
		// 执行查询语句
		List<Long> list = this.getHibernateTemplate().find(hql);
		// 如果取出数据的话，则list中的下标值为0的数据即为要取的
		if (list != null) {
			// 将Long型转换为int类型
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * =============后台，查询所有商品，并分页的方法
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Goods> findAllAdminGoods(int startIndex, int pageSize) {
		String hql = "from Goods";
		// 调用execute方法，并实现类分页类
		List<Goods> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Goods>(hql, null, startIndex, pageSize));
		// 将查询出来的数据返回
		return list;
	}

	/**
	 * 后台保存商品
	 * 
	 * @param goods
	 * @return
	 */
	public boolean save(Goods goods) {
		this.getHibernateTemplate().save(goods);
		return true;
	}

	/**
	 * 后台删除商品的Dao层
	 * 
	 * @param goods
	 * @return
	 */
	public boolean delete(Goods goods) {
		this.getHibernateTemplate().delete(goods);
		return true;
	}

	/**
	 * 后台修改商品的方法
	 * 
	 * @param goods
	 * @return
	 */
	public boolean update(Goods goods) {
		this.getHibernateTemplate().update(goods);
		return true;
	}

	/**
	 * 模糊查询数量
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
	 * 模糊查询
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
