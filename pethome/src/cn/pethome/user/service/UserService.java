package cn.pethome.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pethome.user.dao.UserDao;
import cn.pethome.user.domain.User;
import cn.pethome.util.PageBean;

@Transactional
public class UserService {
	// ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// ���û�����ѯ�û��ķ���
	public User findByUname(String uname) {
		return userDao.findByUname(uname);
	}

	// �û�ע��
	public void save(User user) {
		// �����ݴ��뵽���ݿ�
		user.setUid(0);// ���������
		userDao.save(user);

	}

	// �û���¼
	public User login(User user) {
		return (User) userDao.login(user);
	}

	/**
	 * ==========��̨��ѯ�����û���Ϣ������ҳ
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllUser(Integer currentPage) {
		// ��װPageBean����
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ��װ����
		int startIndex = (currentPage - 1) * pageSize;
		List<User> list = userDao.findAllUser(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * �����û�id��ѯ�û�
	 * 
	 * @param uid
	 * 
	 * @return
	 */
	public User findByUid(Integer uid) {
		
		return userDao.findByUid(uid);
	}

}