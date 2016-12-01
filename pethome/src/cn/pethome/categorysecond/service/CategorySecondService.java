package cn.pethome.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pethome.categorysecond.dao.CategorySecondDao;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageBean;

/**
 * ���������ҵ���߼���
 * 
 * @author Administrator
 *
 */

public class CategorySecondService {
	/*
	 * ע����������Dao��
	 */
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	/**
	 * ��̨��ѯ��������ķ���
	 * 
	 * @param currentPage
	 * 
	 * @return
	 */
	public PageBean findAllCategorySecond(Integer currentPage) {
		// ����PAgeBean���󣬲���װ��Ӧ������
		PageBean pageBean = new PageBean();
		// ��װ��ǰҳ����
		pageBean.setCurrentPage(currentPage);
		int pageSize = 8;
		// ÿҳ��ʾʮ������
		pageBean.setPageSize(pageSize);
		// �����ܹ��ж���������
		int totalCount = categorySecondDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ���õ�ǰҳ�ĵ�һ�������ǵڶ���������
		int startIndex = (currentPage - 1) * pageSize;
		// ����pageBean��List�еĶ�����������
		List<CategorySecond> list = categorySecondDao.findfindAllCategorySecond(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ��̨genuine��������id�ҵ��ö���
	 * 
	 * @param scid
	 * @return
	 */
	public CategorySecond findByScid(Integer scid) {
		return categorySecondDao.findByScid(scid);
	}

	/**
	 * ���ݸո��ҵ��Ķ�������ɾ���ö�������
	 * 
	 * @param categorySecond
	 */
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	/**
	 * �����������
	 * 
	 * @param categorySecond
	 */
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	/**
	 * �����޸Ķ�������
	 * 
	 * @param categorySecond
	 */
	public void update(CategorySecond categorySecond) {
		// ����Dao�з��뷽�������޸�
		categorySecondDao.update(categorySecond);
	}

	/**
	 * ��̨�������еĶ�������
	 * 
	 * @return
	 */
	public List<CategorySecond> findAll() {
		
		return categorySecondDao.findAll();
	}

}
