package cn.pethome.order.domain;

import cn.pethome.goods.domain.Goods;

/**
 * �������ʵ����
 * 
 * @author Administrator
 *
 */
public class OrderItem {
	private Integer oitemid;// ����������
	private Integer count;// ����ĳ����Ʒ������
	private Double subtotal;// С��
	/*
	 * �������Ƕ�������Ʒ֮����������ĵ����ű����Ա�������Ʒid�Ͷ���id
	 */
	private Goods goods;
	/**
	 * �������������һ���������Ƕ��һ�Ĺ�ϵ��order��Ϊһ�����
	 */
	private Order order;

	public Integer getOitemid() {
		return oitemid;
	}

	public void setOitemid(Integer oitemid) {
		this.oitemid = oitemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
