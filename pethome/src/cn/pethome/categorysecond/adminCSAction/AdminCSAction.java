package cn.pethome.categorysecond.adminCSAction;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.category.domain.Category;
import cn.pethome.category.service.CategoryService;
import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.categorysecond.service.CategorySecondService;
import cn.pethome.util.PageBean;

/**
 * 后台二级分类Action
 * 
 * @author Administrator
 *
 */
public class AdminCSAction extends ActionSupport implements ModelDriven<CategorySecond> {

	private static final long serialVersionUID = 1L;
	/**
	 * 接受前台传递的上传数据，并提供set属性
	 */
	private File upload;// 上传的文件
	private String uploadFileName;// 图片的名字//格式为表单控件名+FileName；
	private String uploadContentType;// 图片的类型

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// 实现模型驱动
	private CategorySecond categorySecond = new CategorySecond();

	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}

	// 接受传递过来的currentPage,并提供set和get方法
	private Integer currentPage;
	private Integer cid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/*
	 * 注入CategorySecondService,，并提供set方法
	 */
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	/**
	 * 注入一级分类的Service并提供set方法
	 */
	public CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * 根据findAllCategorySecond方法查询所有的二级分类，并分页显示
	 */

	public String findAllCategorySecond() {
		// 调用adminService方法findAllCategorySecondlist
		PageBean pageBean = categorySecondService.findAllCategorySecond(currentPage);
		// 将查询到结果集存储到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAllCategorySecond";
	}

	/**
	 * h后台跳转到添加二级分类页面，并吧所有一级分类数据带到页面
	 * 
	 * @return
	 */
	public String addPage() {
		// 查询所有的一级分类
		List<Category> list = categoryService.findAllCategory();
		// 将查询出的数据保存在值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		// 将数据带到页面addPage对应的物理界面
		return "addPage";

	}

	/**
	 * 后台添加二级分类
	 * 
	 * @throws IOException
	 */
	public String addCategorySecond() throws IOException {
		/**
		 * Struts2图片上传，判断上传的图片是否为空
		 */
		// 获取上传图片的目录
		String realpath = ServletActionContext.getServletContext().getRealPath("/images/categoryImage");

		if (upload != null) {
			// 如果上传图片不为空，则把图片上传到服务器
			// 设置目标文件（根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例）
			File disk = new File(realpath + "//" + uploadFileName);
			// 判断上传目录是否存在
			if (!disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			// Struts 上传文件 用 FileUtils.copyFile,
			// 把文件upload 拷贝到 disk里,FileUtils类需要commons-io-x.x.x.jar包支持
			FileUtils.copyFile(upload, disk);
			// 封装二级分类的图片名字
			categorySecond.setScimg(uploadFileName);
		}
		categorySecond.setCategory(categoryService.findByCid(cid));
		// 调用Service中的方法
		categorySecondService.save(categorySecond);
		return "addCategorySecond";
	}

	/**
	 * 后台删除二级分类,先查询id，在删除
	 */
	public String delCategorySecond() {
		// 先根据二级分类的id获取该对象
		categorySecond = categorySecondService.findByScid(categorySecond.getScid());
		// 删除上传的图片
		String path = categorySecond.getScimg();
		if (path != null) {
			// 获取磁盘路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/images/categoryImage/" + path);
			File file = new File(realPath);
			// 删除
			file.delete();
		}
		// 根据找到的对象删除该二级分类
		categorySecondService.delete(categorySecond);
		return "delCategorySecond";

	}

	/**
	 * 根据二级分类的id查询该二级分类
	 */
	public String edit() {
		// 调用Service中的方法根据id查询二级分类
		categorySecond = categorySecondService.findByScid(categorySecond.getScid());
		// 查询所有的一级分类
		List<Category> list = categoryService.findAllCategory();
		// 将数据保存在值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		return "edit";

	}

	/**
	 * 修改二级分类
	 * 
	 * @throws IOException
	 */
	public String updateCategorySecond() throws IOException {
		// 获取图片上传路径
		String delPath = ServletActionContext.getServletContext()
				.getRealPath("/images/categoryImage/" + categorySecond.getScimg());
		// 进行判断
		if (upload != null) {
			File file = new File(delPath);
			file.delete();
			// 获得图片上传到服务器的路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/images/categoryImage");
			// 创建文件
			File disk = new File(realPath + "//" + uploadFileName);
			// 如果不存在，则创建新的文件
			if (!disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, disk);
			categorySecond.setScimg(uploadFileName);
		}
		// 然后调用Service中放入update方法进行修改
		categorySecondService.update(categorySecond);
		return "updateCategorySecond";

	}
}
