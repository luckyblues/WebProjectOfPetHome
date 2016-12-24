package cn.pethome.admin.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.admin.domain.Admin;
import cn.pethome.admin.service.AdminService;

/**
 * 管理员的表现层
 * 
 * @author Administrator
 * 
 */

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private static final long serialVersionUID = 1L;
	// 创建管理员类存储数据
	private Admin admin = new Admin();

	public Admin getModel() {
		return admin;
	}

	private String new_apwd;
	private String confirm_apwd;

	public String getConfirm_apwd() {
		return confirm_apwd;
	}

	public void setConfirm_apwd(String confirm_apwd) {
		this.confirm_apwd = confirm_apwd;
	}

	public String getNew_apwd() {
		return new_apwd;
	}

	public void setNew_apwd(String new_apwd) {
		this.new_apwd = new_apwd;
	}

	/*
	 * 注入AdminService层，并提供set方法
	 */
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 后台登录的方法
	 */
	public String login() {
		// 调用service方法完成登录
		Admin existAdmin = adminService.login(admin);
		// 判断existAdmin是否有值
		if (existAdmin == null) {
			// 如果existAdmin为空,跳转到登录失败页面，即还是登录页面
			return "loginFail";
		} else {
			// 如果有值则说明登录成功，则将值保存在session中
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdmin", existAdmin);
			// 跳转到后台主页面
			return "loginSuccess";
		}
	}

	/**
	 * 后台管理员退出
	 */
	public String exit() {
		// 从session中移除
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}

	/**
	 * 修改密码
	 */
	public String editPwd() {
		admin = adminService.findAdmin(admin.getAid());
		if (admin == null) {
			return "editFail";
		} else {
			return "findPwdSuccess";
		}
	}

	/**
	 * 修改密码
	 */
	public String updatePwd() {
		admin.setApwd(new_apwd);
		boolean updateSuccess = adminService.update(admin);
		if (updateSuccess) {
			ServletActionContext.getRequest().getSession().invalidate();
			return "login";
		} else {
			return "updateFail";
		}
	}

}
