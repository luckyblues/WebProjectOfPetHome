package cn.pethome.order.adminaction;

import cn.pethome.order.domain.Order;
import cn.pethome.order.service.OrderService;
import cn.pethome.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminOrderAction extends ActionSupport implements
		ModelDriven<Order> {
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	// 注入OrderService
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 后台查询yi付款订单
	 * 
	 */
	public String findAllAlreadyPaid() {
		// 调用orderService方法findAllAlreadyPaid
		PageBean pageBean = orderService.findAllAlreadyPaid(currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// 将查询到的结果集存储到值栈中
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "CompleteOrderSuccess";
		}
	}

	public String findAllNoPaid() {
		// 调用orderService方法findAllAlreadyPaid
		PageBean pageBean = orderService.findAllNoPaid(currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// 将查询到的结果集存储到值栈中
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "findNoPaySuccess";
		}
	}
}
