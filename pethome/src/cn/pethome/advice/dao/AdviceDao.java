package cn.pethome.advice.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.advice.domain.Advice;

public class AdviceDao extends HibernateDaoSupport {

	/**
	 * 保存建议
	 * 
	 * @param advice
	 * @return
	 */
	public boolean save(Advice advice) {
		this.getHibernateTemplate().save(advice);
		return true;

	}

	/**
	 * 后台查询建议列表
	 * 
	 * @return
	 */
	public List<Advice> findAdvice() {
		String hql = "from Advice";
		List<Advice> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 后台查看建议详情
	 * 
	 * @param aid
	 * @return
	 */
	public Advice findDeatilAdvice(Integer aid) {
		return this.getHibernateTemplate().get(Advice.class, aid);
	}

}
