package cn.pethome.order.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private Integer status;// ����״̬��1.δ���2.�Ѹ��û������3.�Ѹ��ûǩ�գ�4.��ǩ��
	private String realname;// �û�������
	private String tele;// �û����ֻ���
	private String address;// �û��ĵ�ַ

	// ������Ӧ���û����������û��Ĺ�ϵ�Ƕ��һ
	private User user;

	// һ��������������ж�����������������set����
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
