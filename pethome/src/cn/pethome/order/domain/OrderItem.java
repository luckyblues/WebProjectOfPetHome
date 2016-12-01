package cn.pethome.order.domain;

import cn.pethome.goods.domain.Goods;

/**
 * 订单项表实体类
 * 
 * @author Administrator
 *
 */
public class OrderItem {
	private Integer oitemid;// 订单项主键
	private Integer count;// 购买某个商品的数量
	private Double subtotal;// 小计
	/*
	 * 订单项是订单和商品之间衍生处理的第三张表，所以表里有商品id和订单id
	 */
	private Goods goods;
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
