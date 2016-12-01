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
 * 后台管理员管理商品的表现层
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
	 * Struts2上传图片的需要的几个属性
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
	 * 注入商品的Service
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
	 * ===================后台 后台查询全部商品
	 */

	public String findAllAdminGoods() {
		// 调用业务逻辑层的查询方法并返回PageBean对象
		PageBean pageBean = goodsService.findAllAdminGoods(currentPage);
		// 将取出的PageBean对象保存在值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 将存入值栈的数据带到findAllAdminGoods对应的物理界面
		return "findAllAdminGoods";

	}

	/**
	 * 跳转到添加商品的页面
	 */
	public String addPage() {
		// 查询所有的二级分类并将数据带到addPage对应的物理视图
		List<CategorySecond> list = categorySecondService.findAll();
		// 保存到值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		// 返回页面
		return "addPage";
	}

	/**
	 * 添加商品
	 * 
	 * @throws IOException
	 */
	public String addGoods() throws IOException {
		goods.setGdate(new Date());
		// 获取图片上传的路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/goodsImage");
		// 判断upload是否为空
		if (upload != null) {
			// 如果不为空则把图片上传到服务器
			File disk = new File(realPath + "//" + uploadFileName);
			// 判断文件是否存在
			if (!disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			// 把文件copy到disk中
			FileUtils.copyFile(upload, disk);
			// 将图片封装
			goods.setGimage(uploadFileName);
		}
		// 保存
		goodsService.save(goods);
		return "addGoods";
	}

}
