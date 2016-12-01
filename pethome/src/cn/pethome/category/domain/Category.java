package cn.pethome.category.domain;

import java.util.HashSet;
import java.util.Set;

import cn.pethome.categorysecond.domain.CategorySecond;

/**
 * 一级分类的实体类
 * 
 * @author Administrator
 *
 */
public class Category {

	private Integer cid;// 一级分类的主键
	private String cname;// 一级分类的名字
	// 一级分类下面有很多二级分类，用set集合,并提供get set方法

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
