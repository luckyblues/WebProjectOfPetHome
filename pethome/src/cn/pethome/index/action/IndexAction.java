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
 * ������ҳ��Action,��ҳҪ��ʾ����һ�����࣬�������࣬���������µ���Ʒ
 * 
 * @author yrh
 *
 */
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// ע��CategoryService�����ṩ��Ӧ��set����
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * ִ�з�����ҳ�ķ���
	 * 
	 * @return
	 */
	public String execute() {
		/**
		 * ��ѯ���е�һ������
		 */
		List<Category> clist = categoryService.findAllCategory();

		ActionContext.getContext().getSession().put("clist", clist);

		return "index";
	}
}
