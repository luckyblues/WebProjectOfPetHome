package cn.pethome.categorysecond.domain;

import java.util.HashSet;
import java.util.Set;

import cn.pethome.category.domain.Category;
import cn.pethome.goods.domain.Goods;

/**
 * ��������ʵ����
 * 
 * @author Administrator
 *
 */
public class CategorySecond {
	private Integer scid;// �������������
	private String scname;// �������������
	private String scimg;// ���������ͼƬ
	// ���������һ������Ĺ�ϵ,��������������һ��������������Ƕ��һ��ϵ
	private Category category;// ����һ������Ķ���
	
	// �����������ж����Ʒ����,���ṩgetset����
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