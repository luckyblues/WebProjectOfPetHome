package cn.pethome.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.category.domain.Category;
import cn.pethome.category.service.CategoryService;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;
import cn.pethome.util.PageBean;

/**
 * 访问首页的Action,首页要显示的有一级分类，二级分类，二级分类下的商品
 * 
 * @author yrh
 *
 */
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 注入CategoryService，并提供相应的set方法
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * 执行访问首页的方法
	 * 
	 * @return
	 */
	public String execute() {
		/**
		 * 查询所有的一级分类
		 */
		List<Category> clist = categoryService.findAllCategory();

		ActionContext.getContext().getSession().put("clist", clist);

		/**
		 * 查询热门商品
		 */
		List<Goods> hlist = goodsService.findHotGoods();
		// 将商品信息存入值栈中中，集合一般存在set中，对象一般存在push中
		ActionContext.getContext().getValueStack().set("hlist", hlist);

		/**
		 * 查询最新商品记录
		 */
		List<Goods> nlist = goodsService.findNewGoods();
		// 将返回的nlist数据保存在值栈中
		ActionContext.getContext().getValueStack().set("nlist", nlist);

		return "index";
	}

}
