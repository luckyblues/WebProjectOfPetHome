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
public class AdminCategoryAction extends ActionSupport implements
		ModelDriven<Category> {
	private Category category = new Category();

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
		if (lists.size() == 0) {
			return "noData";
		} else {
			// ������ֵջ��
			ActionContext.getContext().getValueStack().set("lists", lists);
			// ��ֵջ�е����ݴ���findAllCategory��Ӧ���������
			return "findAllAdminCategory";
		}
	}

	/**
	 * ���һ������
	 */
	public String addCategory() {
		boolean addSuccess = categoryService.save(category);
		if (addSuccess) {
			return "addCategory";
		} else {
			return "addFail";
		}
	}

	/**
	 * ��̨ɾ��һ������
	 */
	public String delCategory() {
		// ����id��ѯ����һ������
		category = categoryService.findByCid(category.getCid());
		// ����һ������ɾ��
		boolean delSuccess = categoryService.delete(category);
		if (delSuccess) {
			return "delCategory";
		} else {
			return "delFail";
		}
	}

	/**
	 * ��̨����һ������id��ѯ��һ�����ಢ��ʾ
	 */
	public String findByCid() {
		category = categoryService.findByCid(category.getCid());
		if (category == null) {
			return "noData";
		} else {
			return "findByCid";
		}
	}

	/**
	 * ��̨�޸�һ���������ƹ���
	 */
	public String updateCategory() {
		boolean updateSuccess = categoryService.update(category);
		if (updateSuccess) {
			return "updateCategory";
		} else {
			return "updateFail";
		}

	}
}
