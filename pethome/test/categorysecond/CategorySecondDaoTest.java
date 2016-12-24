package categorysecond;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pethome.address.domain.Address;
import cn.pethome.category.domain.Category;
import cn.pethome.categorysecond.dao.CategorySecondDao;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.user.domain.User;
import cn.pethome.util.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CategorySecondDaoTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private CategorySecondDao categorySecondDao;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testFindAllCategorySecond() {
		List<CategorySecond> list = categorySecondDao.findAllCategorySecond(0,
				8);
		System.out.println("----------���Զ��������һҳ��ʾ������----------" + list.size());
	}

	@Test
	public void testSave() {
		Category category = new Category();
		category.setCid(1);
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setScname("����");
		categorySecond.setCategory(category);
		categorySecond.setScimg("222");
		categorySecondDao.save(categorySecond);
		System.out.println("----------��ӳɹ�----------");
	}

	// @Test
	// public void testDelete() {
	// Category category = new Category();
	// category.setCid(1);
	// CategorySecond categorySecond = new CategorySecond();
	// categorySecond.setScid(30);
	// categorySecond.setCategory(category);
	// categorySecondDao.delete(categorySecond);
	// System.out.println("----------ɾ���ɹ�----------");
	// }

	 @Test
	 public void testUpdate(){
	 Category category = new Category();
	 category.setCid(1);
	 CategorySecond categorySecond = new CategorySecond();
	 categorySecond.setScid(31);
	 categorySecond.setScname("����3");
	 categorySecond.setScimg("3331");
	 categorySecond.setCategory(category);
	 categorySecondDao.update(categorySecond);
	 System.out.println("----------�޸ĳɹ�----------");
	 }

}
