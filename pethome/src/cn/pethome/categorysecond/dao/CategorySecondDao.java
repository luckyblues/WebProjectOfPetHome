package cn.pethome.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.util.PageCallBackImpl;

public class CategorySecondDao extends HibernateDaoSupport {

	/**
	 * ��̨����������ܼ�¼����ѯ
	 * 
	 * @return
	 */
	public int findAllCount() {
		String hql = "select count(*) from CategorySecond";
		// ����find����������List����
		List<Long> list = this.getHibernateTemplate().find(hql);
		// ������ϲ�Ϊ�յĻ���˵����ѯ�����ܼ�¼������ȡ���ü����е��±�ֵΪ0�ĵ�һ��ֵ
		if (list != null) {
			// ȡ����һ��ֵ����ת��Ϊint��
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * ��̨��ѯ�������༯�ϲ���ҳ
	 * 
	 * @param pageSize
	 * @param startIndex
	 * 
	 * @return
	 */

	public List<CategorySecond> findfindAllCategorySecond(int startIndex, int pageSize) {
		String hql = "from CategorySecond order by scid asc";
		List<CategorySecond> list = this.getHibernateTemplate()
				.execute(new PageCallBackImpl<>(hql, null, startIndex, pageSize));
		return list;
	}

	/**
	 * ��̨���ݶ�������id�ҵ���������
	 * 
	 * @param scid
	 * @return
	 */
	public CategorySecond findByScid(Integer scid) {
		return this.getHibernateTemplate().get(CategorySecond.class, scid);
	}

	/**
	 * ��̨ɾ���������෽��
	 * 
	 * @param categorySecond
	 */
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	/**
	 * ��Ӷ�������
	 * 
	 * @param categorySecond
	 */
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	/**
	 * Dao�н��ж���������޸�
	 * 
	 * @param categorySecond
	 */
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	/**
	 * ��̨��ѯ���еĶ�������
	 * 
	 * @return
	 */
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}
}
