package cn.pethome.goods.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;
import cn.pethome.util.PageBean;

/**
 * ��Ʒ�ı��ֲ�ʵ��
 * 
 * @author Administrator ʵ��ģ��������������Goods
 */

public class GoodsAction extends ActionSupport implements ModelDriven<Goods> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Goods goods = new Goods();
	// ����index.jsp���ݹ����Ĳ������������scid�����ṩget��set����
	private Integer scid;
	// ����index.jsp�д��ݹ�����һ��������������ṩget set����
	private Integer cid;
	// ����index.jsp���ݹ����Ĳ���currentPage
	private Integer currentPage;
	// ģ����ѯ�Ĺؼ���
	private String searchName;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

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
	// ע��GoodsService�����ṩset����

	private GoodsService goodsService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * ������Ʒid��ѯ��Ʒ����
	 * 
	 * @return
	 */
	public String findDetailGoods() {
		/*
		 * ��Ϊʵ��ģ��������ԭ�������������ֱ�ӻ�ȡ��Ʒ�������������ﲻ��Ҫ�����´�����Ʒ������Ϊģ�������Ķ�����λ��ջ���ģ�
		 */
		goods = goodsService.findDetailGoods(goods.getGid());
		return "findDetailGoods";

	}

	/**
	 * ���ֲ� ���ݶ��������scid��ѯ���ö��������µ�������Ʒ�����ҷ�ҳ��ʾ ��ΪPageBean��װ����Ʒ�ͷ�ҳ�����ݣ�
	 * �����ﷵ�صĶ�����PageBean
	 * 
	 * @return
	 */
	public String findGoodsByScid() {
		// ����goodsService�еķ�����ѯ��Ʒ���ϲ����з�ҳ�����صĶ�����pageBean
		PageBean pageBean = goodsService.findGoodsByScid(scid, currentPage);
		// ������浽ֵջ��ȥ,set����pageBean����,�Լ�ֵ�Ե���ʽ�洢
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findGoodsByScid";
	}

	/**
	 * ����һ�������������ѯ����һ�������µ���Ʒ
	 * 
	 * @return ���صĶ�����PageBean����
	 */

	public String findGoodsByCid() {
		PageBean pageBean = goodsService.findGoodsByCid(cid, currentPage);
		// ��PAgeBean���󱣴浽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findGoodsByCid";

	}

	/**
	 * ģ����ѯ����ҳ
	 */
	public String findGoodsByName() {
		// ����Service�еķ���
		PageBean pageBean = goodsService.findAllGoodsByName(searchName, currentPage);
		// ���������ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findGoodsByName";
	}

}
