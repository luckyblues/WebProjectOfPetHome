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
	 * 在CategoryDao继承HibernateDaoSupport,并在Spring的Category持久层中注入sessionFactory
	 */

}
