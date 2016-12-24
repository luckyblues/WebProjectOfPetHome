package cn.pethome.advice.service;

import java.util.List;

import cn.pethome.advice.dao.AdviceDao;
import cn.pethome.advice.domain.Advice;

/**
 * Advice的业务逻辑层
 * 
 * @author Administrator
 * 
 */
public class AdviceService {
	/**
	 * 注入AdviceDao层
	 */
	private AdviceDao adviceDao;

	public void setAdviceDao(AdviceDao adviceDao) {
		this.adviceDao = adviceDao;
	}

	/**
	 * 保存建议
	 * 
	 * @param advice
	 * @return
	 */
	public boolean save(Advice advice) {
		if (adviceDao.save(advice)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 后台查看建议
	 * 
	 * @return
	 */
	public List<Advice> findAdvice() {
		return adviceDao.findAdvice();
	}

	/**
	 * 后台查看建议详情
	 * 
	 * @param aid
	 * @return
	 */
	public Advice findDetailAdvice(Integer aid) {
		return adviceDao.findDeatilAdvice(aid);
	}

}
