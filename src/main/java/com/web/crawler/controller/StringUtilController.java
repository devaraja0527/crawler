package com.web.crawler.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringUtilController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nonrepeatchar/{inputString}", method = RequestMethod.GET)
	public String getNonRepeatedCharecter(@PathVariable(value = "inputString", required = false) String inputString) {
		JSONObject finalObjectReturn = new JSONObject();
		 char foundChar = getNonRepeateChar(inputString);
		 if (foundChar != 0) {
			 finalObjectReturn.put("foundChar", foundChar);
		 } else {
			 finalObjectReturn.put("nocharFound", "No Charected Found...!");
		 }
		 return finalObjectReturn.toString();
	}
	
	
	public char getNonRepeateChar(String str) {
		 boolean found = false;
		  for(int i = 0; i < str.length(); i++){
			   found = true;
			   char c = str.charAt(i);
			   for(int j = 0; j < str.length(); j++){
				   if(c == str.charAt(j) && j != i){
					   	found = false;
					   	break;
				   }
			   }
			   if(found){
			      return c;
			   }
			   
		  }
		  if(!found){
			  return 0;
		  }
		return 0;
	}
}
