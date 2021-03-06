﻿package com.lingo.profiles.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListResult<T> extends Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9120922723371978006L;
	/**
	 * return T list
	 */
	private List<T> list;
	public List<T> getList()
	{
		return this.list;
	}
	public void setList(List<T> list)
	{
		this.list= list;
	}
}
