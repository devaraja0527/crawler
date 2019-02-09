package com.web.crawler.model;

import java.io.Serializable;

public class CrawlerRequest implements Serializable {
	
	private String url;
	
	private String searchWord;
	
	private int maxPagetoSearch;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getMaxPagetoSearch() {
		return maxPagetoSearch;
	}

	public void setMaxPagetoSearch(int maxPagetoSearch) {
		this.maxPagetoSearch = maxPagetoSearch;
	}

	

}
