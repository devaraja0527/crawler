package com.web.crawler.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.crawler.model.FileData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReadWriteControllerTest {
	
	FileReadWriteController fileReadWriteController;
	FileData request;
	JSONParser parser;
	
	@Mock
	FileWriter filewriter;
	
	@Before 
	public void before() {
		fileReadWriteController = new FileReadWriteController();
		request = new FileData();
		parser = new JSONParser();
	}
	
	@Test
	public void writeToFile_Success() throws Exception {
		request.setData("Wrinteting Test Data..!");
		request.setPath("src/test/resources/sample1.txt");
		final String response = fileReadWriteController.writeFile(request);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("200", is(json.get("code").toString()));	
	}
	
	@Test
	public void readFile_Success() throws Exception {
		request.setPath("src/test/resources/sample1.txt");
		final String response = fileReadWriteController.readFile(request);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("200", is(json.get("code").toString()));	
	}
	
	@Test
	public void readFile_IOException() throws Exception {
		request.setPath("src/test/resources/sample1.txt");
		final String response = fileReadWriteController.readFile(request);
		System.out.println(response);
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("503", is(json.get("code").toString()));	
	}
	
	
}
