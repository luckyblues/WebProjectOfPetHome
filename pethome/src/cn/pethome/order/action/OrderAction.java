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
 * �����ı��ֲ�ʵ��
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

	// ���ܴӺ�̨��������֧��ͨ������
	private String pd_FrpId;

	public String getPd_FrpId() {
		return pd_FrpId;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	// ���ո���ɹ���Ĳ���:
	private String r3_Amt;
	private String r6_Order;

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	// ���ܴ�������currentPage
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

	// �Ӻ�̨�������ĵ�ַ���
	private int addid;// ��ַ���

	public int getAddid() {
		return addid;
	}

	public void setAddid(int addid) {
		this.addid = addid;
	}

	// ע��orderService,�����ṩset����
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * ע��AddressService
	 */
	private AddressService addressService;

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * ִ����ת,����ַ��Ϣ����ȥ
	 */
	public String myorder() {

		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		}

		// ��ȡĬ�ϵ�ַ
		List<Address> list = addressService.findByDefault(user.getUid());
		// ����ַ����ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);

		return "myorder";

	}

	/**
	 * ���ɶ���
	 * 
	 * @throws IOException
	 */
	public String saveOrder() {
		// ���ﳵ��session��,��ȡ���ﳵ����
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart.getCartItems().size() == 0) {
			return "noData";
		}
		// ��װ�������ݣ��������ݿ�
		// ��װ�µ�ʱ��
		orders.setOrdertime(new Date());
		// ��װ�������ܽ��������ܽ���Ǵӹ��ﳵ���ܼ��ﴫ������
		orders.setTotal(cart.getTotalamount());
		// ��װ����״̬
		orders.setStatus(1);// 1.��ʾδ���2����ʾ�Ѹ��δ������3.��ʾ�����ѷ�������δǩ��4.��ʾ���
		// ��װ�����������û�,�û�����session��
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// ��װ�����û�
		orders.setUser(user);
		// ��װ������ļ���,������������Ƿ�װ�ڹ������еģ��������Ȼ�ȡ������ļ��ϣ���Cart���з�װ�õĹ�����ϡ�
		for (CartItem cartItem : cart.getCartItems()) {
			// ��ʼ��װ������
			OrderItem orderItem = new OrderItem();
			// ��װ������������������������������Ʒ�����������ڹ�������
			orderItem.setCount(cartItem.getNum());
			// ��װ��Ʒ����
			orderItem.setGoods(cartItem.getGoods());
			// ��װ��Ʒ��С��
			orderItem.setSubtotal(cartItem.getSubtotal());
			// ��װ
			orderItem.setOrder(orders);
			// ��װ������ڶ���������һ��set���ϣ���ŵ��Ƕ���������ǰɷ�װ�õĶ�����ŵ�������
			orders.getOrderItems().add(orderItem);
			// ��װ��ַ
			// ����addid��ȡ�ñ�Ŷ�Ӧ�ĵ�ַ
			Address address = addressService.findByAddid(addid);
			// ��װ�����ĵ�ַ
			orders.setAddress(address);
		}
		// ����װ�õ����ݱ��浽���ݿ�
		boolean saveSuccess = orderService.save(orders);
		if (saveSuccess) {
			return "saveSuccess";
		} else {
			return "addFail";
		}
	}

	public String payOrder() throws IOException {

		/**
		 * ����
		 */
		// 2.��ɸ���:
		// ������Ҫ�Ĳ���:
		String p0_Cmd = "Buy"; // ҵ������:
		String p1_MerId = "10001126856";// �̻����:
		String p2_Order = orders.getOid().toString();// �������:
		String p3_Amt = "0.01"; // ������:
		String p4_Cur = "CNY"; // ���ױ���:
		String p5_Pid = ""; // ��Ʒ����:
		String p6_Pcat = ""; // ��Ʒ����:
		String p7_Pdesc = ""; // ��Ʒ����:
		String p8_Url = "http://localhost:8080/pethome/order_getDataOfPay.action"; // �̻�����֧���ɹ����ݵĵ�ַ:
		String p9_SAF = ""; // �ͻ���ַ:
		String pa_MP = ""; // �̻���չ��Ϣ:
		String pd_FrpId = this.pd_FrpId;// ֧ ��ͨ������:
		String pr_NeedResponse = "1"; // Ӧ�����:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// ���ױ���������:
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

		// �ض���:���ױ�����:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	/**
	 * �����ҳ�ϵ��ҵĶ����������ҵ��˻������ѯ������ת�����еĶ���ҳ��
	 */
	public String findAllOrder() {
		// �����û��ı�Ų�ѯ���û��Ķ���
		// �û�����session��
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (user == null) {
			return "login";
		} else {
			// ��ѯ����ҳ����װզPageBean��
			PageBean pageBean = orderService.findAllOrder(user.getUid(),
					currentPage);
			if (pageBean.getList().size() == 0) {
				return "noData";
			} else {
				// ��ȡ�������ݴ���ֵջ��
				ActionContext.getContext().getValueStack()
						.set("pageBean", pageBean);

				// �����ݴ�����Ӧ���������ȥ
				return "findSuccess";
			}
		}
	}

	/**
	 * ���ݶ������ɾ������
	 */
	public String delOrder() {
		// �ȸ��ݱ���ҵ���Ӧ�Ķ���
		orders = orderService.findByOid(orders.getOid());
		// ɾ�� ��������
		boolean delSuccess = orderService.delOrder(orders);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}
	}

	/**
	 * ��ѯ��������
	 */
	public String detailOrder() {
		orders = orderService.findByOid(orders.getOid());
		if (orders == null) {
			return "noData";
		} else {
			// �����ݴ�����Ӧ������ҳ��
			return "detailOrderSuccess";
		}
	}

	/**
	 * ����֧�����ݳɹ�
	 */
	public String getDataOfPay() {
		// �޸Ķ�����״̬:
		Order order2 = orderService.findByOid(Integer.parseInt(r6_Order));
		// �޸Ķ���״̬Ϊ2:�Ѿ�����:
		order2.setStatus(2);
		boolean updateSuccess = orderService.update(order2);
		if (updateSuccess) {
			this.addActionMessage("֧���ɹ�!�������Ϊ: " + r6_Order + " ������Ϊ: "
					+ r3_Amt);
			return "msg";
		} else {
			return "updateFail";
		}
	}
}
