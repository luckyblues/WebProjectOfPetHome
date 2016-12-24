package cn.pethome.goods;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.hibernate.envers.AuditTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pethome.goods.action.GoodsAction;
import cn.pethome.goods.domain.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodsActionTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private GoodsAction goodsAction;
	@Resource
	private Goods goods;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindDetailGoods() {
		// fail("ипн╢й╣ож");
		goods.setGid(1);
		goodsAction.findDetailGoods();
	}

}
