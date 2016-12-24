package cn.pethome.goods.adminGoodsaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.categorysecond.service.CategorySecondService;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;
import cn.pethome.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨����Ա������Ʒ�ı��ֲ�
 * 
 * @author Administrator
 * 
 */
public class AdminGoodsAction extends ActionSupport implements
		ModelDriven<Goods> {

	private Goods goods = new Goods();

	public Goods getModel() {
		return goods;
	}

	private Integer currentPage;
	private Integer scid;

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Struts2�ϴ�ͼƬ����Ҫ�ļ�������
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * ע����Ʒ��Service
	 */
	private GoodsService goodsService;
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * ===================��̨ ��̨��ѯȫ����Ʒ
	 */

	public String findAllAdminGoods() {
		// ����ҵ���߼���Ĳ�ѯ����������PageBean����
		PageBean pageBean = goodsService.findAllAdminGoods(currentPage);
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// ��ȡ����PageBean���󱣴���ֵջ��
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			// ������ֵջ�����ݴ���findAllAdminGoods��Ӧ���������
			return "findSuccess";
		}
	}

	/**
	 * ��ת�������Ʒ��ҳ��
	 */
	public String addPage() {
		// ��ѯ���еĶ������ಢ�����ݴ���addPage��Ӧ��������ͼ
		List<CategorySecond> list = categorySecondService.findAll();
		// ���浽ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);
		// ����ҳ��
		return "addPage";
	}

	/**
	 * �����Ʒ
	 * 
	 * @throws IOException
	 */
	public String addGoods() throws IOException {
		goods.setGdate(new Date());

		// ��ȡͼƬ�ϴ���·��
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/petimage");
		// �ж�upload�Ƿ�Ϊ��
		if (upload != null) {
			// �����Ϊ�����ͼƬ�ϴ���������
			File disk = new File(realPath + "//" + uploadFileName);
			// �ж��ļ��Ƿ����
			if (!disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			// ���ļ�copy��disk��
			FileUtils.copyFile(upload, disk);
			// ��ͼƬ��װ
			goods.setGimage("petimage/" + uploadFileName);
		}
		// ������Ʒ�Ķ���������������
		CategorySecond categorySecond = categorySecondService.findByScid(scid);
		goods.setCategorySecond(categorySecond);
		// ����Service�еı��淽��
		boolean addSuccess = goodsService.save(goods);
		if (addSuccess) {
			return "saveSuccess";
		} else {
			return "addFail";
		}
	}

	/**
	 * ��̨ɾ����Ʒ
	 */

	public String delGoods() {
		// ���ɾ���Ļ�����Ҫ�ȸ���id��ѯ��Ʒ����
		goods = goodsService.findDetailGoods(goods.getGid());
		// ��ô�������ݿ���ͼƬ����
		String path = goods.getGimage();
		if (path != null) {
			// ��ȡ����·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);
			// ɾ��ָ��·���µ�ͼƬ
			file.delete();
		}
		// ����Service�е�delete����
		boolean delSuccess = goodsService.delete(goods);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}
	}

	/**
	 * �༭��Ʒ����ת���޸���Ʒ��ҳ��
	 */
	public String editGoods() {
		// �ȸ�����Ʒid��ѯ��Ʒ���󣬴�����һҳ��
		goods = goodsService.findDetailGoods(goods.getGid());
		// �����еĶ��������ѯ�������������ݴ����޸���Ʒ��ҳ��
		List<CategorySecond> list = categorySecondService.findAll();
		// �������������ݴ���ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);
		if (goods == null && list.size() == 0) {
			return "noData";
		} else {
			return "editGoods";
		}
	}

	/**
	 * �����޸���Ʒҳ���ύ��������Ϣ�޸���Ʒ��Ϣ
	 * 
	 * @throws IOException
	 */
	public String updateGoods() throws IOException {
		goods.setGdate(new Date());
		// ��ȡ���ݿ�����Ʒ������
		if (upload != null) {
			// ��ȡ����������Ʒ��ȫ·��
			String getPath = ServletActionContext.getServletContext()
					.getRealPath("/" + goods.getGimage());
			// �����ļ�
			File file = new File(getPath);
			// // ɾ��ԭ��·���µ�ͼƬ
			// file.delete();
			// ��ȡ������·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/petimage");
			// �����µ��ļ�
			File disk = new File(realPath + "//" + uploadFileName);
			// �жϸ�ͼƬ�ļ��Ƿ���ڣ���������ڣ��򴴽��ļ�
			if (disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			// ������ڵĻ������disk���Ƶ�fileԭ�ļ���
			FileUtils.copyFile(upload, disk);
			// ��װ���ݿ���ͼƬ������
			goods.setGimage("petimage/" + uploadFileName);
		}
		CategorySecond categorySecond = categorySecondService.findByScid(scid);
		goods.setCategorySecond(categorySecond);

		// ����Service�е�update����������Ʒ�µ���Ϣ
		boolean updateSuccess = goodsService.update(goods);
		if (updateSuccess) {
			return "updateSuccess";
		} else {
			return "updateFail";
		}

	}
}
