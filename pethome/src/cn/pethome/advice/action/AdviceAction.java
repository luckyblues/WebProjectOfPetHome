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
	 * 注入AdviceService，并提供set方法
	 */
	private AdviceService adviceService;

	public void setAdviceService(AdviceService adviceService) {
		this.adviceService = adviceService;
	}

	/**
	 * 注入用户Service
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 跳转到建议页面
	 */
	public String inputadvice() {
		return "inputadvice";

	}

	/**
	 * 跳转到帮助中心界面
	 * 
	 * @return
	 */
	public String help() {
		return "help";

	}

	/**
	 * 跳转到宠物知识模块
	 */
	public String knowledge() {
		return "knowledge";

	}

	/**
	 * 保存建议
	 */
	public String saveAdvice() {
		advice.setAdate(new Date());
		// 从session中获取用户信息
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// 判断用户是否为空，如果为空，则提示并跳转到登录页面
		if (user == null) {
			this.addActionError("还没有登录，请先去登录");
			return "login";
		}
		// 否则设置用户
		advice.setUser(user);
		// 调用Service的方法进行保存
		adviceService.save(advice);
		return "saveAdvice";

	}
}
