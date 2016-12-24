package cn.pethome.admin.service;

import java.util.List;

import cn.pethome.admin.dao.AdminDao;
import cn.pethome.admin.domain.Admin;
import cn.pethome.category.domain.Category;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageBean;

/**
 * 管理员的业务逻辑层
 * 
 * @author Administrator
 * 
 */
public class AdminService {
	/*
	 * 注入AdminDao，并提供set方法
	 */
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	/**
	 * 后台管理员登录的方法
	 * 
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin) {
		// 调用AdminDao里面的方法
		return adminDao.login(admin);
	}

	/**
	 * 根据管理员id查找管理员的对象
	 * 
	 * @param aid
	 * @return
	 */
	public Admin findAdmin(Integer aid) {
		return adminDao.findAdmin(aid); 
	}

	/**
	 * 保存新密码
	 * 
	 * @param admin
	 * @return
	 */
	public boolean update(Admin admin) {
		if (adminDao.update(admin)) {
			return true;
		} else {
			return false;
		}
	}

}
