package com.practicstring;

public class StringClassDemo {

    private static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
        System.out.println(length / 2);
        for (int i = 0; i < length / 2; i++) {

            if (str.charAt(i) != str.charAt(length - i - 1))
                
            	 return false;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StringClassDemo demo = new StringClassDemo();
		if(StringClassDemo.isPalindromeString("ABCB"))
		{
			System.out.println("The string is palindrome");
	     }
		else
		{			System.out.println("The string is not palindrome");
			
		}
	}

}
