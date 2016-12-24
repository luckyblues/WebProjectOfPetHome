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
 * 后台管理员管理商品的表现层
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

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
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
		if (pageBean.getList().size() == 0) {
			return "noData";
		} else {
			// 将取出的PageBean对象保存在值栈中
			ActionContext.getContext().getValueStack()
					.set("pageBean", pageBean);
			// 将存入值栈的数据带到findAllAdminGoods对应的物理界面
			return "findSuccess";
		}
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
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/petimage");
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
			goods.setGimage("petimage/" + uploadFileName);
		}
		// 保存商品的二级分类的所属外键
		CategorySecond categorySecond = categorySecondService.findByScid(scid);
		goods.setCategorySecond(categorySecond);
		// 调用Service中的保存方法
		boolean addSuccess = goodsService.save(goods);
		if (addSuccess) {
			return "saveSuccess";
		} else {
			return "addFail";
		}
	}

	/**
	 * 后台删除商品
	 */

	public String delGoods() {
		// 如果删除的话，就要先根据id查询商品对象
		goods = goodsService.findDetailGoods(goods.getGid());
		// 获得存放在数据库中图片名字
		String path = goods.getGimage();
		if (path != null) {
			// 获取磁盘路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);
			// 删除指定路径下的图片
			file.delete();
		}
		// 调用Service中的delete方法
		boolean delSuccess = goodsService.delete(goods);
		if (delSuccess) {
			return "delSuccess";
		} else {
			return "delFail";
		}
	}

	/**
	 * 编辑商品，跳转到修改商品的页面
	 */
	public String editGoods() {
		// 先根据商品id查询商品对象，带到下一页面
		goods = goodsService.findDetailGoods(goods.getGid());
		// 将所有的二级分类查询出来，并把数据带到修改商品的页面
		List<CategorySecond> list = categorySecondService.findAll();
		// 将二级分类数据存入值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		if (goods == null && list.size() == 0) {
			return "noData";
		} else {
			return "editGoods";
		}
	}

	/**
	 * 根据修改商品页面提交过来的信息修改商品信息
	 * 
	 * @throws IOException
	 */
	public String updateGoods() throws IOException {
		goods.setGdate(new Date());
		// 获取数据库中商品的名字
		if (upload != null) {
			// 获取服务器中商品的全路径
			String getPath = ServletActionContext.getServletContext()
					.getRealPath("/" + goods.getGimage());
			// 创建文件
			File file = new File(getPath);
			// // 删掉原来路径下的图片
			// file.delete();
			// 获取服务器路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/petimage");
			// 创建新的文件
			File disk = new File(realPath + "//" + uploadFileName);
			// 判断该图片文件是否存在，如果不存在，则创建文件
			if (disk.getParentFile().exists()) {
				disk.getParentFile().mkdirs();
			}
			// 如果存在的话，则把disk复制到file原文件下
			FileUtils.copyFile(upload, disk);
			// 封装数据库中图片的名字
			goods.setGimage("petimage/" + uploadFileName);
		}
		CategorySecond categorySecond = categorySecondService.findByScid(scid);
		goods.setCategorySecond(categorySecond);

		// 调用Service中的update方法保存商品新的信息
		boolean updateSuccess = goodsService.update(goods);
		if (updateSuccess) {
			return "updateSuccess";
		} else {
			return "updateFail";
		}

	}
}
