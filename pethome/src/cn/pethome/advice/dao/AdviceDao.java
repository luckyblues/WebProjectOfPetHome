package cn.pethome.advice.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.advice.domain.Advice;

public class AdviceDao extends HibernateDaoSupport {

	/**
	 * ���潨��
	 * 
	 * @param advice
	 * @return
	 */
	public boolean save(Advice advice) {
		this.getHibernateTemplate().save(advice);
		return true;

	}

	/**
	 * ��̨��ѯ�����б�
	 * 
	 * @return
	 */
	public List<Advice> findAdvice() {
		String hql = "from Advice";
		List<Advice> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * ��̨�鿴��������
	 * 
	 * @param aid
	 * @return
	 */
	public Advice findDeatilAdvice(Integer aid) {
		return this.getHibernateTemplate().get(Advice.class, aid);
	}

}
