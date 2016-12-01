package cn.pethome.advice.service;

import java.util.List;

import cn.pethome.advice.dao.AdviceDao;
import cn.pethome.advice.domain.Advice;

/**
 * Advice��ҵ���߼���
 * 
 * @author Administrator
 *
 */
public class AdviceService {
	/**
	 * ע��AdviceDao��
	 */
	private AdviceDao adviceDao;

	public void setAdviceDao(AdviceDao adviceDao) {
		this.adviceDao = adviceDao;
	}

	/**
	 * ���潨��
	 * 
	 * @param advice
	 */
	public void save(Advice advice) {
		adviceDao.save(advice);
	}

	/**
	 * ��̨�鿴����
	 * 
	 * @return
	 */
	public List<Advice> findAdvice() {
		return adviceDao.findAdvice();
	}

	/**
	 * ��̨�鿴��������
	 * @param aid
	 * @return
	 */
	public Advice findDetailAdvice(Integer aid) {
		return adviceDao.findDeatilAdvice(aid);
	}

}
