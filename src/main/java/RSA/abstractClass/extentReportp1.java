package RSA.abstractClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportp1 {
	
	public static ExtentReports reportsp1()
	{
		String ERpath = System.getProperty("user.dir")+"//p1ExtentReport//file1.html";
		ExtentSparkReporter report = new ExtentSparkReporter(ERpath);
		report.config().setDocumentTitle("Automation Practice");
		report.config().setReportName("Web Automation result");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		return extent;
		
	}

}
