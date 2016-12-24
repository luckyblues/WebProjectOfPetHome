package cn.pethome.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.user.domain.User;
import cn.pethome.user.service.UserService;
import cn.pethome.util.PageBean;

/**
 * ��̨���ֲ�
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
		return "findSuccess";
	}

	/**
	 * ��̨ɾ���û�
	 */
	public String delUser() {
		// �ȸ����û�id��ѯ���û�����
		user = userService.findByUid(user.getUid());
		// ����Service��delete����
		boolean delSuccess = userService.delete(user);
		return "delSuccess";
	}

}
