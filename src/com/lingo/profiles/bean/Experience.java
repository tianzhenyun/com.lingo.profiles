package com.lingo.profiles.bean;

import java.util.Date;

public class Experience {
	private int id;
	private int pid;
	private String title;
	private String logo;
	private String company;
	private String link;
	private String period;
	private String location;
	private String position;
	private String intro;
	private Date addDate;
	private Date updateDate;

	public Experience(int id, int pid, String title, String logo, String company, String link, String period, String location, String position,
			String intro) {
		this(pid, title, logo, company, link, period, location, position, intro);
		this.id = id;
	}
	public Experience(int pid, String title,String logo, String company, String link, String period, String location, String position,
			String intro) {
		super();
		this.pid = pid;
		this.title = title;
		this.logo = logo;
		this.company = company;
		this.link = link;
		this.period = period;
		this.location = location;
		this.position = position;
		this.intro = intro;
	}
	public Experience(){}
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
