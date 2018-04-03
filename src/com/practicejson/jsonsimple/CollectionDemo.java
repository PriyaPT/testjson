package com.practicejson.jsonsimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** @author: priya Vyawahare
 * This class is used for cillection practice.
 *
 *
 */
public class CollectionDemo {
//this method will print the data in random order
	public HashMap<Integer, String> hashMapPract()
	{
		HashMap<Integer, String> hashmap1 = new HashMap<Integer, String>();
		hashmap1.put(1, "priya");
		hashmap1.put(2, "prakash");
		System.out.println("My hash Map is  :" + hashmap1 );
	return hashmap1;
	}
	//This method will print the data in sorted order
	public Map<Integer, String> treeHashMap()
	{
		
		Map<Integer, String> hashmap2 = new TreeMap<Integer, String>();

		hashmap2.put(1, "priya");
		hashmap2.put(2, "prakash");
		System.out.println("My tree hash Map is  :" + hashmap2 );
		return hashmap2;
	}
	//this method will print the data in inserted order
	public Map<Integer, String> linkedHashMap()
	{
		
		Map<Integer, String> hashmap3 = new LinkedHashMap<Integer, String>();
		hashmap3.put(1, "priya");
		hashmap3.put(2, "prakash");
		System.out.println("My linked hash Map is  :" + hashmap3 );
		return hashmap3;
	}
	
	 public void compaire()
	 {
		 Map<Integer, String> map1 = hashMapPract();
		 
		 Map<Integer, String> map2 = treeHashMap();
		 
		if( map1.size() == map2.size())
		{
			boolean flag ;
			System.out.println(map1.size());
			System.out.println(map1.keySet());
			for(int i=1; i<=map1.size();i++)
			{
				if(map1.get(i) == map2.get(i))
				{
					flag= true;
				}
			
				else
				{
					flag = false;
				}
			
			
			}
			
			System.out.println("matched");
		}
	 
	
	 }
	 
	 public void comparetwoArray()
	 {
		 
	 }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionDemo  demp = new CollectionDemo ();
		demp.hashMapPract();
		demp.treeHashMap();demp.linkedHashMap();
		demp.compaire();
	  //Here i am working with arraylIst
		List<Integer> list = new ArrayList<Integer>();
	    
	    Integer[] arr = {2,10,3};
	    
	    list = Arrays.asList(arr);
	    list.set(2, 6);
	    list.set(0, 3);
	    
	    System.out.println(list);
	    
	    List<Integer> list1 = new ArrayList<Integer>();
	    
	    list1.add(10);
	    list1.add(10);
	    list1.remove(new Integer(10));
	    System.out.print(list.size());
	    
	   list.remove(10);
	    
	    System.out.print(list1.size());
	    
	    
	    System.out.println(list1);
	
	}

}
