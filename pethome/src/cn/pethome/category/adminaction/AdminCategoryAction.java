package cn.pethome.category.adminaction;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.category.domain.Category;
import cn.pethome.category.service.CategoryService;

/**
 * ��̨һ���������ı��ֲ�
 * 
 * @author Administrator
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	private Category category = new Category();

	@Override
	public Category getModel() {
		return category;
	}

	/**
	 * ע��CategoryService
	 */
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * findAllCategory������ת����ʾ����һ�������б��ҳ��
	 */

	public String findAllAdminCategory() {
		// ����adminService�ķ������ؼ��ϣ��������������ֵջ��
		List<Category> lists = categoryService.findAllCategory();
		// ������ֵջ��
		ActionContext.getContext().getValueStack().set("lists", lists);
		// ��ֵջ�е����ݴ���findAllCategory��Ӧ���������
		return "findAllAdminCategory";

	}

	/**
	 * ���һ������
	 */
	public String addCategory() {
		categoryService.save(category);
		return "addCategory";
	}

	/**
	 * ��̨ɾ��һ������
	 */
	public String delCategory() {
		// ����id��ѯ����һ������
		category = categoryService.findByCid(category.getCid());
		// ����һ������ɾ��
		categoryService.delete(category);
		return "delCategory";
	}

	/**
	 * ��̨����һ������id��ѯ��һ�����ಢ��ʾ
	 */
	public String findByCid() {
		category = categoryService.findByCid(category.getCid());
		return "findByCid";
	}

	/**
	 * ��̨�޸�һ���������ƹ���
	 */
	public String updateCategory() {
		categoryService.update(category);
		return "updateCategory";
	}
}
