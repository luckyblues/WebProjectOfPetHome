package cn.pethome.user.domain;

import java.util.HashSet;
import java.util.Set;

import cn.pethome.address.domain.Address;
import cn.pethome.advice.domain.Advice;
import cn.pethome.order.domain.Order;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String affpwd;
	private String email;
	private String relname;
	private String tel;
	// 一个用户有多个地址
	private Set<Address> address = new HashSet<Address>();
	// 一个用户对应多个订单:
	private Set<Order> orders = new HashSet<Order>();

	// 用户和建议一对多
	private Set<Advice> advice = new HashSet<Advice>();

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

	public String getAffpwd() {
		return affpwd;
	}

	public void setAffpwd(String affpwd) {
		this.affpwd = affpwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getRelname() {
		return relname;
	}

	public void setRelname(String relname) {
		this.relname = relname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Set<Advice> getAdvice() {
		return advice;
	}

	public void setAdvice(Set<Advice> advice) {
		this.advice = advice;
	}

}
