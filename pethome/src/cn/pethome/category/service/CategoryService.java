package cn.pethome.category.service;

import java.util.List;

import cn.pethome.category.dao.CategoryDao;
import cn.pethome.category.domain.Category;

/**
 * һ�������ҵ���
 * 
 * @author Administrator
 *
 */
public class CategoryService {
	/**
	 * ��CategoryService��ע��CategoryDao��,���ṩ��Ӧ��set����
	 */
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * ����categoryDao����ķ���
	 * @return
	 */
	public List<Category> findAllCategory() {
		List<Category> list=categoryDao.findAllCategory();
		return null;
	}
	

}
