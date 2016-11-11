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
		int pageSize = 12;
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

	public PageBean findGoodsByCid(Integer cid, Integer currentPage) {
		// 创建一个PageBean对象
		PageBean<Goods> pageBean = new PageBean<>();
		// 封装pageBean对象的属性
		// 封装当前页属性
		pageBean.setCurrentPage(currentPage);
		// 封装每页显示商品数量
		int pageSize = 15;
		pageBean.setPageSize(pageSize);

		// 封装数据库中以及分类下的商品总记录数
		int totalCount = goodsDao.findCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每一页的第一条数据是几
		int startIndex = (currentPage - 1) * pageSize;

		// 分页查询的方法,返回的是List类型
		List<Goods> list = goodsDao.findGoodsByCid(cid, startIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据二级分类的名字查询首页十条商品记录
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
