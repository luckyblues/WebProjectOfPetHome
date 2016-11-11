package cn.pethome.cart.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵʵ���࣬��Ϊ���ﳵ�����ŵ�����Ʒ��Ŀ����Ǯ����������������ֻ��һ�����ﳵ����,�Ǵ����seesion���е�
 * 
 * @author Administrator ʵ�����л��ͷ����л��Ľӿ�
 *
 */
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ��Ʒ��Ŀ����Ҫ�ü��������,ʹ��map�ļ�ֵ�Ե���ʽ�����
	 * 
	 * Ϊʲôʹ��LinkedhashMap? ��ΪHashMap������ģ���LinkedHaspMap����jdk1.4֮����ӵ�ʵ�ֵ�����Ľ�ϣ�
	 * ������Ϊ��Ҫ�Լ�ֵ�Ե���ʽ�洢��Ʒ��Ŀ����������ѡ��LinkedHashMap
	 * 
	 */

	private Map<Integer, CartItem> map = new LinkedHashMap<>();

	private double totalamount;// ������Ʒ��Ŀ����������ܽ����ṩget����

	public Double getTotalamount() {
		return totalamount;
	}

	/*
	 * Ϊ�˷����ڽ����ϱ�������map��Value����CartItemת����Collection�ĵ��м���
	 * ������getCartItems˵����Cart������һ��cartItems�����ԣ����������һ����������ŵ�����Ʒ�ĸ�������
	 */
	public Collection<CartItem> getCartItems() {
		// ֱ�ӷ���Collection����
		return map.values();

	}

	/**
	 * ���ﳵ�еĲ�����1.��ӵ����ﳵ��2.ɾ��ĳ����Ʒ��Ŀ��3.��չ��ﳵ
	 */

	/*
	 * 1����Ʒ��Ŀ��ӵ����ﳵ����: ����������Ʒ��ʱ���ڹ��ﳵ�����Ѿ�����һ����ͬ����Ʒ�����ܽ������ԭ���ܽ��Ļ�����+������ӵ���Ʒ���ܽ�
	 * ���ܽ��=ԭ����subtotal+���ڵ�subtotal
	 */
	public void putCart(CartItem cartItem) {
		/**
		 * �����Ʒ����Ϊ�յĻ�����˵�����ﳵ����û�и���Ʒ����
		 */

		Integer gid = cartItem.getGoods().getGid();// �����Ʒ��������Ϊ����Ҫ�жϹ��ﳵ���Ƿ��и���Ʒ

		// ��������Ļ�˵��ԭ�����ﳵ���Ѿ����˸���Ʒ�����ܼ�Ϊԭ�����ܼ�+����ӵ���Ʒ��С��
		if (map.containsKey(gid)) {
			// ���ԭ���ĸ���������Ʒ
			CartItem cartItem_old = map.get(gid);
			// �����ԭ���������������ڵ�����=���ڵ�������

			cartItem_old.setNum(cartItem_old.getNum() + cartItem.getNum());

		} else {
			// �����ﳵ�в���������Ʒ����Ѹ���Ʒ���빺�ﳵ��
			map.put(gid, cartItem);
		}
		// �����ܽ��
		totalamount = totalamount + cartItem.getSubtotal();

	}

	/**
	 * 2.������Ʒ����ɾ��ĳ����Ʒ
	 */
	public void deleteOneGoods(Integer gid) {
		// ���ݸ�CartItem ��Ӧ��key����key��Ϊ��Ʒ������ɾ������Ʒ��Ŀ
		// map.remove���صĶ�����CartItem����
		CartItem cartItem = map.remove(gid);
		// �ܽ��=�ܽ��-ɾ���ĸ���Ʒ��С�ƽ��
		totalamount = totalamount - cartItem.getSubtotal();
	}

	/**
	 * ��չ��ﳵ
	 */
	public void deleteAll() {
		// �����clear()����
		map.clear();
		// �ܽ������Ϊ0��
		totalamount = 0.0;
	}

}
