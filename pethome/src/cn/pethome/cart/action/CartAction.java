package cn.pethome.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.cart.domain.Cart;
import cn.pethome.cart.domain.CartItem;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;

/**
 * ���ﳵ���ֲ㣬��ӣ�ɾ������յķ���
 * 
 * @author Administrator
 *
 */
public class CartAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ����Ʒ��ӵ����ﳵ�еı��ֲ�ʵ��
	 * 
	 * @return addtoCart
	 */
	// ���ܴ�form������������,һ������Ʒ��gid����һ���ǹ�����Ʒ����,���ṩset����
	private Integer gid;
	private Integer num;

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/*
	 * �ڹ��ﳵAction��ע��goodService�������еķ����и���gid��ȡ��Ʒ����,���ṩset����
	 */
	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * ����ҳ������ﳵ���빺�ﳵ����
	 * 
	 * @return
	 */
	public String mycart() {
		return "mycart";

	}

	/**
	 * ����Ʒ��ӵ����ﳵ�������ص����ﳵ����
	 * 
	 * @return
	 */

	public String addtoCart() {
		// ��װһ��������Ķ��󣬲������������ݷ�װ�ڶ�����
		CartItem cartItem = new CartItem();
		// ��װ��Ʒ����
		cartItem.setNum(num);
		// ��װ��Ʒ����,��Ҫ��goodsService�и���gid��ȡ��Ʒ����
		Goods goods = goodsService.findDetailGoods(gid);
		// ����Ʒ�����װ��cartItem ������
		cartItem.setGoods(goods);
		// �����е����ݷ�װ��֮����Ҫ�����ݷ�װ�ڹ��ﳵ��session��

		Cart cart = addCartSession();
		// ����װ�õ�CartItem��װ��Cart��
		cart.putCart(cartItem);

		return "addSuccess";

	}

	/**
	 * �ӹ��ﳵ�и���ĳ����Ʒidɾ������Ʒ��Ŀ
	 * 
	 * @return
	 */
	public String deleteOneCartItem() {
		// ��session�л�ù��ﳵ
		Cart cart = addCartSession();
		// ����Cart�����ɾ������ɾ��
		cart.deleteOneGoods(gid);
		return "delSuccess";

	}

	/**
	 * ��չ��ﳵ
	 * 
	 * @return
	 */
	public String deleteAll() {
		// ��session�л�ȡ���ﳵ����
		Cart cart = addCartSession();
		// ����cart�����еķ���ɾ��ȫ����Ʒ
		cart.deleteAll();
		// ���ص���Ӧ��jspҳ��
		return "emptySuccess";

	}

	// �����ﳵ�������session��
	private Cart addCartSession() {
		/**
		 * ��session�л�ȡ���ﳵ���������session�й��ﳵ����Ϊ�յĻ�����˵����û�������ﳵ����
		 * ��ʱ�ȴ������ﳵ����Ȼ���ٰѴ����Ĺ��ﳵ�������session��
		 */
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if (cart == null) {
			// ���û�й��ﳵ�����򴴽����ﳵ����
			cart = new Cart();
			// ���մ����Ĺ��ﳵ�������session�У��ڽ���������session��ȡcart�е�����
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}

}
