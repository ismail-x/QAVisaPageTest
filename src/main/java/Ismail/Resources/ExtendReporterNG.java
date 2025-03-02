package Ismail.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path); //this is helper
        reporter.config().setReportName("Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports(); //this is main class
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester Name", "Ismail");

        return extent;
    }
}
