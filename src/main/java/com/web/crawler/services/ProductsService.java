package com.web.crawler.services;



import com.web.crawler.model.Response;

public interface ProductsService {

	public Response getProductDetails(final String id, final String name);
	
}
