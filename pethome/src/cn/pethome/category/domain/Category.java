package cn.pethome.category.domain;

import java.util.HashSet;
import java.util.Set;

import cn.pethome.categorysecond.domain.CategorySecond;

/**
 * һ�������ʵ����
 * 
 * @author Administrator
 *
 */
public class Category {

	private Integer cid;// һ�����������
	private String cname;// һ�����������
	// һ�����������кܶ�������࣬��set����,���ṩget set����

	private Set<CategorySecond> categorySecond = new HashSet<>();

	public Set<CategorySecond> getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(Set<CategorySecond> categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
