package com.fagose.booklet.util;

import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApplicationUtils {
	public static final String ORDER_BY_DIRECTION_ASCENDING  ="ASC";
	public static final String ORDER_BY_DIRECTION_DESCENDING ="DESC";
	public final static SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm dd-MM-yyyy");
	
	public static String getJsonValue(String val,String key){
		
		 JsonParser parser = new JsonParser();
	     JsonObject obj = (JsonObject)parser.parse(val);
	     JsonElement value = obj.get(key);
	     
	     return value.toString();
	}
	
}
