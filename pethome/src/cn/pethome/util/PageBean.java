package cn.pethome.util;

import java.util.List;

/**
 * 封装分页显示的数据的实体类
 * 
 * @author Administrator
 *
 */
public class PageBean<T> {
	private Integer currentPage;// 当前页
	private Integer pageSize;// 每页显示多少条数据
	private Integer totalCount;// 总共有多少条数据
	private Integer totalPage;// 总共有多少也
	private List<T> list;// 封装要放的对象，这里用泛型来表示，因为后面可能有很多不同的类需要分页的地方

	/**
	 * 提供get set方法
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
