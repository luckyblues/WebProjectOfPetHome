package cn.pethome.cart.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车实体类，因为购物车里面存放的是商品条目和总钱数，而且整个过程只有一个购物车存在,是存放在seesion当中的
 * 
 * @author Administrator 实现序列化和反序列化的接口
 *
 */
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商品条目类需要用集合来存放,使用map的键值对的形式来存放
	 * 
	 * 为什么使用LinkedhashMap? 因为HashMap是无序的，而LinkedHaspMap是在jdk1.4之后添加的实现的有序的结合，
	 * 这里因为需要以键值对的形式存储商品条目，所以这里选用LinkedHashMap
	 * 
	 */

	private Map<Integer, CartItem> map = new LinkedHashMap<>();

	private double totalamount;// 所有商品条目计算出来的总金额，并提供get方法

	public Double getTotalamount() {
		return totalamount;
	}

	/*
	 * 为了方便在界面上遍历，将map的Value即是CartItem转换成Collection的单列集合
	 * 这里用getCartItems说明在Cart里面有一个cartItems的属性，这个属性是一个集合里面放的是商品的各个属性
	 */
	public Collection<CartItem> getCartItems() {
		// 直接返回Collection对象
		return map.values();

	}

	/**
	 * 购物车中的操作有1.添加到购物车，2.删除某个商品条目，3.清空购物车
	 */

	/*
	 * 1将商品条目添加到购物车方法: 如果在添加商品的时候，在购物车里面已经有了一个相同的商品，则总金额是在原来总金额的基础上+现在添加的商品的总金额，
	 * 而总金额=原来的subtotal+现在的subtotal
	 */
	public void putCart(CartItem cartItem) {
		/**
		 * 如果商品主键为空的话，则说明购物车里面没有该商品对象
		 */

		Integer gid = cartItem.getGoods().getGid();// 获得商品主键，因为下面要判断购物车中是否含有该商品

		// 如果包含的话说明原来购物车中已经有了该商品，则总计为原来的总计+新添加的商品的小计
		if (map.containsKey(gid)) {
			// 获得原来的该主键的商品
			CartItem cartItem_old = map.get(gid);
			// 计算出原来的数量加上现在的数量=现在的总数量

			cartItem_old.setNum(cartItem_old.getNum() + cartItem.getNum());

		} else {
			// 否则购物车中不包含该商品，则把该商品放入购物车中
			map.put(gid, cartItem);
		}
		// 计算总金额
		totalamount = totalamount + cartItem.getSubtotal();

	}

	/**
	 * 2.根据商品主键删除某个商品
	 */
	public void deleteOneGoods(Integer gid) {
		// 根据该CartItem 对应的key，该key即为商品的主键删除该商品条目
		// map.remove返回的对象是CartItem对象
		CartItem cartItem = map.remove(gid);
		// 总金额=总金额-删除的该商品的小计金额
		totalamount = totalamount - cartItem.getSubtotal();
	}

	/**
	 * 清空购物车
	 */
	public void deleteAll() {
		// 清空用clear()方法
		map.clear();
		// 总金额设置为0；
		totalamount = 0.0;
	}

}
