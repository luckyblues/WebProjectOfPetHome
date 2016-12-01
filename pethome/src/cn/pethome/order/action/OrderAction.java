package cn.pethome.order.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.order.domain.Order;
import cn.pethome.order.service.OrderService;

/**
 * �����ı��ֲ�ʵ��
 * 
 * @author Administrator
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	private static final long serialVersionUID = 1L;
	private Order orders = new Order();

	@Override
	public Order getModel() {
		return orders;
	}

	// ע��orderService,�����ṩset����
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * ִ����ת��myorder
	 */
	public String myorder() {
		
		return "myorder";
	}
    /**
     * ��ת���ҵ��˻�ҳ��
     */
	public String myaccount(){
		return "myaccount";
		
	}
}
