package cn.pethome.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * 关于getHibernateTemplate的 api中的execute中有两个重载方法 Object execute(HibernateCallback
 * action) List execute(HibernateCallback action)
 * 都是用来分页显示的,其中的接口HibernateCallback需要去实现 这里面有封装的几个参数
 * 
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class PageCallBackImpl implements HibernateCallback {
	// 封装四个参数
	private String hql;// 当前的hql语句
	private Object[] params;// 需要传入的参数
	private Integer startIndex;// 当前页的第一条记录
	private Integer pageSize;// 当前页总共有多少条数据

	// 提供有参的构造函数

	public PageCallBackImpl(String hql, Object[] params, Integer startIndex, Integer pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	@Override
	public List doInHibernate(Session session) throws HibernateException, SQLException {
		// 根据Hibernate中的session调用其方法重载的方法createCriteria（String
		// value）执行hql，返回Query对象
		Query query = (Query) session.createCriteria(hql);

		// 如果参数不为空，说明查询出结果集，并遍历每个参数对应的对象，
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		// 设置第一条数据
		query.setFirstResult(startIndex);
		// 设置每页显示的最大数据数量
		query.setMaxResults(pageSize);
		// 返回查询到的结果集
		return query.list();
	}

}
