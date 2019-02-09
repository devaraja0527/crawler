package com.web.crawler.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.crawler.model.Response;
import com.web.crawler.services.ProductsService;
import com.web.crawler.model.Error;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

@RestController
public class ProductsController {
	
      @Autowired
      ProductsService productsService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/products/{id}/{name}", method = RequestMethod.GET)
	public String getProducts(
			@PathVariable(value = "id", required = false) String id, 
			@PathVariable(value = "name", required = false) String name) {
		
		
		JSONObject finalObjectReturn = new JSONObject();
		
		Response response = productsService.getProductDetails(id, name);
		finalObjectReturn.put("status", response.getStatus().toString());
		finalObjectReturn.put("code",response.getCode());
		if (response.hasErrors()) {
			finalObjectReturn.put("errors", getErrorsInJson(response.getErrors()));
		} else {
			finalObjectReturn.put("data", response.getData());
		}
		return finalObjectReturn.toString();
	}
	
	
	@SuppressWarnings("unchecked")
	private JSONArray getErrorsInJson(final List<Error> errorsList) {
		JSONArray array = new JSONArray();
		for (Error error : errorsList) {
			JSONObject jsonOBJ = new JSONObject();
			jsonOBJ.put("code", error.getCode());
			jsonOBJ.put("message", error.getMessage());
			array.add(jsonOBJ);
		}
		return array;
	}
	
	
}
