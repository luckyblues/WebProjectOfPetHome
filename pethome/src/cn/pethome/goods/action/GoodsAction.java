package cn.pethome.goods.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;
import cn.pethome.util.PageBean;

/**
 * 商品的表现层实现
 * 
 * @author Administrator 实现模型驱动，类型是Goods
 */

public class GoodsAction extends ActionSupport implements ModelDriven<Goods> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Goods goods = new Goods();
	// 接受index.jsp传递过来的参数二级分类的scid，并提供get和set方法
	private Integer scid;

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	// 接受index.jsp传递过来的参数currentPage
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public Goods getModel() {
		return goods;
	}
	// 注入GoodsService，并提供set方法

	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public String findDetailGoods() {
		/*
		 * 因为实现模型驱动的原因，所以这里可以直接获取商品主键，并且这里不需要在重新创建商品对象，因为模型驱动的对象是位于栈顶的，
		 */
		goods = goodsService.findDetailGoods(goods.getGid());
		return "findDetailGoods";

	}

	/**
	 * 表现层 根据二级分类的scid查询出该二级分类下的所有商品，并且分页显示 因为PageBean封装了商品和分页的数据，
	 * 有这里返回的对象是PageBean
	 * 
	 * @return
	 */
	public String findGoodsByScid() {
		// 调用goodsService中的方法查询商品集合并带有分页，返回的对象是pageBean
		PageBean pageBean = goodsService.findGoodsByScid(scid, currentPage);
		// 将结果存到值栈中去,set保存对象,以键值对的形式存储
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findGoodsByScid";

	}
}
