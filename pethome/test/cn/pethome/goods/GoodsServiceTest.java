package cn.pethome.goods;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodsServiceTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private GoodsService goodsService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindDetailGoods() {
		// fail("��δʵ��");
		Goods goods = goodsService.findDetailGoods(1);
		System.out.println("=====findDetailGoods���ԣ�" + goods);
	}

	@Test
	public void testFindHotGoods() {
		//fail("��δʵ��");
		List<Goods> list=goodsService.findHotGoods();
		System.out.println("=====findHotGoods���ԣ�"+list.size());
	}

	@Test
	public void testFindNewGoods() {
		//fail("��δʵ��");
		List<Goods> list=goodsService.findNewGoods();
		System.out.println("=====findNewGoods���ԣ�"+list.size());
	}

}
