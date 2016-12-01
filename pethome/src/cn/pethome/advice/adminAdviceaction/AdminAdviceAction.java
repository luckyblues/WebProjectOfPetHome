package cn.pethome.advice.adminAdviceaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.advice.domain.Advice;
import cn.pethome.advice.service.AdviceService;

/**
 * 后台管理建议
 * 
 * @author Administrator
 *
 */
public class AdminAdviceAction extends ActionSupport implements ModelDriven<Advice> {

	private Advice advice = new Advice();

	@Override
	public Advice getModel() {
		return advice;
	}

	/**
	 * 注入AdviceService
	 */
	private AdviceService adviceService;

	public void setAdviceService(AdviceService adviceService) {
		this.adviceService = adviceService;
	}

	/**
	 * 后台查看建议
	 */
	public String findAdvice() {
		// 调用Service，返回List集合
		List<Advice> list = adviceService.findAdvice();
		// 将查到的集合存入值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		// 将数据带到findAdvice对应的物理界面
		return "findAdvice";

	}

	/**
	 * 后台查看建议详情
	 */
	public String detailAdvice() {
		/**
		 * 根据aid查询该主键对应的对象
		 */
		advice = adviceService.findDetailAdvice(advice.getAid());
		return "detailAdvice";

	}
}
