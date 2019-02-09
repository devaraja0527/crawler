package com.web.crawler.model;

import java.io.Serializable;

public class FileData implements Serializable{

	private String path;
	
	private String data;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
