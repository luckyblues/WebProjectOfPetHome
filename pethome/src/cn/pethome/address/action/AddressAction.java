package cn.pethome.address.action;

import org.apache.struts2.ServletActionContext;

import cn.pethome.address.domain.Address;
import cn.pethome.address.service.AddressService;
import cn.pethome.user.domain.User;
import cn.pethome.user.service.UserService;
import cn.pethome.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddressAction extends ActionSupport implements
		ModelDriven<Address> {
	private Address address = new Address();

	public Address getModel() {
		return address;
	}

	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	private int currentPage;

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * ע��Service
	 */
	private AddressService addressService;

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * ע��UserService
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ǰ̨��ӵ�ַ
	 */
	public String addPage() {
		return "addSuccess";
	}

	/**
	 * ��ӵ�ַ
	 * 
	 * @return
	 */
	public String addUserInfo() {
		// ��session�л�ȡ�û���Ϣ
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// �ж��û��Ƿ�Ϊ�գ����Ϊ�գ�����ʾ����ת����¼ҳ��
		if (user == null) {
			return "login";
		}
		address.setUser(user);
		boolean addSuccess = addressService.saveUserInfo(address);
		if (addSuccess) {
			return "saveSuccess";
		} else {
			return "addFail";
		}
	}

	/**
	 * �û��鿴��ַ
	 */
	public String findAllAddress() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		} else {
			// ��ҳ
			PageBean pageBean = addressService.findAllAddress(user.getUid(),
					currentPage);

			if (pageBean.getList().size() != 0) {
				// �����ݴ���ֵջ��
				ActionContext.getContext().getValueStack()
						.set("pageBean", pageBean);
				// �����ݴ�������
				return "findSuccess";
			} else {
				return "noData";
			}
		}
	}

	/**
	 * �û�ɾ����ַ
	 */
	public String delAddress() {
		// ����addid�ҵ��õ�ַ
		address = addressService.findByAddid(address.getAddid());
		// ɾ��
		boolean delSuccess = addressService.delete(address);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}

	}

	/**
	 * ��ת���༭�ջ���ַҳ��
	 */
	public String editAddress() {
		address = addressService.findByAddid(address.getAddid());
		if (address != null) {
			return "editAddress";
		} else {
			return "editFail";
		}

	}

	/**
	 * �޸��ջ���Ϣ
	 */
	public String updateAddress() {
		// ����Service
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		} else {
			address.setUser(user);
		}
		boolean updateSuccess = addressService.updateAddress(address);
		if (updateSuccess) {
			return "updateSuccess";
		} else {
			return "updateFail";
		}
	}

}
