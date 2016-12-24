package cn.pethome.order.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.pethome.address.domain.Address;
import cn.pethome.user.domain.User;

/**
 * ������ʵ����
 * 
 * @author Administrator
 * 
 */
public class Order {
	private Integer oid;// ��������
	private Date ordertime;// �µ�ʱ��
	private Double total;// �ܽ��
	private Integer status;// ����״̬��

	// ������Ӧ���û����������û��Ĺ�ϵ�Ƕ��һ
	private User user;
	private Address address;
	// һ��������������ж�����������������set����
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
