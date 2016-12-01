package cn.pethome.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.user.service.UserService;
import cn.pethome.util.PageBean;

/**
 * 后台表现层
 * 
 * @author Administrator
 *
 */
public class AdminUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/*
	 * 注入UserService层，并提供set方法
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 注入currentPage，并提供get和set方法
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 后台查看所有用户，并分页
	 * 
	 * @return
	 */
	public String findAllUser() {
		// 调用userService中的方法findAllUser
		PageBean pageBean = userService.findAllUser(currentPage);
		// 将返回的PageBean对象存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 将存入值栈中的对象，带到findAllUser对应的物理界面
		return "findAllUser";
	}

}
