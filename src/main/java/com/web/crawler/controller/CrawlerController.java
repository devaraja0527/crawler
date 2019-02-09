package com.web.crawler.controller;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.crawler.model.CrawlerRequest;
import com.web.crawler.util.CrawlerUtil;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@RestController
public class CrawlerController {
	
	private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/crawler", method = RequestMethod.GET)
	public String getCrawler(@RequestBody CrawlerRequest crawlerRequest) {
		
		JSONObject finalObjectReturn = new JSONObject();
		JSONArray arrayOfLinks = new JSONArray();
		
		final String url = crawlerRequest.getUrl();
		try
        {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			
			if(connection.response().statusCode() == 200) {
                System.out.println("Connection Established, Received web page at " + url);
            }
			
			if(!connection.response().contentType().contains("text/html")) {
	                System.out.println("Retrieved something other than HTML");
	                finalObjectReturn.put("status",HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
	            	finalObjectReturn.put("code",HttpStatus.SERVICE_UNAVAILABLE.value());
	            	finalObjectReturn.put("message","Retrieved something other than HTML..!");
	            	return  finalObjectReturn.toJSONString();
	         }
			
			Elements linksOnPage = htmlDocument.select("a[href]");
			System.out.println("Found (" + linksOnPage.size() + ") links");
			
			for(Element link : linksOnPage) {
				JSONObject linkOBJ = new JSONObject();
				linkOBJ.put("link", link.absUrl("href"));
				arrayOfLinks.add(linkOBJ);
			}
			
			finalObjectReturn.put("status",HttpStatus.OK.getReasonPhrase());
	    	finalObjectReturn.put("code",HttpStatus.OK.value());
	    	finalObjectReturn.put("links",arrayOfLinks);
			return finalObjectReturn.toJSONString();
	    	
        } catch(Exception ioe) {
        	ioe.printStackTrace();
        	finalObjectReturn.put("status",HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
        	finalObjectReturn.put("code",HttpStatus.SERVICE_UNAVAILABLE.value());
        	finalObjectReturn.put("error", ioe.getMessage());
        	return  finalObjectReturn.toJSONString();
        }
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchcrawler", method = RequestMethod.GET)
	public String searchWord(@RequestBody CrawlerRequest crawlerRequest) {
		JSONObject finalObjectReturn = new JSONObject();
		
		final int maxPagestoSearch = crawlerRequest.getMaxPagetoSearch();
		final String url = crawlerRequest.getUrl();
		final String searchWord = crawlerRequest.getSearchWord();
		CrawlerUtil crawlerUtil = new CrawlerUtil();
		try {
			
			final String foundUrl = crawlerUtil.search(url, searchWord, maxPagestoSearch);
			
			if(foundUrl != null) {
				
				finalObjectReturn.put("status",HttpStatus.OK.getReasonPhrase());
		    	finalObjectReturn.put("code",HttpStatus.OK.value());
		    	finalObjectReturn.put("foundUrl",foundUrl);
		    	
			} else{
				finalObjectReturn.put("status",HttpStatus.NOT_FOUND.getReasonPhrase());
		    	finalObjectReturn.put("code",HttpStatus.NOT_FOUND.value());
		    	finalObjectReturn.put("message","Search word not found with in the page Limit..!");
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
        	finalObjectReturn.put("status",HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
        	finalObjectReturn.put("code",HttpStatus.SERVICE_UNAVAILABLE.value());
        	finalObjectReturn.put("error", ioe.getMessage());
        	return  finalObjectReturn.toJSONString();
		}
		return finalObjectReturn.toJSONString();
	}
	
}
