package cn.pethome.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.user.service.UserService;
import cn.pethome.util.PageBean;

/**
 * ��̨���ֲ�
 * 
 * @author Administrator
 *
 */
public class AdminUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/*
	 * ע��UserService�㣬���ṩset����
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ע��currentPage�����ṩget��set����
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * ��̨�鿴�����û�������ҳ
	 * 
	 * @return
	 */
	public String findAllUser() {
		// ����userService�еķ���findAllUser
		PageBean pageBean = userService.findAllUser(currentPage);
		// �����ص�PageBean�������ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ������ֵջ�еĶ��󣬴���findAllUser��Ӧ���������
		return "findAllUser";
	}

}
