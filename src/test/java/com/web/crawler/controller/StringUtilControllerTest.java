package com.web.crawler.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringUtilControllerTest {

	StringUtilController stringUtilController;
	JSONParser parser;
	
	@Before 
	public void before() {
		stringUtilController = new StringUtilController();
		 parser = new JSONParser();
	}
	
	@Test
	public void getNonRepeatedCharecter_200 () throws Exception {
		
		final String response = stringUtilController.getNonRepeatedCharecter("testginsfhd");
		System.out.println(response);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("e", is(json.get("foundChar").toString()));
	}
	
	
	@Test
	public void getNonRepeatedCharecter_NotFound () throws Exception {
		
		final String response = stringUtilController.getNonRepeatedCharecter("aabbccdd");
		System.out.println(response);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("No Charected Found...!", is(json.get("nocharFound").toString()));
	}
	
}
