package cn.pethome.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.pethome.category.domain.Category;
import cn.pethome.category.service.CategoryService;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;

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

	// ��IndexActionz��ע��GoodsService,���ṩ��Ӧ��set����
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
	 * ִ�з�����ҳ�ķ���
	 * 
	 * @return
	 */
	public String execute() {
		/**
		 * ��ѯ���е�һ������
		 */
		List<Category> list = categoryService.findAllCategory();
		/**
		 * ��ѯ��ҳ���������µ�ʮ����������Ʒ
		 */
		List<Goods> hlist = goodsService.findHotGoodsByCsid(cid);
		// ����Ʒ��Ϣ����ֵջ���У�����һ�����set�У�����һ�����push��
		ActionContext.getContext().getValueStack().set("hlist", hlist);
       

		return "index";
	}
}
