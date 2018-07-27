package com.GenericFunctions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {

	public static WebDriver driver;

	/************************************************** 
	 * Method Name		:launchApplication 
	 * Purpose			:To Launch the application
	 * I/P Parameters	:Browser Name
	 * O/P Parameters	:This method will return a boolean value depending on the 
	 * Author			:
	 * Creation date	: 
	 **************************************************/

	public static boolean launchApplication(String browser) {

		boolean status = true;

		switch (browser.toLowerCase()) {
		case "ie":

			break;

		case "firefox":

			driver = new FirefoxDriver();

			String url = getCommontestdata("Url");

			System.out.println(url);

			driver.get(url);

			driver.manage().window().maximize();

			// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			String url1 = getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();
			break;
		default:
			break;
		}
		return status;
	}
	/*************************************************
	 * Method Name		: GetCommonTestdata
	 * Purpose			: This method is used to read the common test data common to the test suite like 
	 * Environment,Url, User name,Password and any connection strings.
	 * I/P Parameters	: Column name from the excel 
	 * O/P Parameters	: This method will return a string value from the given column
	 * Author			:
	 * Creation date	:
	 **************************************************/

	public static String getCommontestdata(String data) {

		String strQuery = "Select " + data + " from CommonTestdata";

		System.out.println(strQuery);

		Recordset recordset;

		String fetcheddata = "";

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField(data));

				fetcheddata = recordset.getField(data);
				break;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		return fetcheddata;

	}
	/*************************************************
	 * Method Name		: getdata
	 * Purpose			: This method is used to read test data from the given 
	   test data sheet, column and iteration.
	 * I/P Parameters	: Sheet name,column name and iteration
	 * O/P Parameters	: This method will return a string value from the given column
	 * Author			:
	 * Creation date	:
	 **************************************************/

	public static String getdata(String sheetname, String userdata, int itr) {

		String strQuery = "Select " + userdata + " from " + sheetname + " where Tc_Name='" + crntclass
				+ "' and Iteration=" + itr;
		System.out.println(strQuery);

		Recordset recordset;

		String fetcheddata = "";

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField(userdata));

				fetcheddata = recordset.getField(userdata);
				break;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		System.out.println(fetcheddata);
		return fetcheddata;
		

	}
	/*************************************************
	 * Method Name		: waitforElement
	 * Purpose			: This method is used to read test data from the given 
	   test data sheet, column and iteration.
	 * I/P Parameters	: Sheet name,column name and iteration
	 * O/P Parameters	: This method will return a string value from the given column
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public static void waitForElement(WebElement element) {

		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println("Wait is executing");
				Actions acc = new Actions(driver);
				acc.moveToElement(element).build().perform();
				System.out.println("Element Found");
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		}

	}
	/*************************************************
	 * Method Name		: hoverAndClick
	 * Purpose			: This method will hover and click 
	 * I/P Parameters	: WebElement
	 * O/P Parameters	: Boolean 
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public static boolean hoverAndClick(WebElement element) {
		boolean status = true;

		try {
			waitForElement(element);
			Actions acc = new Actions(driver);
			acc.moveToElement(element).click().build().perform();

		} catch (Exception e) {

			status = false;

		}

		return status;
	}
	/*************************************************
	 * Method Name		: hoverOverElement
	 * Purpose			: This method will hover on the element
	 * I/P Parameters	: WebElement
	 * O/P Parameters	: Boolean
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public static boolean hoverOverElement(WebElement element) {
		boolean status = true;

		try {
			waitForElement(element);
			Actions acc = new Actions(driver);
			acc.moveToElement(element).build().perform();

		} catch (Exception e) {

			status = false;

		}

		return status;
	}
	/*************************************************
	 * Method Name		: forceClick
	 * Purpose			: This method will force click the element using Java script Executor.
	 * I/P Parameters	: WebElement
	 * O/P Parameters	: 
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public static void forceClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}
	/*************************************************
	 * Method Name		: setText
	 * Purpose			: This method will enter the given value in the given WebElement.
	 * I/P Parameters	: WebElement and a String value
	 * O/P Parameters	: Boolean value
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public boolean setText(WebElement ele, String value) {
		boolean status = true;
		try {
			ele.click();
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) 
		{
			status = false;
		}

		return status;

	}
	/*************************************************
	 * Method Name		: ValidateLinks
	 * Purpose			: This method will validate all the links in a page 
	 * I/P Parameters	: List of WebElements
	 * O/P Parameters	: Boolean value
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public boolean ValidateLinks(List<WebElement> List) throws Exception
	{
		boolean methodstatus =true;
		try{				
		for(WebElement we:List)
		{
			String url=we.getAttribute("href");
			URL myurl= new URL(url);
			HttpURLConnection con=(HttpURLConnection) myurl.openConnection();
			con.connect();
			int respcode =con.getResponseCode();
			if (respcode>=400 && respcode<=500)
			{
				logEvent("Fail","The link is broken");
				System.out.println("The link " +we.getText() +"  is broken");
			}
			else{
				logEvent("Fail","The link is not broken");
				System.out.println("The link " +we.getText() +"  is  not broken");
				
			}
		}
		
		} catch(Exception e)
		{	methodstatus=false;
			logEvent("Fail"," The link  couldn't be read" +e.getMessage());
			System.out.println("Link failed");
		}
		return methodstatus;		
	}
	/*************************************************
	 * Method Name		: AppendDateNTime
	 * Purpose			: This method will Append date and time to the given string. 
	 * Used to make any  Email id to be unique.yyyyMMddHHmmSS is append to the email id.
	 * I/P Parameters	: String
	 * O/P Parameters	: String
	 * Author			:
	 * Creation date	:
	 **************************************************/
	public String AppendDateNTime(String str)
	{
		
		StringBuffer SB= new StringBuffer(str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		StringBuffer str_new=SB.insert(str.indexOf("@"),sdf.format(new Date()));
		System.out.println(str_new  +"*****" + str_new.toString());
		return(str_new.toString());		
		
	}
	

}
