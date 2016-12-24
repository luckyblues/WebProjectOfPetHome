package cn.pethome.goods.action;

import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;
import cn.pethome.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
		if (goods == null) {
			return "noData";
		} else {
			return "findDetailGoods";
		}
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
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// ������浽ֵջ��ȥ,set����pageBean����,�Լ�ֵ�Ե���ʽ�洢
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "getGoodsByScid";
		}
	}

	/**
	 * ����һ�������������ѯ����һ�������µ���Ʒ
	 * 
	 * @return ���صĶ�����PageBean����
	 */

	public String findGoodsByCid() {
		PageBean pageBean = goodsService.findGoodsByCid(cid, currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// ��PAgeBean���󱣴浽ֵջ��
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "getGoodsByCid";
		}
	}

	/**
	 * ģ����ѯ����ҳ
	 */
	public String findGoodsByName() {
		// ����Service�еķ���
		// System.out.println("�ؼ��֣�" + searchName);
		if (searchName == null) {
			return "noData";
		} else {
			PageBean pageBean = goodsService.findAllGoodsByName(searchName,
					currentPage);
			// ���������ֵջ��
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			// ActionContext.getContext().put("sN", "ABC");
			// System.out.println("�ؼ���222��" + searchName);
			if (pageBean.getList().size() == 0) {
				return "noData";
			} else {
				return "findSearchSuccess";
			}
		}
	}

}
