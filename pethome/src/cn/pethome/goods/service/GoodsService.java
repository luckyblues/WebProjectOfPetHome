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
		int pageSize = 12;
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

	public PageBean findGoodsByCid(Integer cid, Integer currentPage) {
		// ����һ��PageBean����
		PageBean<Goods> pageBean = new PageBean<>();
		// ��װpageBean���������
		// ��װ��ǰҳ����
		pageBean.setCurrentPage(currentPage);
		// ��װÿҳ��ʾ��Ʒ����
		int pageSize = 15;
		pageBean.setPageSize(pageSize);

		// ��װ���ݿ����Լ������µ���Ʒ�ܼ�¼��
		int totalCount = goodsDao.findCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		// ��װ��ҳ��
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿһҳ�ĵ�һ�������Ǽ�
		int startIndex = (currentPage - 1) * pageSize;

		// ��ҳ��ѯ�ķ���,���ص���List����
		List<Goods> list = goodsDao.findGoodsByCid(cid, startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ���ݶ�����������ֲ�ѯ��ҳʮ����Ʒ��¼
	 * 
	 * @param cid
	 * 
	 * @param scid
	 * @param currentPage
	 * 
	 * @return
	 */
	public PageBean findHotGoodsByscid(Integer scid, Integer currentPage) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);

		int totalCount = goodsDao.findHotGoodsCount(scid);
		pageBean.setTotalCount(totalCount);
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int startIndex = (currentPage - 1) * pageSize;
		List<Goods> hlist = goodsDao.findHotGoodsByScid(scid, startIndex, pageSize);
		pageBean.setList(hlist);
		return pageBean;
	}
}
