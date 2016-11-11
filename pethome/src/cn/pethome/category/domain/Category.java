package cn.pethome.category.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.pethome.categorysecond.domain.CategorySecond;

/**
 * 一级分类的实体类
 * 
 * @author Administrator
 *
 */
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer cid;// 一级分类的主键
	private String cname;// 一级分类的名字
	// 一级分类下面有很多二级分类，用set集合,并提供get set方法

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
