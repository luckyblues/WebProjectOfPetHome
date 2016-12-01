package cn.pethome.goods.adminGoodsaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.pethome.categorysecond.domain.CategorySecond;
import cn.pethome.categorysecond.service.CategorySecondService;
import cn.pethome.goods.domain.Goods;
import cn.pethome.goods.service.GoodsService;
import cn.pethome.util.PageBean;

/**
 * ��̨����Ա������Ʒ�ı��ֲ�
 * 
 * @author Administrator
 *
 */
public class AdminGoodsAction extends ActionSupport implements ModelDriven<Goods> {

	private Goods goods = new Goods();

	@Override
	public Goods getModel() {
		return goods;
	}

	private Integer currentPage;

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

	public void setCategorySecondService(CategorySecondService categorySecondService) {
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
		// ��ȡ����PageBean���󱣴���ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ������ֵջ�����ݴ���findAllAdminGoods��Ӧ���������
		return "findAllAdminGoods";

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
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/goodsImage");
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
			goods.setGimage(uploadFileName);
		}
		// ����
		goodsService.save(goods);
		return "addGoods";
	}

}
