package Naveen.NaveenCodingChallenge1.ExtentReport;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports("E:\\Workspace_new\\NaveenCodingChallenge1\\ExtentReports\\"+fileName, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File("E:\\Workspace_new\\NaveenCodingChallenge1\\src\\main\\java\\Naveen\\NaveenCodingChallenge1\\ExtentReport\\ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}
