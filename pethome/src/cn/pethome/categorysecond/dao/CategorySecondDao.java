package cn.pethome.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageCallBackImpl;

public class CategorySecondDao extends HibernateDaoSupport {

	/**
	 * 后台二级分类的总记录数查询
	 * 
	 * @return
	 */
	public int findAllCount() {
		String hql = "select count(*) from CategorySecond";
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
	 * 后台查询二级分类集合并分页
	 * 
	 * @param pageSize
	 * @param startIndex
	 * 
	 * @return
	 */

	public List<CategorySecond> findAllCategorySecond(int startIndex,
			int pageSize) {
		String hql = "from CategorySecond order by scid asc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<CategorySecond>(hql, null, startIndex,
						pageSize));
		return list;
	}

	/**
	 * 后台根据二级分类id找到二级分类
	 * 
	 * @param scid
	 * @return
	 */
	public CategorySecond findByScid(Integer scid) {
		return this.getHibernateTemplate().get(CategorySecond.class, scid);
	}

	/**
	 * 后台删除二级分类方法
	 * 
	 * @param categorySecond
	 * @return
	 */
	public boolean delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
		return true;
	}

	/**
	 * 添加二级分类
	 * 
	 * @param categorySecond
	 * @return
	 */
	public boolean save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
		return true;
	}

	/**
	 * Dao中进行二级分类的修改
	 * 
	 * @param categorySecond
	 * @return
	 */
	public boolean update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
		return true;
	}

	/**
	 * 后台查询所有的二级分类
	 * 
	 * @return
	 */
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}
}
