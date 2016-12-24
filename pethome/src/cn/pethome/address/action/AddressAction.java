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
	 * 注入Service
	 */
	private AddressService addressService;

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * 注入UserService
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 前台添加地址
	 */
	public String addPage() {
		return "addSuccess";
	}

	/**
	 * 添加地址
	 * 
	 * @return
	 */
	public String addUserInfo() {
		// 从session中获取用户信息
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// 判断用户是否为空，如果为空，则提示并跳转到登录页面
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
	 * 用户查看地址
	 */
	public String findAllAddress() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		} else {
			// 分页
			PageBean pageBean = addressService.findAllAddress(user.getUid(),
					currentPage);

			if (pageBean.getList().size() != 0) {
				// 将数据存入值栈中
				ActionContext.getContext().getValueStack()
						.set("pageBean", pageBean);
				// 将数据带到界面
				return "findSuccess";
			} else {
				return "noData";
			}
		}
	}

	/**
	 * 用户删除地址
	 */
	public String delAddress() {
		// 根据addid找到该地址
		address = addressService.findByAddid(address.getAddid());
		// 删除
		boolean delSuccess = addressService.delete(address);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}

	}

	/**
	 * 跳转到编辑收货地址页面
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
	 * 修改收货信息
	 */
	public String updateAddress() {
		// 调用Service
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
