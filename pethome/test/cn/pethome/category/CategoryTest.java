package cn.pethome.category;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pethome.category.dao.CategoryDao;
import cn.pethome.category.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CategoryTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private CategoryDao categoryDao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAllCategory() {
		// fail("尚未实现");
		List<Category> list = categoryDao.findAllCategory();
		System.out.println(list.size());
	}

	@Test
	public void testFindAllAdminCategory() {
		List<Category> list = categoryDao.findAllAdminCategory();
		if (list != null) {
			System.out.println("findAllAdminCategory正确=====" + list.size());
		}
	}

	@Test
	public void testSave() {
		// fail("尚未实现");
		Category category = new Category();
		category.setCname("狗狗沐浴");
		categoryDao.save(category);
	}

	@Test
	public void testFindByCid() {
		Category category = categoryDao.findByCid(1);
		if (category != null) {
			System.out.println("测试正确" + category);
		}
		// fail("尚未实现");
	}

	@Test
	public void testDelete() {
		Category category = new Category();
		category.setCname("111");
		categoryDao.delete(category);
		// fail("尚未实现");
	}

}
