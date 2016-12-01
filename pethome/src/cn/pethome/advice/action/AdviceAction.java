package cn.pethome.advice.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.advice.domain.Advice;
import cn.pethome.advice.service.AdviceService;
import cn.pethome.user.domain.User;
import cn.pethome.user.service.UserService;

public class AdviceAction extends ActionSupport implements ModelDriven<Advice> {

	private static final long serialVersionUID = 1L;

	private Advice advice = new Advice();

	@Override
	public Advice getModel() {
		return advice;
	}

	/**
	 * ע��AdviceService�����ṩset����
	 */
	private AdviceService adviceService;

	public void setAdviceService(AdviceService adviceService) {
		this.adviceService = adviceService;
	}

	/**
	 * ע���û�Service
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ��ת������ҳ��
	 */
	public String inputadvice() {
		return "inputadvice";

	}

	/**
	 * ��ת���������Ľ���
	 * 
	 * @return
	 */
	public String help() {
		return "help";

	}

	/**
	 * ��ת������֪ʶģ��
	 */
	public String knowledge() {
		return "knowledge";

	}

	/**
	 * ���潨��
	 */
	public String saveAdvice() {
		advice.setAdate(new Date());
		// ��session�л�ȡ�û���Ϣ
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// �ж��û��Ƿ�Ϊ�գ����Ϊ�գ�����ʾ����ת����¼ҳ��
		if (user == null) {
			this.addActionError("��û�е�¼������ȥ��¼");
			return "login";
		}
		// ���������û�
		advice.setUser(user);
		// ����Service�ķ������б���
		adviceService.save(advice);
		return "saveAdvice";

	}
}
