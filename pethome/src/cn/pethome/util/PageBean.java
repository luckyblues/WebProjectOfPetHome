package cn.pethome.util;

import java.util.List;

/**
 * ��װ��ҳ��ʾ�����ݵ�ʵ����
 * 
 * @author Administrator
 *
 */
public class PageBean<T> {
	private Integer currentPage;// ��ǰҳ
	private Integer pageSize;// ÿҳ��ʾ����������
	private Integer totalCount;// �ܹ��ж���������
	private Integer totalPage;// �ܹ��ж���Ҳ
	private List<T> list;// ��װҪ�ŵĶ��������÷�������ʾ����Ϊ��������кܶ಻ͬ������Ҫ��ҳ�ĵط�

	/**
	 * �ṩget set����
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
