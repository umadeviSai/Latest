package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_MyStore;
import com.ScreenFunctions.MyStore;

public class TC_03_VerifyHeaders extends GenericFunctions{
	

@Test
/* TC Name:TC_03_VerifyHeaders
 * TC descriptions: To verify all the headers to be capitals and labels should be 
 * 
 */
public static void VerifyHeaders()
{ 
	launchApplication("firefox");
	MyStore mystore = PageFactory.initElements(driver, MyStore.class);
	mystore.SignIn_Click();
	Login_MyStore logmystore=PageFactory.initElements(driver,Login_MyStore.class);	
	//verifying the PageElements and will flow to the next step only after passing.
	logmystore.ValidatePageElements();	
}
}
