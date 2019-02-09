package com.web.crawler.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(
	    ignoreUnknown = true
	)
	@JsonInclude(Include.NON_NULL)
public class Error {
	    private String code;
	    private String message;

	    public Error() {
	    }

	    public String getCode() {
	        return this.code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getMessage() {
	        return this.message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
	}
