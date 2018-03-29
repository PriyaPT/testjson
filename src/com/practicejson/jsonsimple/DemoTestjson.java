package com.practicejson.jsonsimple;

import java.io.IOException;
import java.net.MalformedURLException;

public class DemoTestjson {
	
	
	public static void main()
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
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

}
}