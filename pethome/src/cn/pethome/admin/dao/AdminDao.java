package cn.pethome.admin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.admin.domain.Admin;
import cn.pethome.category.domain.Category;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageCallBackImpl;

/**
 * 管理员的持久层
 * 
 * @author Administrator
 *
 */
public class AdminDao extends HibernateDaoSupport {
	/**
	 * 后台管理员登录的方法
	 * 
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin) {
		// hql语句
		String hql = "from Admin where aname=? and apwd=?";
		// 将hql语句以及里面的占位符，传入getHibernateTemplate的find方法中执行
		List<Admin> list = this.getHibernateTemplate().find(hql, admin.getAname(), admin.getApwd());
		// 判断list是否有值
		if (list != null && list.size() > 0) {
			// 如果有的话就取出并返回
			return list.get(0);
		}
		return null;
	}

}
