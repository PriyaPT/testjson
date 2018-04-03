package com.rabbitMQserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FetchChannel {

LinkedHashMap<Integer, String[]> lnkmap1 = null;
	
	public static void main(String[] args) {
		JSONObject obj = null;
		JSONObject connectionDetails = null;
		String channelName="No_Value", connectionName = "No_Value", nodeName="No_Value", vhost="No_Value",mode="No_Value";
		long messagesUnacknowledged = -1, messagesUncommited = -1, messagesUnconfirmed = -1, acknowledgementsUncommited = -1;
		long consumerCount=-1L;
		boolean trans=false, confirm=false;
		String state = null;
		//Attributes row = null;  
		int requestID = 0;
		try {
			 
			java.net.URL url = new java.net.URL("http://10.77.68.253:15672/api/channels");//the 1 is the product id
			
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
			
			String username = "test";
			String password = "test";
			
		sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
	        String userpassword = username + ":" + password;
	        String encodedAuthorization = enc.encode( userpassword.getBytes() );
	        conn.setRequestProperty("Authorization", "Basic "+encodedAuthorization);
	 		conn.setAllowUserInteraction(true);
	 		
	 		

			/*if (conn.getResponseCode() != java.net.HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 		
	 	
	 		*/
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(
					(conn.getInputStream())));
			//System.out.println(br.readLine());
			JSONParser jsonParser = new JSONParser();
			JSONArray array =null;
			
			try {
				 array = (JSONArray)jsonParser.parse(br);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<JSONObject> obj1 = array.iterator();
			
			while(obj1.hasNext())
			{
				obj = obj1.next();
				
				if (obj.containsKey("connection_details")) {
					
					
					connectionDetails = (JSONObject) obj
							.get("connection_details");
					
					connectionName = (String) connectionDetails
							.get("name");
				
				 System.out.println(connectionName);
				 
				 
				}
			
				if(obj.containsKey("name"))
				{
					channelName = (String) obj.get("name");
				}
				if(obj.containsKey("node"))
				{
					nodeName = (String) obj.get("node");
					System.out.println(nodeName);
				}
				if(obj.containsKey("vhost"))
				{
					vhost = (String) obj.get("vhost");
				}
				if(obj.containsKey("transactional"))
				{
					trans = (Boolean) obj.get("transactional");
				}
				if(obj.containsKey("confirm"))
				{
					confirm = (Boolean) obj.get("confirm");
				}
				if (trans) {
					mode = "Transactional";
				} else if (confirm) {
					mode = "Confirm";
				} else {
					mode = "None";
				}
				if(obj.containsKey("consumer_count"))
				{
					consumerCount = (Long) obj.get("consumer_count"); 
				}
				if(obj.containsKey("messages_unacknowledged"))
				{
					messagesUnacknowledged = (Long) obj.get("messages_unacknowledged");
				}
				if(obj.containsKey("messages_uncommitted"))
				{
					messagesUncommited = (Long) obj.get("messages_uncommitted");
				}
				if(obj.containsKey("messages_unconfirmed"))
				{
					messagesUnconfirmed = (Long) obj.get("messages_unconfirmed");
				}
				if(obj.containsKey("acks_uncommitted"))
				{
					acknowledgementsUncommited = (Long) obj.get("acks_uncommitted");
				}
				if(obj.containsKey("state"))
				{
					state = (String) obj.get("state");
				}
			
			
			/*row = new Attributes(channelName, connectionName,
					nodeName, vhost, state, mode, consumerCount,
					messagesUnacknowledged, messagesUncommited,
					messagesUnconfirmed, acknowledgementsUncommited);*/
			
			requestID = requestID+1;
			//row.MapAttributeValue( requestID, );
			
		String[] FJsonArray = new String[11];
		
			
			FJsonArray[0] = channelName;
			FJsonArray[1] = connectionName;
			FJsonArray[2] = nodeName;
			FJsonArray[3] = vhost;
			FJsonArray[4] = state;
			FJsonArray[5] = mode;
			FJsonArray[6] = Long.toString(consumerCount);
			FJsonArray[7] = Long.toString(messagesUnacknowledged);
			FJsonArray[8] = Long.toString(messagesUncommited);
			FJsonArray[9] = Long.toString(messagesUnconfirmed);
			FJsonArray[10] = Long.toString(acknowledgementsUncommited);
		
			FetchChannel call = new FetchChannel();
			
			call.LiknedhashmapCollection( FJsonArray , requestID);
				
		}
			
			
			String output;
			System.out.println("Output from Server .... \n");
			System.out.println(br.readLine());
			/*while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 */
			conn.disconnect();
	 	}
		 catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
	    
     
	}
	  public void LiknedhashmapCollection(String[] FJsonArray , int requestID)
      {
		   LinkedHashMap<Integer, String[]> lnkmap = new LinkedHashMap<Integer, String[]>();
		   lnkmap.put(requestID, FJsonArray);
         PrintHashmap(lnkmap);
         
      }
	private void PrintHashmap(LinkedHashMap<Integer, String[]> lnkmap) {
		// TODO Auto-generated method stub
		
		this.lnkmap1 = lnkmap;
	Set<Integer> keys = 	lnkmap.keySet();
		for(Integer key :keys)
		{
			 System.out.println(" i am in hashmap method");
		//System.out.println(lnkmap.get(key).toString());
			 System.out.println("This is the Key : " + key);
		String[] str = lnkmap1.get(key);
		for (int i = 0; i < str.length; i++) {
			
			System.out.println(str[i]);
		}
		}
		
	}
}
