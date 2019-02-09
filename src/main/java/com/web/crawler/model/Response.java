package com.web.crawler.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {

	private HttpStatus status;
	
	private String code;
	
	private String time;
	
	private List<Error> errors;
	
	private String data;
	
	public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(final String time) {
        this.time = time;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(final List<Error> errors) {
        this.errors = errors;
    }

    public boolean hasErrors() {
        return this.errors != null && !this.errors.isEmpty();
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
