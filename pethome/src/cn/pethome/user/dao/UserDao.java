package cn.pethome.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.user.domain.User;
import cn.pethome.util.PageCallBackImpl;

//�־ò�
public class UserDao extends HibernateDaoSupport {
	// �����Ʋ�ѯ�Ƿ��и��û�
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

	// �û���¼
	public User login(User user) {
		String hql = "from User where uname = ? and upwd = ?";
		List<User> list = this.getHibernateTemplate().find(hql, user.getUname(), user.getUpwd());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * ��̨��ѯ���е��û�����
	 * 
	 * @return
	 */
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			// ���ȡ����ֵ��Ϊ�ռ���ֵ�Ļ����ͽ����е��±�ֵΪ0�ĵ�һ��Long��������ȡ������ת��Ϊint����
			list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * ======��̨��ѯ�û�������ҳ
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
	 * �����û�id��ѯ�û�����
	 * 
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}
}
