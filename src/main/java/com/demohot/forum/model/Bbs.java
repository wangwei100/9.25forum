package com.demohot.forum.model;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class Bbs {
	@Field
	private String id;
	@Field
	private String user_id;
	@Field
	private String title;
	@Field
	private String content;
	@Field
	private Date time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
