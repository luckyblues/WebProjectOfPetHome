package cn.pethome.category.service;

import java.util.List;

import cn.pethome.category.dao.CategoryDao;
import cn.pethome.category.domain.Category;

/**
 * 一级分类的业务层
 * 
 * @author Administrator
 *
 */
public class CategoryService {
	/**
	 * 在CategoryService层注入CategoryDao层,并提供相应的set方法
	 */
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 调用categoryDao里面的方法
	 * @return
	 */
	public List<Category> findAllCategory() {
		List<Category> list=categoryDao.findAllCategory();
		return null;
	}
	

}
