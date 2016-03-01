package com.lingo.profiles.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;


public class LinkForm {
	private int id;
	private int pid;
	private String title;
	private String link;
	private byte[] logo;
	private Map<String,String> errors = new HashMap<String,String>();
	
	public LinkForm(int id, int pid, String title, String link, byte[] logo) {
		this(pid,title,link,logo);
		this.id = id;
	}
	public LinkForm(int pid, String title, String link, byte[] logo) {
		super();
		this.pid = pid;
		this.title = title;
		this.link = link;
		this.logo = logo;
	}
	public LinkForm(){}
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getLogoImage()
	{
		return new Base64().encodeToString(this.logo);
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
}
