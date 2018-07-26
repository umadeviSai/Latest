package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_MyStore;
import com.ScreenFunctions.MyStore;
import com.ScreenFunctions.NewUserRegistration;

public class TC_05_NewUserRegistration extends GenericFunctions {
	@Test
	public static void NewUser_Registration() throws Exception
	{
		launchApplication("firefox");
		MyStore mystore = PageFactory.initElements(driver, MyStore.class);
		mystore.SignIn_Click();
		Login_MyStore Loginstore=PageFactory.initElements(driver,Login_MyStore.class);
		Loginstore.EmailChkCreateAct();
		NewUserRegistration newuser=PageFactory.initElements(driver,NewUserRegistration.class);
		newuser.Fill_Registration_Page();		
	}

}
