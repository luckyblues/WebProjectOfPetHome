package cn.pethome.admin.service;

import java.util.List;

import cn.pethome.admin.dao.AdminDao;
import cn.pethome.admin.domain.Admin;
import cn.pethome.category.domain.Category;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageBean;

/**
 * ����Ա��ҵ���߼���
 * 
 * @author Administrator
 * 
 */
public class AdminService {
	/*
	 * ע��AdminDao�����ṩset����
	 */
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	/**
	 * ��̨����Ա��¼�ķ���
	 * 
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin) {
		// ����AdminDao����ķ���
		return adminDao.login(admin);
	}

	/**
	 * ���ݹ���Աid���ҹ���Ա�Ķ���
	 * 
	 * @param aid
	 * @return
	 */
	public Admin findAdmin(Integer aid) {
		return adminDao.findAdmin(aid); 
	}

	/**
	 * ����������
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
