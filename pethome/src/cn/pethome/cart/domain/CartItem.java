package cn.pethome.cart.domain;

import java.io.Serializable;

import cn.pethome.goods.domain.Goods;

/**
 * 商品条目类，是购物车里面的属性
 * 
 * @author Administrator
 *
 */
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Goods goods;// 存放商品的类，待会需要里面的图片，价格，商品名称属性
	private Integer num;// 商品的数量
	private double subtotal;// 计算商品中的价格
	// 生成get set方法

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * 计算商品条目的小计subtotal
	 * 
	 * @return
	 */
	public Double getSubtotal() {
		return subtotal = num * goods.getGprice();
	}
}
