package Ismail.TestComponents;

import Ismail.Resources.ExtendReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtendReporterNG.getReportObject();

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(org.testng.ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); //For unique Thread ID
    }

    @Override
    public void onTestSuccess(org.testng.ITestResult result) {

        extentTest.get().log(Status.PASS, "Test Case Passed");
    }

    @Override
    public void onTestFailure(org.testng.ITestResult result) {

        extentTest.get().log(Status.FAIL, "Test Case FAILED");
        extentTest.get().fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass()
                    .getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(org.testng.ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();
    }

}
