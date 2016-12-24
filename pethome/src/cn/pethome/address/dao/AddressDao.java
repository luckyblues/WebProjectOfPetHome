package cn.pethome.address.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pethome.address.domain.Address;
import cn.pethome.util.PageCallBackImpl;

public class AddressDao extends HibernateDaoSupport {

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean saveUserInfo(Address address) {
		this.getHibernateTemplate().save(address);
		return true;
	}

	/**
	 * 根据用户查找该用户有多少条地址
	 * 
	 * @param uid
	 * @return
	 */
	public int findCount(Integer uid) {
		String hql = "select count(*) from Address a where a.user.uid=?";
		System.out.println(hql);
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null) {
			return list.get(0).intValue();
		}
		System.out.println(list.size());
		return 0;
	}

	/**
	 * 查看地址并分页
	 * 
	 * @param uid
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Address> findAllAddress(Integer uid, int startIndex,
			int pageSize) {
		String hql = "from Address a where a.user.uid=?";
		List<Address> list = this.getHibernateTemplate().execute(
				new PageCallBackImpl<Address>(hql, new Object[] { uid },
						startIndex, pageSize));
		return list;
	}

	/**
	 * 根据id查找地址
	 * 
	 * @param addid
	 * @return
	 */
	public Address findByAddid(Integer addid) {
		return this.getHibernateTemplate().get(Address.class, addid);
	}

	/**
	 * 删除地址
	 * 
	 * @param address
	 * @return
	 */
	public boolean delete(Address address) {
		this.getHibernateTemplate().delete(address);
		return true;
	}

	/**
	 * 修改收货信息
	 * 
	 * @param address
	 * @return
	 */
	public boolean updateAddress(Address address) {
		this.getHibernateTemplate().update(address);
		return true;
	}

	/**
	 * 
	 * 获取某个用户的地址
	 * 
	 * @param uid
	 * @return
	 */
	public List<Address> findByDefault(int uid) {
		String hql = "from Address a where a.user.uid=?";
		List<Address> list = this.getHibernateTemplate().find(hql, uid);
		return list;

	}

}
