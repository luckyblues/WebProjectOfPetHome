package cn.pethome.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import cn.pethome.category.domain.Category;

/**
 * 一级分类的持久层
 * 
 * @author Administrator
 *
 */
public class CategoryDao extends HibernateDaoSupport {

	/**
	 * 书写hql语句，并调用this.getHibernateTemplate().find(hql);
	 * 
	 * @return
	 */
	public List<Category> findAllCategory() {
		String hql = "from Category";
		List<Category> clist = this.getHibernateTemplate().find(hql);
		return clist;

	}

	/**
	 * 后台查询所有一级分类
	 * 
	 * @return
	 */
	public List<Category> findAllAdminCategory() {
		String hql = "from Category";
		// 返回list类型
		List<Category> lists = this.getHibernateTemplate().find(hql);
		return lists;
	}

	/**
	 * 后台添加一级分类
	 * 
	 * @param category
	 * @return
	 */
	public Object save(Category category) {
		return this.getHibernateTemplate().save(category);
	}

	/**
	 * 根据cid查询出该一级分类
	 * 
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid) {
		// 根据get方法传入一级分类的类，和id
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	/**
	 * 删除一级分类
	 * 
	 * @param category
	 */
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	/**
	 * 后台修改一级分类dao层实现
	 * 
	 * @param category
	 * @return
	 */
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
