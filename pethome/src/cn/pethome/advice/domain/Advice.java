package cn.pethome.advice.domain;

import java.util.Date;

import cn.pethome.user.domain.User;

/**
 * ����ʵ����
 * 
 * @author Administrator
 *
 */
public class Advice {

	private Integer aid;
	private String content;// ��������
	private Date adate;// �ύ�����ʱ��
	// �������û�����Ϊ���
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
