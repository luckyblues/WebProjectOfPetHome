package cn.pethome.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.user.domain.User;
import cn.pethome.user.service.UserService;
import cn.pethome.util.PageBean;

/**
 * 后台表现层
 * 
 * @author Administrator
 * 
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();

	public User getModel() {
		return user;
	}

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
		return "findSuccess";
	}

	/**
	 * 后台删除用户
	 */
	public String delUser() {
		// 先根据用户id查询出用户对象
		user = userService.findByUid(user.getUid());
		// 调用Service中delete方法
		boolean delSuccess = userService.delete(user);
		return "delSuccess";
	}

}
