package com.web.crawler.controller;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.core.Is.is;
import com.web.crawler.model.CrawlerRequest;
import org.jsoup.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerControllerTest {

	CrawlerController crawlerController;
	JSONParser parser;
	
	@Mock
	Connection connection;
	
	@Before 
	public void before() {
		 crawlerController = new CrawlerController();
		 parser = new JSONParser();

	}
	
	
	@Test
	public void getCrawler_200 () throws Exception {
		CrawlerRequest crawlerRequest = new CrawlerRequest();
		crawlerRequest.setUrl("https://github.com");
		final String response = crawlerController.getCrawler(crawlerRequest);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("200", is(json.get("code").toString()));
	}
	
	@Test
	public void getCrawler_with_unknowhost() throws Exception {
		CrawlerRequest crawlerRequest = new CrawlerRequest();
		crawlerRequest.setUrl("https://alarotter.com/");
		final String response = crawlerController.getCrawler(crawlerRequest);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("503", is(json.get("code").toString()));
	}
	
	@Test
	public void getCrawler_IOException() throws Exception {
		Mockito.when(connection.response()).thenThrow(new RuntimeException("Exception during Query Access Client"));
		CrawlerRequest crawlerRequest = new CrawlerRequest();
		crawlerRequest.setUrl("https://github.com");
		final String response = crawlerController.getCrawler(crawlerRequest);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("200", is(json.get("code").toString()));
	}
	
	@Test
	public void searchWord_200 () throws Exception {
		CrawlerRequest crawlerRequest = new CrawlerRequest();
		crawlerRequest.setUrl("https://github.com");
		crawlerRequest.setSearchWord("Git");
		crawlerRequest.setMaxPagetoSearch(4);
		final String response = crawlerController.searchWord(crawlerRequest);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("200", is(json.get("code").toString()));
	}
	
	@Test
	public void searchWord_404 () throws Exception {
		CrawlerRequest crawlerRequest = new CrawlerRequest();
		crawlerRequest.setUrl("https://github.com");
		crawlerRequest.setSearchWord("kiran");
		crawlerRequest.setMaxPagetoSearch(4);
		final String response = crawlerController.searchWord(crawlerRequest);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("404", is(json.get("code").toString()));
	}
	
}
