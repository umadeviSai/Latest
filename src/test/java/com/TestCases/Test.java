package com.TestCases;

import com.GenericFunctions.GenericFunctions;

public class Test extends GenericFunctions {

	@org.testng.annotations.Test
	public static void TEst1(){
		// TODO Auto-generated method stub
		
		convertExcelAsDataBase();
		System.out.println(getdata("TestcaseData", "State", 1));
		System.out.println(getdata("TestcaseData", "LastName", 1));
		

	}

}
