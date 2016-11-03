package cn.pethome.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.category.domain.Category;
import cn.pethome.category.service.CategoryService;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;

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

	// 在IndexActionz中注入GoodsService,并提供相应的set方法
	private GoodsService goodsService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
private Integer cid;

	public void setCid(Integer cid) {
	this.cid = cid;
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
		List<Category> list = categoryService.findAllCategory();
		/**
		 * 查询首页二级分类下的十条的热门商品
		 */
		List<Goods> hlist = goodsService.findHotGoodsByCsid(cid);
		// 将商品信息存入值栈中中，集合一般存在set中，对象一般存在push中
		ActionContext.getContext().getValueStack().set("hlist", hlist);
       

		return "index";
	}
}
