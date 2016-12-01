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

	@Override
	public Admin getModel() {
		return admin;
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
			ServletActionContext.getRequest().getSession().setAttribute("existAdmin", existAdmin);
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
}
