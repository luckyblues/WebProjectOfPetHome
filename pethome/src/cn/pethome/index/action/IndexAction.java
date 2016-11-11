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

		return "index";
	}
}
