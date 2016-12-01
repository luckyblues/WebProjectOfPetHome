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

	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
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

		/**
		 * ��ѯ������Ʒ
		 */
		List<Goods> hlist = goodsService.findHotGoods();
		// ����Ʒ��Ϣ����ֵջ���У�����һ�����set�У�����һ�����push��
		ActionContext.getContext().getValueStack().set("hlist", hlist);

		/**
		 * ��ѯ������Ʒ��¼
		 */
		List<Goods> nlist = goodsService.findNewGoods();
		// �����ص�nlist���ݱ�����ֵջ��
		ActionContext.getContext().getValueStack().set("nlist", nlist);

		return "index";
	}

}
