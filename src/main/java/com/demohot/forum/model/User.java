package com.demohot.forum.model;

import org.apache.solr.client.solrj.beans.Field;

public class User {
	@Field
	private String id;
	@Field
	private String username;
	@Field
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
