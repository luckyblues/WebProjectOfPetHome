package cn.pethome.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pethome.user.dao.UserDao;
import cn.pethome.user.domain.User;
import cn.pethome.util.PageBean;

@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 按用户名查询用户的方法
	public User findByUname(String uname) {
		return userDao.findByUname(uname);
	}

	// 用户注册
	public void save(User user) {
		// 将数据存入到数据库
		user.setUid(0);// 待解决问题
		userDao.save(user);

	}

	// 用户登录
	public User login(User user) {
		return (User) userDao.login(user);
	}

	/**
	 * ==========后台查询所有用户信息，并分页
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllUser(Integer currentPage) {
		// 封装PageBean对象
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
		// 封装数据
		int startIndex = (currentPage - 1) * pageSize;
		List<User> list = userDao.findAllUser(startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据用户id查询用户
	 * 
	 * @param uid
	 * 
	 * @return
	 */
	public User findByUid(Integer uid) {
		
		return userDao.findByUid(uid);
	}

}