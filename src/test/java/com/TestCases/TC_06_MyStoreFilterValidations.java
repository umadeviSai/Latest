package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.MyStore;

public class TC_06_MyStoreFilterValidations extends GenericFunctions{
	@Test
	public void MyStoreFilterValidations() throws Exception
	{
		launchApplication("firefox");
		MyStore mystore=PageFactory.initElements(driver,MyStore.class);
		mystore.SignIn_Click();
		mystore.CheckFilterLowtoHigh();
	}

}
