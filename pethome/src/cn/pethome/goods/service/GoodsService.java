package cn.pethome.goods.service;

import java.util.List;

import cn.pethome.goods.dao.GoodsDao;
import cn.pethome.goods.domain.Goods;
import cn.pethome.util.PageBean;

/**
 * ��Ʒ��ҵ���ʵ��
 * 
 * @author Administrator
 *
 */
public class GoodsService {
	/**
	 * ��GoodsService��ע��GoodsSDao,���ṩset����
	 */
	private GoodsDao goodsDao;

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	/**
	 * ���ݶ��������������ѯ��ҳʮ����Ʒ��¼
	 * 
	 * @param cid
	 * 
	 * @param scid
	 * 
	 * @return
	 */
	public List<Goods> findHotGoodsByCsid(Integer cid) {
		List<Goods> hlist = goodsDao.findHotGoodsByScid(cid);
		return hlist;
	}

	/**
	 * ҵ���߼��� ������Ʒ�������Ҹ���Ʒ�ľ���ҳ��
	 * 
	 * @param gid
	 * @return
	 */
	public Goods findDetailGoods(Integer gid) {

		return goodsDao.findDetailGoods(gid);
	}

	/**
	 * ҵ���߼��� ���ݶ��������scid��ѯ���ö��������µ�������Ʒ�����ҷ�ҳ��ʾ ��ҵ����з�װ����Ҫ�ķ�ҳ����
	 * 
	 * @param currentPage
	 * 
	 * @return
	 */

	public PageBean findGoodsByScid(Integer scid, Integer currentPage) {
		// ����PageBean���󣬲�������Ӧ�Ĳ�����ֵ
		PageBean pageBean = new PageBean();
		// ΪpageBean�������õ�ǰҳcurrentpage
		pageBean.setCurrentPage(currentPage);
		// ΪpageBean��������pageSize,��ÿҳ��ʾ25����Ʒ����
		int pageSize = 25;
		pageBean.setPageSize(pageSize);
		// ΪpageBean��������totalCount�ܼ�¼��
		int totalCount = goodsDao.findGoodsCount(scid);
		pageBean.setTotalCount(totalCount);
		// ΪpageBean��������totalPage��ҳ��
		int totalPage;
		/*
		 * ����ܼ�¼��totalCount��ÿҳ�ļ�¼��pageSizeȡ��Ϊ���Ļ�totalPage������������Ľ�� ����������ǵĻ����ϼ�1
		 */
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}

		pageBean.setTotalPage(totalPage);

		// ���õ�ǰҳ�ĵ�һ�������ǵڶ���������
		int startIndex = (currentPage - 1) * pageSize;
		// ��װ������Ʒ����,���ݶ��������scid��currentPage��ǰҳ����ѯ
		List<Goods> glist = goodsDao.findGoodsByScid(scid, startIndex, pageSize);
		pageBean.setList(glist);
		// ����װ�õ�pageBean���󷵻�
		return pageBean;
	}
}
