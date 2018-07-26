package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_MyStore;
import com.ScreenFunctions.MyStore;

public class Tc_02_VerifyEmailAddress extends GenericFunctions{
	
	@Test
	public static void VerifyEmailAddress() throws Exception
	{
		launchApplication("firefox");
		MyStore mstore = PageFactory.initElements(driver, MyStore.class);
		mstore.SignIn_Click();
		mstore.ValidateLinks_MyStore();
		//Login_MyStore Loginstore=PageFactory.initElements(driver,Login_MyStore.class);
		//Loginstore.setEmailAddress();
		
	}

}
