package cn.pethome.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.cart.domain.Cart;
import cn.pethome.cart.domain.CartItem;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;

/**
 * 购物车表现层，添加，删除，清空的方法
 * 
 * @author Administrator
 *
 */
public class CartAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 将商品添加到购物车中的表现层实现
	 * 
	 * @return addtoCart
	 */
	// 接受从form表单传来的数据,一个是商品的gid，另一个是购买商品数量,并提供set方法
	private Integer gid;
	private Integer num;

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/*
	 * 在购物车Action中注入goodService，从其中的方法中根据gid获取商品对象,并提供set方法
	 */
	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * 从首页点击购物车进入购物车界面
	 * 
	 * @return
	 */
	public String mycart() {
		return "mycart";

	}

	/**
	 * 将商品添加到购物车，并返回到购物车界面
	 * 
	 * @return
	 */

	public String addtoCart() {
		// 封装一个购物项的对象，并将传来的数据封装在对象中
		CartItem cartItem = new CartItem();
		// 封装商品数量
		cartItem.setNum(num);
		// 封装商品对象,需要从goodsService中根据gid获取商品对象
		Goods goods = goodsService.findDetailGoods(gid);
		// 将商品对象封装在cartItem 对象中
		cartItem.setGoods(goods);
		// 将所有的数据封装好之后，需要将数据封装在购物车的session中

		Cart cart = addCartSession();
		// 将封装好的CartItem封装在Cart中
		cart.putCart(cartItem);

		return "addSuccess";

	}

	/**
	 * 从购物车中根据某个商品id删除该商品条目
	 * 
	 * @return
	 */
	public String deleteOneCartItem() {
		// 从session中获得购物车
		Cart cart = addCartSession();
		// 调用Cart里面的删除方法删除
		cart.deleteOneGoods(gid);
		return "delSuccess";

	}

	/**
	 * 清空购物车
	 * 
	 * @return
	 */
	public String deleteAll() {
		// 从session中获取购物车对象
		Cart cart = addCartSession();
		// 调用cart对象中的方法删除全部商品
		cart.deleteAll();
		// 返回到相应的jsp页面
		return "emptySuccess";

	}

	// 将购物车对象存入session中
	private Cart addCartSession() {
		/**
		 * 从session中获取购物车对象，如果是session中购物车对象为空的话，则说明还没创建购物车对象，
		 * 此时先创建购物车对象，然后再把创建的购物车对象放入session中
		 */
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if (cart == null) {
			// 如果没有购物车对象，则创建购物车对象
			cart = new Cart();
			// 将刚创建的购物车对象放入session中，在界面中利用session获取cart中的数据
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}

}
