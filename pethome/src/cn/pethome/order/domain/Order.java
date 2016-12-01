package cn.pethome.order.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.pethome.user.domain.User;

/**
 * 订单的实体类
 * 
 * @author Administrator
 *
 */
public class Order {
	private Integer oid;// 订单主键
	private Date ordertime;// 下单时间
	private Double total;// 总金额
	private Integer status;// 订单状态：1.未付款，2.已付款还没发货，3.已付款还没签收，4.已签收
	private String realname;// 用户的姓名
	private String tele;// 用户的手机号
	private String address;// 用户的地址

	// 订单对应的用户，订单与用户的关系是多对一
	private User user;

	// 一个订单里面可以有多个订单项，所以这里用set集合
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
