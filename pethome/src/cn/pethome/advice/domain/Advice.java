package cn.pethome.advice.domain;

import java.util.Date;

import cn.pethome.user.domain.User;

/**
 * 建议实体类
 * 
 * @author Administrator
 *
 */
public class Advice {

	private Integer aid;
	private String content;// 建议内容
	private Date adate;// 提交建议的时间
	// 所属的用户，即为外键
	private User user;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
