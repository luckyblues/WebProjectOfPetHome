package cn.pethome.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pethome.category.dao.CategoryDao;
import cn.pethome.category.domain.Category;

/**
 * һ�������ҵ���
 * 
 * @author Administrator
 * 
 */
@Transactional
public class CategoryService {
	/**
	 * ��CategoryService��ע��CategoryDao��,���ṩ��Ӧ��set����
	 */
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * ǰ̨����categoryDao����ķ���
	 * 
	 * @return
	 */
	public List<Category> findAllCategory() {
		List<Category> list = categoryDao.findAllCategory();
		return list;
	}

	/**
	 * ��̨��ѯһ������
	 * 
	 * @return
	 */
	public List<Category> findAllAdminCategory() {

		return categoryDao.findAllCategory();
	}

	/**
	 * ��̨���һ������
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
	 * ����cid�ҵ���һ������
	 * 
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid) {

		return categoryDao.findByCid(cid);
	}

	/**
	 * ���ݲ鵽��һ�����࣬����ɾ��
	 * 
	 * @param category
	 * @return
	 */
	public boolean delete(Category category) {
		// ����Dao����ķ���
		if (categoryDao.delete(category)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��̨�޸�һ������
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
