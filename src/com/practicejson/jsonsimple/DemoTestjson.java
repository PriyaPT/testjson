package com.practicejson.jsonsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class DemoTestjson {
	
	@Test
	public static void testMain()
	{
		
	
	java.net.URL url = null;
	try {
		url = new java.net.URL("http://services.groupkt.com/country/get/all");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//the 1 is the product id
	
	java.net.HttpURLConnection conn;
	try {
	conn = (java.net.HttpURLConnection) url.openConnection();
		/*String username = "test";
		String password = "test";
		
	sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
	    String userpassword = username + ":" + password;
	    String encodedAuthorization = enc.encode( userpassword.getBytes() );
	    conn.setRequestProperty("Authorization", "Basic "+encodedAuthorization);
			conn.setAllowUserInteraction(true);*/
	
	
	java.io.BufferedReader br = new BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
	JSONParser parser = new JSONParser();
	JSONObject obj = (JSONObject) parser.parse(br);
	JSONObject obj1  = (JSONObject) obj.get("RestResponse");
	 System.out.println(obj1.toString());
	 JSONArray array =  (JSONArray)obj1.get("result");
	
	Iterator<JSONObject> objaray = array.iterator();
	while(objaray.hasNext())
	{
		JSONObject obj3 = objaray.next();
		String Name = (String) obj3.get("name");
		System.out.println( ":" +Name);
		String alpha2_code = (String) obj3.get("alpha2_code");
		System.out.println(" :" +alpha2_code );
		String alpha3_code = (String)obj3.get("alpha3_code");
		System.out.println(" :" +alpha3_code );
	}
	//JSONObject obj2  = (JSONObject)obj1.get("result");

	} catch (IOException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}