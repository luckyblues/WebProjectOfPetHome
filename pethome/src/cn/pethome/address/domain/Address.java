package cn.pethome.address.domain;

import cn.pethome.user.domain.User;

public class Address {
	private Integer addid;
	private String address;
	private String realName;
	private String tele;
	private int is_default;
	private User user;// ËùÊô ÓÃ»§

	public Integer getAddid() {
		return addid;
	}

	public void setAddid(Integer addid) {
		this.addid = addid;
	}

	public int getIs_default() {
		return is_default;
	}

	public void setIs_default(int is_default) {
		this.is_default = is_default;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
