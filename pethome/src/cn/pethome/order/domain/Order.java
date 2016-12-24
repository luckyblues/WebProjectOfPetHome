package cn.pethome.order.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.pethome.address.domain.Address;
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
	private Integer status;// 订单状态：

	// 订单对应的用户，订单与用户的关系是多对一
	private User user;
	private Address address;
	// 一个订单里面可以有多个订单项，所以这里用set集合
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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
