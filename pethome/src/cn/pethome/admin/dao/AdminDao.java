package cn.pethome.admin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.admin.domain.Admin;
import cn.pethome.category.domain.Category;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageCallBackImpl;

/**
 * ����Ա�ĳ־ò�
 * 
 * @author Administrator
 *
 */
public class AdminDao extends HibernateDaoSupport {
	/**
	 * ��̨����Ա��¼�ķ���
	 * 
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin) {
		// hql���
		String hql = "from Admin where aname=? and apwd=?";
		// ��hql����Լ������ռλ��������getHibernateTemplate��find������ִ��
		List<Admin> list = this.getHibernateTemplate().find(hql, admin.getAname(), admin.getApwd());
		// �ж�list�Ƿ���ֵ
		if (list != null && list.size() > 0) {
			// ����еĻ���ȡ��������
			return list.get(0);
		}
		return null;
	}

}
