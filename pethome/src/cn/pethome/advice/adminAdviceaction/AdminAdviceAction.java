package cn.pethome.advice.adminAdviceaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.advice.domain.Advice;
import cn.pethome.advice.service.AdviceService;

/**
 * ��̨������
 * 
 * @author Administrator
 *
 */
public class AdminAdviceAction extends ActionSupport implements ModelDriven<Advice> {

	private Advice advice = new Advice();

	@Override
	public Advice getModel() {
		return advice;
	}

	/**
	 * ע��AdviceService
	 */
	private AdviceService adviceService;

	public void setAdviceService(AdviceService adviceService) {
		this.adviceService = adviceService;
	}

	/**
	 * ��̨�鿴����
	 */
	public String findAdvice() {
		// ����Service������List����
		List<Advice> list = adviceService.findAdvice();
		// ���鵽�ļ��ϴ���ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);
		// �����ݴ���findAdvice��Ӧ���������
		return "findAdvice";

	}

	/**
	 * ��̨�鿴��������
	 */
	public String detailAdvice() {
		/**
		 * ����aid��ѯ��������Ӧ�Ķ���
		 */
		advice = adviceService.findDetailAdvice(advice.getAid());
		return "detailAdvice";

	}
}
