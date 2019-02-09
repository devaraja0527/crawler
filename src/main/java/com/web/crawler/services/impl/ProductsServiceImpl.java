package com.web.crawler.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.web.crawler.model.Error;
import com.web.crawler.model.Response;
import com.web.crawler.services.ProductsService;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	private final String PRODUCTS_STR = "products";
	private final String ID_STR = "id";
	private final String NAME_STR = "name";
	
	
	Response response;
	
	@Override
	public Response getProductDetails(final String id, final String name) {
		
		
		response = new Response();
		
		try {
			
			File file = ResourceUtils.getFile("classpath:test-data/products.json");
			 
			//File is found
			System.out.println("File Found : " + file.exists());
					 
			//Read File Content
			String content = new String(Files.readAllBytes(file.toPath()));
			System.out.println(content);
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(content);

		    JSONArray array = (JSONArray) json.get(PRODUCTS_STR);
		    
		    for (int i=0; i < array.size(); i++) {
		    	JSONObject dataOBJ = (JSONObject) array.get(i);
		    	String idIn = (String) dataOBJ.get(ID_STR);
		    	String nameIn = (String) dataOBJ.get(NAME_STR);
		    	
		    	if ((idIn != null && idIn.equalsIgnoreCase(id)) 
		    			&& (nameIn != null && nameIn.equalsIgnoreCase(name))) {
		    		response.setStatus(HttpStatus.OK);
		    		response.setCode(String.valueOf(HttpStatus.OK.value()));
		    		response.setData(dataOBJ.toJSONString());
		    		response.setTime(new Date().toString());
		    		return response; 
		    	}
		    	
		    }
		    response.setStatus(HttpStatus.NOT_FOUND);
    		response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
    		response.setTime(new Date().toString());
    		response.setErrors(getError(HttpStatus.NOT_FOUND.toString(), "No Products Found..!"));
    		return response; 
		    
		} catch(IOException | ParseException ex) {
			System.out.println(ex);
			response.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
			response.setCode(ex.getMessage());
			response.setErrors(
					getError(HttpStatus.SERVICE_UNAVAILABLE.toString(), ex.getMessage()));
			response.setTime(new Date().toString());
			return response; 
		}
		
		
	}
	
	
	// Get List Of Errors
	public List<Error> getError(final String code, final String message) {
		List<Error> errors = new ArrayList<Error>();
		Error error = new Error();
		error.setCode(code);
		error.setMessage(message);
		errors.add(error);
		return errors;
	}

}
