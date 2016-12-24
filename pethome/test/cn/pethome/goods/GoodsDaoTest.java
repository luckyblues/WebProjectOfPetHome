package cn.pethome.goods;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pethome.goods.dao.GoodsDao;
import cn.pethome.goods.domain.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodsDaoTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private GoodsDao goodsDao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindDetailGoods() {
		// fail("尚未实现");
		Goods goods = goodsDao.findDetailGoods(1);
		System.out.println("=====测试商品详情" + goods.getGname() + goods.getGdesc());
	}

	@Test
	public void testFindGoodsByScid() {
		// fail("尚未实现");
		List<Goods> list = goodsDao.findGoodsByScid(1, 0, 8);
		System.out.println("=====测试二级分类编号为1下的商品" + list.size());
	}

	@Test
	public void testFindHotGoods() {
		// fail("尚未实现");
		List<Goods> list = goodsDao.findHotGoods();
		System.out.println("======热卖商品有多少" + list.size());
	}

	@Test
	public void testFindAllAdminGoods() {
		// fail("尚未实现");
		List<Goods> list = goodsDao.findAllAdminGoods(0, 8);
		System.out.println("=====后台所有的商品" + list.size());
	}

}
