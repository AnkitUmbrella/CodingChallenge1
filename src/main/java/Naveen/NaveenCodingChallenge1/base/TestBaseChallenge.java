package Naveen.NaveenCodingChallenge1.base;

//@Author- Ankit Lohia
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Naveen.NaveenCodingChallenge1.ExtentReport.ExtentManager;

public class TestBaseChallenge {

	public static WebDriver driver;
	public static Properties prop=new Properties();
	
	public static ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	
	public TestBaseChallenge() { // constructor of this class
		
		try {
			FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Naveen\\NaveenCodingChallenge1\\config\\config.properties");
			try {
				prop.load(fp);
			} catch (IOException e) {
				System.out.println("Some Error in Internet Connection"  +e);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void initialization() {
	    String browser= prop.getProperty("browser");
	    if(browser.equalsIgnoreCase("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\BrowserDrivers\\chromedriver.exe");
			driver= new ChromeDriver();
		
	    	
	    }else if(browser.equalsIgnoreCase("Mozilla")) {
	    	
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\BrowserDrivers\\geckodriver.exe");
               driver= new FirefoxDriver();
               
	    }
	    
	  
	          driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
             try {
				   driver.get(prop.getProperty("url"));
             	   driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
				   driver.navigate().refresh();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Internet Connection Issue");
			} 
			  
	}	  

	
	public static void Takesscreenshot(WebDriver driver) throws IOException, InterruptedException {
        File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest= new File("D:\\temp\\screenshot_"+timestamp()+".png");
        FileUtils.copyFile(scr, dest);
        Thread.sleep(3000);
     
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
    
 
	// To add screenshot in Extent Report
	public static void takeScreenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//put screenshot file in reports
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		
	}
    	
	// Menu Traversing
	public void clickMenu(String Menuitem) {
	   driver.findElement(By.xpath("//div[@class='dropdown-toggle']")).click();
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   driver.findElement(By.xpath("//div/a[contains(text(), '"+Menuitem+"')]")).click();
	
	   
		  
	}
    	
	// SAVE BUTTON ENABLED
		public void IsSavebuttonEnabled()  {
		 boolean sb= driver.findElement(By.xpath("//div/button[@type='submit' and @class='save-button custom-button']")).isEnabled();
		 System.out.println(sb);
	    if(sb==true) {
	   System.out.println("Button is Enabled");
	   }else if(sb==false)
	   System.out.println("Button is disabled");
		
		
		}
		
		
		//Scroll Bottom of Page
		public void scrolldownpage() {
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,1000)");
			
			
		}
		
		
}
		

		   
	
	


	

