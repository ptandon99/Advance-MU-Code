package com.mulesoft.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;



public class MuleComponent {

	int count;
	
 public MuleComponent(){
	 count =1;
 }
	
  public Map<String,String> processMap(Map<String, String> input) {
	  
	input.put("executed by", "processMap method");
	
    // processMap implementation
    return input;
  }

  public Map<String,String> processArray(List<String> myList) {
    // processArray implementation
	 myList.add("one more string is added.");
	 Map<String,String> myMap = new HashMap<String, String>();
	 myMap.put("inputArrayString", myList.get(0));
	 myMap.put("executed by ","processMap Array");
    return myMap;
  }

  public Map<String,String> processString(String myString) {
	  Map<String,String> myMap = new HashMap<String, String>();
		 myMap.put("inputArrayString", myString);
		 myMap.put("executed by ","processMap String");
    return myMap;
  }

/*  public Map<String,String> processString2() {
	  Map<String,String> myMap = new HashMap<String, String>();
		 
		 myMap.put("executed by ","processMap String2");
    return myMap;
  }*/
  
  public Map<String,String> processAll(@Payload Object input, @InboundHeaders("http.method") String myHttpMethod) {
  
	  Map<String,String> myMap = new HashMap<String, String>();
		 myMap.put("message", input.toString());
		 myMap.put("executed by ","processMap All");
		 myMap.put("http method used", myHttpMethod);
		 myMap.put("count", String.valueOf(count));
		 count++;
 return myMap;
  }
  

  /*public Map<String,String> myTestJavaCustomeMethod() {
	  Map<String,String> myMap = new HashMap<String, String>();
		 
		 myMap.put("executed by ","processMap myTestJavaCustomeMethod");
    return myMap;*/
 // }
  
  
  
} 
