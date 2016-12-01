package cn.pethome.order.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.order.domain.Order;
import cn.pethome.order.service.OrderService;

/**
 * 订单的表现层实现
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

	// 注入orderService,，并提供set方法
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 执行跳转，myorder
	 */
	public String myorder() {
		
		return "myorder";
	}
    /**
     * 跳转到我的账户页面
     */
	public String myaccount(){
		return "myaccount";
		
	}
}
