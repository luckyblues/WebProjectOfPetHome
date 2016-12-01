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
	 */
	public void save(Category category) {
		categoryDao.save(category);
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
	 */
	public void delete(Category category) {
		// ����Dao����ķ���
		categoryDao.delete(category);
	}

	/**
	 * ��̨�޸�һ������
	 * 
	 * @param category
	 * @return
	 */
	public void update(Category category) {
		categoryDao.update(category);
	}

}
