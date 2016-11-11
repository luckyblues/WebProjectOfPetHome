package cn.pethome.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import cn.pethome.category.domain.Category;

/**
 * һ������ĳ־ò�
 * 
 * @author Administrator
 *
 */
public class CategoryDao extends HibernateDaoSupport {

	/**
	 * ��дhql��䣬������this.getHibernateTemplate().find(hql);
	 * 
	 * @return
	 */
	public List<Category> findAllCategory() {
		String hql = "from Category";
		List<Category> clist = this.getHibernateTemplate().find(hql);
		return clist;

	}
	/**
	 * ��CategoryDao�̳�HibernateDaoSupport,����Spring��Category�־ò���ע��sessionFactory
	 */

}
