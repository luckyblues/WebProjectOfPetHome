package cn.pethome.goods.domain;

import java.util.Date;

import cn.pethome.categorysecond.domain.CategorySecond;

/**
 * ��Ʒʵ����
 * 
 * @author Administrator
 *
 */
public class Goods {
	private Integer gid;// ��Ʒ����
	private String gname;// ��Ʒ����
	private String gimage;// ��ƷͼƬ
	private Double gprice;// ��Ʒ�۸�
	private String gdesc;// ��Ʒ����
	private Integer is_hot;// ��Ʒ�Ƿ�������0��ʾ��������1��ʾ����
	private Date gdate;// ��Ʒ�ϼ�����

	// ��Ʒ�Ͷ��������Ƕ��һ��ϵ�����ṩgetset����
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
