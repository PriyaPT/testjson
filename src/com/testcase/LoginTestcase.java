package com.testcase;
import org.testng.annotations.Test;

import com.selenium.prac.DashBoardPage;
import com.selenium.prac.HomPage;
import com.selenium.prac.LaunchURL;
import com.selenium.prac.LoginPage1;

public class LoginTestcase {
	@Test
	public void Logintest()
	{
		LaunchURL launch = new LaunchURL();
		LoginPage1 page = launch.LaunchURLMethod();
	    HomPage hom = page.TakeUSERPWD();
	
	    DashBoardPage dash = hom.HomPageClickDashBoard();
		
	    dash.component();
		
	}

}


