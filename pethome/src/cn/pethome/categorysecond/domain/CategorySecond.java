package cn.pethome.categorysecond.domain;

import java.util.HashSet;
import java.util.Set;

import cn.pethome.category.domain.Category;
import cn.pethome.goods.domain.Goods;

/**
 * 二级分类实体类
 * 
 * @author Administrator
 *
 */
public class CategorySecond {
	private Integer scid;// 二级分类的主键
	private String scname;// 二级分类的名称
	private String scimg;// 二级分类的图片
	// 二级分类和一级分类的关系,二级分类的外键是一级分类的主键，是多对一关系
	private Category category;// 所属一级分类的对象
	
	// 二级分类下有多个商品集合,并提供getset方法
	private Set<Goods> goodlist = new HashSet<Goods>();

	public Set<Goods> getGoodlist() {
		return goodlist;
	}

	public void setGoodlist(Set<Goods> goodlist) {
		this.goodlist = goodlist;
	}

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getScimg() {
		return scimg;
	}

	public void setScimg(String scimg) {
		this.scimg = scimg;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}