package com.lingo.profiles.bean;

import java.util.Date;

public class Living {
	private int id;
	private int pid;
	private String title;
	private String content;
	private Date addDate;
	private Date updateDate;
	
	public Living(int id, int pid, String title, String content) {
		this(pid, title, content);
		this.id = id;
	}
	public Living(int pid, String title, String content) {
		super();
		this.pid = pid;
		this.title = title;
		this.content = content;
	}
	public Living(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
