package cn.pethome.order.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.cglib.transform.impl.AddStaticInitTransformer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.address.domain.Address;
import cn.pethome.address.service.AddressService;
import cn.pethome.cart.domain.Cart;
import cn.pethome.cart.domain.CartItem;
import cn.pethome.order.domain.Order;
import cn.pethome.order.domain.OrderItem;
import cn.pethome.order.service.OrderService;
import cn.pethome.user.domain.User;
import cn.pethome.util.PageBean;
import cn.pethome.util.PaymentUtil;

/**
 * 订单的表现层实现
 * 
 * @author Administrator
 * 
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	private static final long serialVersionUID = 1L;
	private Order orders = new Order();

	public Order getModel() {
		return orders;
	}

	// 接受从后台传过来的支付通道编码
	private String pd_FrpId;

	public String getPd_FrpId() {
		return pd_FrpId;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	// 接收付款成功后的参数:
	private String r3_Amt;
	private String r6_Order;

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	// 接受传过来的currentPage
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	// 从后台传过来的地址编号
	private int addid;// 地址编号

	public int getAddid() {
		return addid;
	}

	public void setAddid(int addid) {
		this.addid = addid;
	}

	// 注入orderService,，并提供set方法
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 注入AddressService
	 */
	private AddressService addressService;

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * 执行跳转,将地址信息带过去
	 */
	public String myorder() {

		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		}

		// 获取默认地址
		List<Address> list = addressService.findByDefault(user.getUid());
		// 将地址存入值栈中
		ActionContext.getContext().getValueStack().set("list", list);

		return "myorder";

	}

	/**
	 * 生成订单
	 * 
	 * @throws IOException
	 */
	public String saveOrder() {
		// 购物车在session中,获取购物车对象
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart.getCartItems().size() == 0) {
			return "noData";
		}
		// 封装订单数据，存入数据库
		// 封装下单时间
		orders.setOrdertime(new Date());
		// 封装订单的总金额，订单的总金额是从购物车的总计里传过来的
		orders.setTotal(cart.getTotalamount());
		// 封装订单状态
		orders.setStatus(1);// 1.表示未付款，2。表示已付款还未发货，3.表示订单已发货，还未签收4.表示完成
		// 封装订单所属的用户,用户存入session中
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// 封装所属用户
		orders.setUser(user);
		// 封装订单项的集合,订单项的数据是封装在购物项中的，所以首先获取购物项的集合，在Cart类中封装好的购物项集合。
		for (CartItem cartItem : cart.getCartItems()) {
			// 开始封装订单项
			OrderItem orderItem = new OrderItem();
			// 封装订单项的数量，订单项的数量就是商品的数量，存在购物项中
			orderItem.setCount(cartItem.getNum());
			// 封装商品对象
			orderItem.setGoods(cartItem.getGoods());
			// 封装商品的小计
			orderItem.setSubtotal(cartItem.getSubtotal());
			// 封装
			orderItem.setOrder(orders);
			// 封装订单项，在订单类里有一个set集合，存放的是订单项，这里是吧封装好的订单项放到订单里
			orders.getOrderItems().add(orderItem);
			// 封装地址
			// 根据addid获取该编号对应的地址
			Address address = addressService.findByAddid(addid);
			// 封装所属的地址
			orders.setAddress(address);
		}
		// 将封装好的数据保存到数据库
		boolean saveSuccess = orderService.save(orders);
		if (saveSuccess) {
			return "saveSuccess";
		} else {
			return "addFail";
		}
	}

	public String payOrder() throws IOException {

		/**
		 * 付款
		 */
		// 2.完成付款:
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = orders.getOid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://localhost:8080/pethome/order_getDataOfPay.action"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pd_FrpId = this.pd_FrpId;// 支 付通道编码:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer(
				"https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);

		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	/**
	 * 点击首页上的我的订单，或者我的账户里面查询订单跳转到所有的订单页面
	 */
	public String findAllOrder() {
		// 根据用户的编号查询该用户的订单
		// 用户存在session中
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		} else {
			// 查询并分页，封装咋PageBean中
			PageBean pageBean = orderService.findAllOrder(user.getUid(),
					currentPage);
			if (pageBean.getList().size() == 0) {
				return "noData";
			} else {
				// 将取出的数据存在值栈中
				ActionContext.getContext().getValueStack()
						.set("pageBean", pageBean);

				// 将数据带到对应的物理界面去
				return "findSuccess";
			}
		}
	}

	/**
	 * 根据订单编号删除订单
	 */
	public String delOrder() {
		// 先根据编号找到相应的订单
		orders = orderService.findByOid(orders.getOid());
		// 删除 订单对象
		boolean delSuccess = orderService.delOrder(orders);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}
	}

	/**
	 * 查询订单详情
	 */
	public String detailOrder() {
		orders = orderService.findByOid(orders.getOid());
		if (orders == null) {
			return "noData";
		} else {
			// 将数据传到对应的详请页面
			return "detailOrderSuccess";
		}
	}

	/**
	 * 接受支付数据成功
	 */
	public String getDataOfPay() {
		// 修改订单的状态:
		Order order2 = orderService.findByOid(Integer.parseInt(r6_Order));
		// 修改订单状态为2:已经付款:
		order2.setStatus(2);
		boolean updateSuccess = orderService.update(order2);
		if (updateSuccess) {
			this.addActionMessage("支付成功!订单编号为: " + r6_Order + " 付款金额为: "
					+ r3_Amt);
			return "msg";
		} else {
			return "updateFail";
		}
	}
}
