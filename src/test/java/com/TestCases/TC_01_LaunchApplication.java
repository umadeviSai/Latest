package com.TestCases;

import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;

public class TC_01_LaunchApplication extends GenericFunctions {
	
	@Test
	public static void LaunchApplication_Validate()
	{
		launchApplication("firefox");
				
		
	}

}
