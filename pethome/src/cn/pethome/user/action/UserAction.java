package cn.pethome.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.user.domain.User;
import cn.pethome.user.service.UserService;

//�û���Action��
public class UserAction extends ActionSupport implements ModelDriven<User> {

	// ģ������ʹ�õĶ���
	private User user = new User();

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// ����uid����
	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	// ע��UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ��ת��ע��ҳ���ִ�з���
	public String registPage() {

		return "registPage";
	}

	// ajax�����첽У���û����Ƿ���ڵķ���
	public String findByUname() throws IOException {
		// ͨ��service���ý��в�ѯ
		User exitUser = userService.findByUname(user.getUname());
		// ���response������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (exitUser != null) {
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		} else { // û�в鵽�����û�������ʹ��
			response.getWriter().println("<font color='red'>�û�������ʹ��</font>");
		}
		return NONE;
	}

	// �û�ע��ķ���
	public String register() {
		boolean saveSuccess = userService.save(user);
		return LOGIN;
	}

	// ��ת����¼ҳ���ִ�з���
	public String loginPage() {
		return "loginPage";
	}

	// �û���¼�ķ���
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("�û������������");// ��¼ʧ��
			return LOGIN;
		} else {// ��¼�ɹ�
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);// ���û���Ϣ�浽session��
			return "loginSuccess";// ���ҳ�����ת
		}
	}

	// �û��˳�
	public String exit() {
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}

	/**
	 * ��ת���ҵ��˻�ҳ��
	 */
	public String myaccount() {
		return "myaccount";
	}

	/**
	 * �û��鿴������Ϣ
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
	 * ��ת���޸ĸ�����Ϣ����
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
	 * �޸ĸ�����Ϣ
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
