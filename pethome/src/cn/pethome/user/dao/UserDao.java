package cn.pethome.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.user.domain.User;
import cn.pethome.util.PageCallBackImpl;

//持久层
public class UserDao extends HibernateDaoSupport {
	// 按名称查询是否有该用户
	public User findByUname(String uname) {
		String hql = "from User where uname=?";
		List<User> list = this.getHibernateTemplate().find(hql, uname);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void save(User user) {
		this.getHibernateTemplate().save(user);

	}

	// 用户登录
	public User login(User user) {
		String hql = "from User where uname = ? and upwd = ?";
		List<User> list = this.getHibernateTemplate().find(hql, user.getUname(), user.getUpwd());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 后台查询所有的用户个数
	 * 
	 * @return
	 */
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			// 如果取出的值不为空即有值的话，就将其中的下标值为0的第一个Long类型数据取出，并转化为int类型
			list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * ======后台查询用户，并分页
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<User> findAllUser(int startIndex, int pageSize) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(new PageCallBackImpl<>(hql, null, startIndex, pageSize));
		return list;
	}

	/**
	 * 根据用户id查询用户对象
	 * 
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}
}
