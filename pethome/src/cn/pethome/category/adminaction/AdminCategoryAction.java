package cn.pethome.category.adminaction;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.category.domain.Category;
import cn.pethome.category.service.CategoryService;

/**
 * 后台一级分类管理的表现层
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
	 * 注入CategoryService
	 */
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * findAllCategory方法跳转到显示左右一级分类列表的页面
	 */

	public String findAllAdminCategory() {
		// 调用adminService的方法返回集合，并将结果保存在值栈中
		List<Category> lists = categoryService.findAllCategory();
		if (lists.size() == 0) {
			return "noData";
		} else {
			// 保存在值栈中
			ActionContext.getContext().getValueStack().set("lists", lists);
			// 将值栈中的数据带到findAllCategory对应的物理界面
			return "findAllAdminCategory";
		}
	}

	/**
	 * 添加一级分类
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
	 * 后台删除一级分类
	 */
	public String delCategory() {
		// 根据id查询出该一级分类
		category = categoryService.findByCid(category.getCid());
		// 将该一级分类删除
		boolean delSuccess = categoryService.delete(category);
		if (delSuccess) {
			return "delCategory";
		} else {
			return "delFail";
		}
	}

	/**
	 * 后台根据一级分类id查询该一级分类并显示
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
	 * 后台修改一级分类名称功能
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
