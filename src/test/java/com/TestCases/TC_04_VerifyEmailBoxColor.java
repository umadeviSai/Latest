package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_MyStore;
import com.ScreenFunctions.MyStore;

public class TC_04_VerifyEmailBoxColor extends GenericFunctions {
@Test
	public void VerifyEmailBoxColor()
	{
		launchApplication("firefox");
		MyStore mystore = PageFactory.initElements(driver, MyStore.class);
		mystore.SignIn_Click();
		Login_MyStore loginmystore=PageFactory.initElements(driver,Login_MyStore.class);	
		loginmystore.ValidateEmailColor();
	}
}
