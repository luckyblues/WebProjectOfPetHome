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
 * ��̨��������Action
 * 
 * @author Administrator
 * 
 */
public class AdminCSAction extends ActionSupport implements
		ModelDriven<CategorySecond> {

	private static final long serialVersionUID = 1L;
	/**
	 * ����ǰ̨���ݵ��ϴ����ݣ����ṩset����
	 */
	private File upload;// �ϴ����ļ�
	private String uploadFileName;// ͼƬ������//��ʽΪ���ؼ���+FileName��
	private String uploadContentType;// ͼƬ������

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// ʵ��ģ������
	private CategorySecond categorySecond = new CategorySecond();

	public CategorySecond getModel() {
		return categorySecond;
	}

	// ���ܴ��ݹ�����currentPage,���ṩset��get����
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
	 * ע��CategorySecondService,�����ṩset����
	 */
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	/**
	 * ע��һ�������Service���ṩset����
	 */
	public CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * ����findAllCategorySecond������ѯ���еĶ������࣬����ҳ��ʾ
	 */

	public String findAllCategorySecond() {
		// ����adminService����findAllCategorySecondlist
		PageBean pageBean = categorySecondService
				.findAllCategorySecond(currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// ����ѯ��������洢��ֵջ��
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			return "findSuccess";
		}
	}

	/**
	 * h��̨��ת����Ӷ�������ҳ�棬��������һ���������ݴ���ҳ��
	 * 
	 * @return
	 */
	public String addPage() {
		// ��ѯ���е�һ������
		List<Category> list = categoryService.findAllCategory();
		// ����ѯ�������ݱ�����ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);
		// �����ݴ���ҳ��addPage��Ӧ���������
		return "addPage";

	}

	/**
	 * ��̨��Ӷ�������
	 * 
	 * @throws IOException
	 */
	public String addCategorySecond() throws IOException {
		/**
		 * Struts2ͼƬ�ϴ����ж��ϴ���ͼƬ�Ƿ�Ϊ��
		 */
		// ��ȡ�ϴ�ͼƬ��Ŀ¼
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/petimage");

		if (upload != null) {
			// ����ϴ�ͼƬ��Ϊ�գ����ͼƬ�ϴ���������
			// ����Ŀ���ļ������� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ����
			File disk = new File(realpath + "//" + uploadFileName);
			// �ж��ϴ�Ŀ¼�Ƿ����
			if (!disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			// Struts �ϴ��ļ� �� FileUtils.copyFile,
			// ���ļ�upload ������ disk��,FileUtils����Ҫcommons-io-x.x.x.jar��֧��
			FileUtils.copyFile(upload, disk);
			// ��װ���������ͼƬ����
			categorySecond.setScimg("petimage/" + uploadFileName);
		}
		// ���ö��������е�����һ������
		Category category = categoryService.findByCid(cid);
		if (category != null) {
			categorySecond.setCategory(category);
		}
		// ����Service�еķ���
		boolean addSuccess = categorySecondService.save(categorySecond);
		if (addSuccess) {
			return "addSuccess";
		} else {
			return "addFail";
		}

	}

	/**
	 * ��̨ɾ����������,�Ȳ�ѯid����ɾ��
	 */
	public String delCategorySecond() {
		// �ȸ��ݶ��������id��ȡ�ö���
		categorySecond = categorySecondService.findByScid(categorySecond
				.getScid());
		// ɾ���ϴ���ͼƬ
		String path = categorySecond.getScimg();
		if (path != null) {
			// ��ȡ����·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);
			// ɾ��
			file.delete();
		}
		// �����ҵ��Ķ���ɾ���ö�������
		boolean delSuccess = categorySecondService.delete(categorySecond);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}
	}

	/**
	 * ���ݶ��������id��ѯ�ö�������
	 */
	public String edit() {
		// ����Service�еķ�������id��ѯ��������
		categorySecond = categorySecondService.findByScid(categorySecond
				.getScid());
		// ��ѯ���е�һ������
		List<Category> list = categoryService.findAllCategory();
		if (list.size() == 0) {
			return "noData";
		} else {
			// �����ݱ�����ֵջ��
			ActionContext.getContext().getValueStack().set("list", list);
			return "editSecondLevel";
		}
	}

	/**
	 * �޸Ķ�������
	 * 
	 * @throws IOException
	 */
	public String updateCategorySecond() throws IOException {
		// ��ȡͼƬ�ϴ�·��
		String getPath = ServletActionContext.getServletContext().getRealPath(
				"/" + categorySecond.getScimg());
		// �����ж�
		if (upload != null) {
			File file = new File(getPath);
			// file.delete();
			// ���ͼƬ�ϴ�����������·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/petimage");
			// �����ļ�
			File disk = new File(realPath + "//" + uploadFileName);
			// ��������ڣ��򴴽��µ��ļ�
			if (!disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, disk);
			categorySecond.setScimg("petimage/" + uploadFileName);
		}

		// Ȼ�����Service�з���update���������޸�
		// ����Service�ķ��������޸�
		boolean updateSuccess = categorySecondService.update(categorySecond);
		if (updateSuccess) {
			return "updateSuccess";
		} else {
			return "updateFail";
		}
	}
}
