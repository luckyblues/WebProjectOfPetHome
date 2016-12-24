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

	// ע��OrderService
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * ��̨��ѯyi�����
	 * 
	 */
	public String findAllAlreadyPaid() {
		// ����orderService����findAllAlreadyPaid
		PageBean pageBean = orderService.findAllAlreadyPaid(currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// ����ѯ���Ľ�����洢��ֵջ��
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "CompleteOrderSuccess";
		}
	}

	public String findAllNoPaid() {
		// ����orderService����findAllAlreadyPaid
		PageBean pageBean = orderService.findAllNoPaid(currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// ����ѯ���Ľ�����洢��ֵջ��
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "findNoPaySuccess";
		}
	}
}
