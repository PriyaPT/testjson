package com.practicejson.jsonsimple;

public class QuestionOnPrac {

	
	public void swaptwoNumber()
	{
		int a,b;
		a=10;b=20;
		a=a+b;
		System.out.println("the value of a is " + a);
		b=a-b;
		System.out.println("the value of b after swap " + b);
		a=a-b;
		System.out.println("the value of a after swap " + a);
	}

	public long powerof(int x, int n)
	{
	   
	        long y = 0;
	 
	        if (n == 0)
	            return 1;
	        else if (n == 1)
	            return x;
	        else {
	            y = powerof(x, n / 2);
	            y = y * y;
	            if (n % 2 == 0)
	                return y;
	        }
	        return x * y;
	    }
	
	
	 public int sum(int n)
	 { int sum =0;
		 return n==0 ? 0 : n%10+sum(n/10);
	 }
     public static void main(String[] args) {
    	 QuestionOnPrac prac = new QuestionOnPrac();
    	 prac.swaptwoNumber();
		long powervalue = prac.powerof(3, 4);
				System.out.println("The power of value is :" + powervalue);
    	 
	}
}
