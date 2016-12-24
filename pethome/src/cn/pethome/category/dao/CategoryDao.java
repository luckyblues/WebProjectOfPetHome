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
	 * ��̨��ѯ����һ������
	 * 
	 * @return
	 */
	public List<Category> findAllAdminCategory() {
		String hql = "from Category";
		// ����list����
		List<Category> lists = this.getHibernateTemplate().find(hql);
		return lists;
	}

	/**
	 * ��̨���һ������
	 * 
	 * @param category
	 * @return
	 */
	public boolean save(Category category) {
		this.getHibernateTemplate().save(category);
		return true;
	}

	/**
	 * ����cid��ѯ����һ������
	 * 
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid) {
		// ����get��������һ��������࣬��id
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	/**
	 * ɾ��һ������
	 * 
	 * @param category
	 * @return
	 */
	public boolean delete(Category category) {
		this.getHibernateTemplate().delete(category);
		return true;
	}

	/**
	 * ��̨�޸�һ������dao��ʵ��
	 * 
	 * @param category
	 * @return
	 */
	public boolean update(Category category) {
		this.getHibernateTemplate().update(category);
		return true;
	}

}
