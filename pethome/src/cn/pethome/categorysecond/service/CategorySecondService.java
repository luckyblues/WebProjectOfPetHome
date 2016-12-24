package cn.pethome.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pethome.categorysecond.dao.CategorySecondDao;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageBean;

/**
 * 二级分类的业务逻辑层
 * 
 * @author Administrator
 * 
 */

public class CategorySecondService {
	/*
	 * 注入二级分类的Dao层
	 */
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	/**
	 * 后台查询二级分类的方法
	 * 
	 * @param currentPage
	 * 
	 * @return
	 */
	public PageBean findAllCategorySecond(Integer currentPage) {
		// 创建PAgeBean对象，并封装相应的属性
		PageBean pageBean = new PageBean();
		// 封装当前页属性
		pageBean.setCurrentPage(currentPage);
		int pageSize = 6;
		// 每页显示十条数据
		pageBean.setPageSize(pageSize);
		// 设置总共有多少条数据
		int totalCount = categorySecondDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置当前页的第一条数据是第多少条数据
		int startIndex = (currentPage - 1) * pageSize;
		// 设置pageBean中List中的二级分类数据
		List<CategorySecond> list = categorySecondDao.findAllCategorySecond(
				startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 后台根据二级分类id找到该二级分类的对象，
	 * 
	 * @param scid
	 * @return
	 */
	public CategorySecond findByScid(Integer scid) {
		return categorySecondDao.findByScid(scid);
	}

	/**
	 * 根据二级分类对象删除该二级分类
	 * 
	 * @param categorySecond
	 * @return
	 */
	public boolean delete(CategorySecond categorySecond) {
		if (categorySecondDao.delete(categorySecond)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 保存二级分类
	 * 
	 * @param categorySecond
	 * @return
	 */
	public boolean save(CategorySecond categorySecond) {
		if (categorySecondDao.save(categorySecond)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 进行修改二级分类
	 * 
	 * @param categorySecond
	 * @return
	 */
	public boolean update(CategorySecond categorySecond) {
		// 调用Dao中放入方法进行修改
		if (categorySecondDao.update(categorySecond)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 3 后台查找所有的二级分类
	 * 
	 * @return
	 */
	public List<CategorySecond> findAll() {

		return categorySecondDao.findAll();
	}

}
