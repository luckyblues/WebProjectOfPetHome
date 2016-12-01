package cn.pethome.admin.domain;

/**
 * 管理员实体类
 * 
 * @author Administrator
 *
 */
public class Admin {
	private Integer aid;// 管理员编号
	private String aname;// 管理员名字
	private String apwd;// 管理员密码

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

}
