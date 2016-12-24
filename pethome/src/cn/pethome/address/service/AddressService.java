package cn.pethome.address.service;

import java.util.List;

import cn.pethome.address.dao.AddressDao;
import cn.pethome.address.domain.Address;
import cn.pethome.util.PageBean;

public class AddressService {
	/**
	 * 注入Dao
	 */
	private AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	/**
	 * 添加用户的信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean saveUserInfo(Address address) {
		if (addressDao.saveUserInfo(address)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查看地址
	 * 
	 * @param uid
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllAddress(Integer uid, int currentPage) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int totalCount = addressDao.findCount(uid);
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int startIndex = (currentPage - 1) * pageSize;
		List<Address> list = addressDao.findAllAddress(uid, startIndex,
				pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据id找地址
	 * 
	 * @param addid
	 * @return
	 */
	public Address findByAddid(Integer addid) {
		return addressDao.findByAddid(addid);
	}

	/**
	 * 删除地址
	 * 
	 * @param address
	 * @return
	 */
	public boolean delete(Address address) {
		if (addressDao.delete(address)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 修改收货信息
	 * 
	 * @param address
	 * @return
	 */
	public boolean updateAddress(Address address) {
		if (addressDao.updateAddress(address)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 订单OrderAction中调用了这个方法，获取某个用户的地址
	 * @param uid 
	 * 
	 * @return
	 */
	public List<Address> findByDefault(int uid) {
		return addressDao.findByDefault(uid);
	}

}
