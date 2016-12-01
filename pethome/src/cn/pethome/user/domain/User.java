package cn.pethome.user.domain;

import java.util.HashSet;
import java.util.Set;

import cn.pethome.order.domain.Order;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String affpwd;
	private String email;
	private String address;
	private String tele;

	// 一个用户对应多个订单:
	private Set<Order> orders = new HashSet<Order>();

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getAffpwd() {
		return affpwd;
	}

	public void setAffpwd(String affpwd) {
		this.affpwd = affpwd;
	}

	public User(int uid, String uname, String upwd, String email, String address, String tele) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.email = email;
		this.address = address;
		this.tele = tele;
	}

	public User() {
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
}
