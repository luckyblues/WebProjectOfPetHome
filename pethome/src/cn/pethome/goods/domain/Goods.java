package cn.pethome.goods.domain;

import java.util.Date;

import cn.pethome.categorysecond.domain.CategorySecond;

/**
 * 商品实体类
 * 
 * @author Administrator
 *
 */
public class Goods {
	private Integer gid;// 商品主键
	private String gname;// 商品名称
	private String gimage;// 商品图片
	private Double gprice;// 商品价格
	private String gdesc;// 商品描述
	private Integer is_hot;// 商品是否热卖，0表示非热卖，1表示热卖
	private Date gdate;// 商品上架日期

	// 商品和二级分类是多对一关系，并提供getset方法
	private CategorySecond categorySecond;

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGimage() {
		return gimage;
	}

	public void setGimage(String gimage) {
		this.gimage = gimage;
	}

	public Double getGprice() {
		return gprice;
	}

	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}

}
