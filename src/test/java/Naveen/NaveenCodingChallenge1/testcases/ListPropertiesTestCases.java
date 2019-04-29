package Naveen.NaveenCodingChallenge1.testcases;

//@author : Ankit Lohia
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Naveen.NaveenCodingChallenge1.ExtentReport.ExtentManager;

import Naveen.NaveenCodingChallenge1.pages.Homepage;

import Naveen.NaveenCodingChallenge1.base.TestBaseChallenge;



public class ListPropertiesTestCases extends TestBaseChallenge {
	 
	  Homepage home;  // create object of nonstatic method to access methods
	  ExtentReports rep;
	
	 public ListPropertiesTestCases() {
		 super(); //calling parent class constructor or method using super keyword
		
		
	 }
	 
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException {
	  initialization();
	  driver.findElement(By.xpath("//button[@class='button cookie-banner__button']")).click();
	  home= new Homepage();
	  rep=ExtentManager.getInstance();
	  test = rep.startTest("Homepage Started");
	  test.log(LogStatus.PASS, "Calling TestBase Class");
	  test.log(LogStatus.PASS, "TestBase class Initiated Successfully");

	  
	}
	
	
	
	@Test(priority=1)
	public void InputText(){
		
		boolean b = home.ValidateInputText();
		Assert.assertEquals(b, true);  // To validate if search text field is present
		test.log(LogStatus.PASS, "Executing Homepage TestCase InputText");
		home.ValidateSearchButton();
		
		home.Inputdata("London");
		test.log(LogStatus.PASS, "InputText in search");
		takeScreenShot();

		home.Searchclick();
		test.log(LogStatus.PASS, "Click on search");
	
				
	}
	
	
	@Test(priority=2) //expectedExceptions=java.lang.NumberFormatException.class
	public void listview() throws InterruptedException  {
		 home.GetList();
		 
	    test.log(LogStatus.PASS, "Executing Homepage TestCase listview");
		test.log(LogStatus.PASS, "Printing all Properties");
		takeScreenShot();
		
		
	}
	
	@Test(priority=3)
	public void Select5th() throws InterruptedException {
		
     home.fifthpropclick();
		 
	test.log(LogStatus.PASS, "Selecting 5th property");
	takeScreenShot();
	
	}
	
	
	@Test(priority=4)
	public void ClickAgentName() {
	
	 	
     String name1= home.agentclick();
     home.DetailPageName();
     //String expectedname1= home.DetailPageName();
     //Assert.assertEquals(name1, expectedname1);
     
 	takeScreenShot();
	test.log(LogStatus.PASS, "Compare Agent name");


		
		
	}
	
	
	
	@AfterTest
	public void teardown() {
		 test.log(LogStatus.PASS, "Quit Browser");
		 rep.endTest(test);
		 rep.flush();
		 driver.quit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
	}
}
	


