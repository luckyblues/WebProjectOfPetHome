package cn.pethome.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * ����getHibernateTemplate�� api�е�execute�����������ط��� Object execute(HibernateCallback
 * action) List execute(HibernateCallback action)
 * ����������ҳ��ʾ��,���еĽӿ�HibernateCallback��Ҫȥʵ�� �������з�װ�ļ�������
 * 
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class PageCallBackImpl implements HibernateCallback {
	// ��װ�ĸ�����
	private String hql;// ��ǰ��hql���
	private Object[] params;// ��Ҫ����Ĳ���
	private Integer startIndex;// ��ǰҳ�ĵ�һ����¼
	private Integer pageSize;// ��ǰҳ�ܹ��ж���������

	// �ṩ�вεĹ��캯��

	public PageCallBackImpl(String hql, Object[] params, Integer startIndex, Integer pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	@Override
	public List doInHibernate(Session session) throws HibernateException, SQLException {
		// ����Hibernate�е�session�����䷽�����صķ���createCriteria��String
		// value��ִ��hql������Query����
		Query query = (Query) session.createCriteria(hql);

		// ���������Ϊ�գ�˵����ѯ���������������ÿ��������Ӧ�Ķ���
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		// ���õ�һ������
		query.setFirstResult(startIndex);
		// ����ÿҳ��ʾ�������������
		query.setMaxResults(pageSize);
		// ���ز�ѯ���Ľ����
		return query.list();
	}

}
