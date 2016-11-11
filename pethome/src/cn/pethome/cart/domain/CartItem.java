package cn.pethome.cart.domain;

import java.io.Serializable;

import cn.pethome.goods.domain.Goods;

/**
 * ��Ʒ��Ŀ�࣬�ǹ��ﳵ���������
 * 
 * @author Administrator
 *
 */
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Goods goods;// �����Ʒ���࣬������Ҫ�����ͼƬ���۸���Ʒ��������
	private Integer num;// ��Ʒ������
	private double subtotal;// ������Ʒ�еļ۸�
	// ����get set����

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * ������Ʒ��Ŀ��С��subtotal
	 * 
	 * @return
	 */
	public Double getSubtotal() {
		return subtotal = num * goods.getGprice();
	}
}
