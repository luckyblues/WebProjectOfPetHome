package cn.pethome.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pethome.category.dao.CategoryDao;
import cn.pethome.category.domain.Category;

/**
 * 一级分类的业务层
 * 
 * @author Administrator
 * 
 */
@Transactional
public class CategoryService {
	/**
	 * 在CategoryService层注入CategoryDao层,并提供相应的set方法
	 */
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 前台调用categoryDao里面的方法
	 * 
	 * @return
	 */
	public List<Category> findAllCategory() {
		List<Category> list = categoryDao.findAllCategory();
		return list;
	}

	/**
	 * 后台查询一级分类
	 * 
	 * @return
	 */
	public List<Category> findAllAdminCategory() {

		return categoryDao.findAllCategory();
	}

	/**
	 * 后台添加一级分类
	 * 
	 * @param category
	 * @return
	 */
	public boolean save(Category category) {
		if (categoryDao.save(category)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据cid找到该一级分类
	 * 
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid) {

		return categoryDao.findByCid(cid);
	}

	/**
	 * 根据查到的一级分类，将其删除
	 * 
	 * @param category
	 * @return
	 */
	public boolean delete(Category category) {
		// 调用Dao里面的方法
		if (categoryDao.delete(category)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 后台修改一级分类
	 * 
	 * @param category
	 * @return
	 */
	public boolean update(Category category) {
		if (categoryDao.update(category)) {
			return true;
		} else {
			return false;
		}
	}

}
