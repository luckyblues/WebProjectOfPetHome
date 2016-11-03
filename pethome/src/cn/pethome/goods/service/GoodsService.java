package cn.pethome.goods.service;

import java.util.List;

import cn.pethome.goods.dao.GoodsDao;
import cn.pethome.goods.domain.Goods;
import cn.pethome.util.PageBean;

/**
 * 商品的业务层实现
 * 
 * @author Administrator
 *
 */
public class GoodsService {
	/**
	 * 在GoodsService中注入GoodsSDao,并提供set方法
	 */
	private GoodsDao goodsDao;

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	/**
	 * 根据二级分类的主键查询首页十条商品记录
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
	 * 业务逻辑层 根据商品主键查找该商品的具体页面
	 * 
	 * @param gid
	 * @return
	 */
	public Goods findDetailGoods(Integer gid) {

		return goodsDao.findDetailGoods(gid);
	}

	/**
	 * 业务逻辑层 根据二级分类的scid查询出该二级分类下的所有商品，并且分页显示 在业务层中封装好需要的分页数据
	 * 
	 * @param currentPage
	 * 
	 * @return
	 */

	public PageBean findGoodsByScid(Integer scid, Integer currentPage) {
		// 构造PageBean对象，并设置相应的参数的值
		PageBean pageBean = new PageBean();
		// 为pageBean对象设置当前页currentpage
		pageBean.setCurrentPage(currentPage);
		// 为pageBean对象设置pageSize,即每页显示25条商品数据
		int pageSize = 25;
		pageBean.setPageSize(pageSize);
		// 为pageBean对象设置totalCount总记录数
		int totalCount = goodsDao.findGoodsCount(scid);
		pageBean.setTotalCount(totalCount);
		// 为pageBean对象设置totalPage总页数
		int totalPage;
		/*
		 * 如果总记录数totalCount和每页的记录数pageSize取余为整的话totalPage就是他们相除的结果 否则就在他们的基础上加1
		 */
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}

		pageBean.setTotalPage(totalPage);

		// 设置当前页的第一条数据是第多少条数据
		int startIndex = (currentPage - 1) * pageSize;
		// 封装最后的商品集合,根据二级分类的scid和currentPage当前页来查询
		List<Goods> glist = goodsDao.findGoodsByScid(scid, startIndex, pageSize);
		pageBean.setList(glist);
		// 将封装好的pageBean对象返回
		return pageBean;
	}
}
