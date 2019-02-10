package com.web.crawler.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.web.crawler.model.Error;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Matchers.anyString;

import com.web.crawler.model.Response;
import com.web.crawler.services.ProductsService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsControllerTest {

	ProductsController productsController;
	JSONParser parser;

	@Mock
	ProductsService productsService;

	@Before
	public void before() {
		productsController = new ProductsController(productsService);
		 parser = new JSONParser();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getProducts_200() throws Exception {

		JSONObject json = new JSONObject();
		json.put("id", "1");
		json.put("name", "Cheese");
		json.put("price", 2.50);
		json.put("location", "Refrigerated foods");

		Response responseObj = new Response();
		responseObj.setStatus(HttpStatus.OK);
		responseObj.setCode("200");
		responseObj.setData(json.toString());

		Mockito.when(productsService.getProductDetails(anyString(), anyString())).thenReturn(responseObj);
		final String response= productsController.getProducts("1", "cheese");
		JSONObject jsonResponse = (JSONObject) parser.parse(response);
		assertThat("200", is(jsonResponse.get("code").toString()));
	}

	@Test
	public void getProducts_404() throws Exception {

		Error error = new Error();
		error.setCode("404");
		error.setMessage("Product Not Found");

		List<Error> errorList = new ArrayList<>();
		errorList.add(error);

		Response responseObj = new Response();
		responseObj.setStatus(HttpStatus.NOT_FOUND);
		responseObj.setCode("404");
		responseObj.setErrors(errorList);

		Mockito.when(productsService.getProductDetails(anyString(), anyString())).thenReturn(responseObj);
		final String response= productsController.getProducts("1", "safsgdfg");
		JSONObject json = (JSONObject) parser.parse(response);
		assertThat("404", is(json.get("code").toString()));
	}
}
