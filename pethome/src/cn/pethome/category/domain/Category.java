package cn.pethome.category.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.pethome.categorysecond.domain.CategorySecond;

/**
 * һ�������ʵ����
 * 
 * @author Administrator
 *
 */
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer cid;// һ�����������
	private String cname;// һ�����������
	// һ�����������кܶ�������࣬��set����,���ṩget set����

	private Set<CategorySecond> categorySeconds = new HashSet<>();

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
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
