package cn.pethome.admin.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.admin.domain.Admin;
import cn.pethome.admin.service.AdminService;

/**
 * ����Ա�ı��ֲ�
 * 
 * @author Administrator
 * 
 */

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private static final long serialVersionUID = 1L;
	// ��������Ա��洢����
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
	 * ע��AdminService�㣬���ṩset����
	 */
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * ��̨��¼�ķ���
	 */
	public String login() {
		// ����service������ɵ�¼
		Admin existAdmin = adminService.login(admin);
		// �ж�existAdmin�Ƿ���ֵ
		if (existAdmin == null) {
			// ���existAdminΪ��,��ת����¼ʧ��ҳ�棬�����ǵ�¼ҳ��
			return "loginFail";
		} else {
			// �����ֵ��˵����¼�ɹ�����ֵ������session��
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdmin", existAdmin);
			// ��ת����̨��ҳ��
			return "loginSuccess";
		}
	}

	/**
	 * ��̨����Ա�˳�
	 */
	public String exit() {
		// ��session���Ƴ�
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}

	/**
	 * �޸�����
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
	 * �޸�����
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
