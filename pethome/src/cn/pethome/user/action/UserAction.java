package cn.pethome.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.user.domain.User;
import cn.pethome.user.service.UserService;

//用户的Action类
public class UserAction extends ActionSupport implements ModelDriven<User> {

	// 模型驱动使用的对象
	private User user = new User();

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// 接受uid参数
	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	// 注入UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 跳转到注册页面的执行方法
	public String registPage() {

		return "registPage";
	}

	// ajax进行异步校验用户名是否存在的方法
	public String findByUname() throws IOException {
		// 通过service调用进行查询
		User exitUser = userService.findByUname(user.getUname());
		// 获得response对象，向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (exitUser != null) {
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		} else { // 没有查到，该用户名可以使用
			response.getWriter().println("<font color='red'>用户名可以使用</font>");
		}
		return NONE;
	}

	// 用户注册的方法
	public String register() {
		boolean saveSuccess = userService.save(user);
		return LOGIN;
	}

	// 跳转到登录页面的执行方法
	public String loginPage() {
		return "loginPage";
	}

	// 用户登录的方法
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("用户名或密码错误");// 登录失败
			return LOGIN;
		} else {// 登录成功
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);// 将用户信息存到session中
			return "loginSuccess";// 完成页面的跳转
		}
	}

	// 用户退出
	public String exit() {
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}

	/**
	 * 跳转到我的账户页面
	 */
	public String myaccount() {
		return "myaccount";
	}

	/**
	 * 用户查看个人信息
	 */
	public String findUserInfo() {
		user = userService.findByUid(user.getUid());
		if (user == null) {
			return "noData";
		} else {
			return "findInfoSuccess";
		}

	}

	/**
	 * 跳转到修改个人信息界面
	 * */
	public String editUserInfo() {
		user = userService.findByUid(user.getUid());
		if (user == null) {
			return "noData";
		} else {
			return "editInfoSuccess";
		}
	}

	/**
	 * 修改个人信息
	 * */
	public String updateUserInfo() {
		boolean updateSuccess = userService.updateUserInfo(user);
		if (updateSuccess) {
			return "updateInfoSuccess";
		} else {
			return "updateFail";
		}
	}
}
