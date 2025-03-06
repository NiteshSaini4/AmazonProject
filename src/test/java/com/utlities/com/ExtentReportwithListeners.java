package com.utlities.com;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testcase.com.BaseClass;

public class ExtentReportwithListeners extends BaseClass implements ITestListener
{
	ExtentSparkReporter createReport;
	ExtentReports createtest;
	ExtentTest createlog;
	void setup()
	{	
		createReport=new ExtentSparkReporter("EcommerceReports.html");
		createtest=new ExtentReports();
		createtest.attachReporter(createReport);
		
		createtest.setSystemInfo("Os", "Windown");
		createtest.setSystemInfo("Browser","chrome");
		createtest.setSystemInfo("user", "Nitesh");
		
		createReport.config().setDocumentTitle("Test_Report");
		createReport.config().setReportName("EcommerceProject");
		createReport.config().setTheme(Theme.DARK);
	}
	public void onStart(ITestContext Result)
	{	setup();
		System.out.println("onStart");
	}
	public void onFinish(ITestContext Result)
	{ 	createtest.flush();
		System.out.println("onFinish call");
	}
	public void onTestStart(ITestResult Result)
	{
		System.out.println("OntestStart");
	}
	public void onTestSuccess(ITestResult Result)
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.PASS,MarkupHelper.createLabel("This test case properly execute", ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult Result)
	{	try {
		ScreenShot();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		String path="C:\\Users\\dell\\eclipse-workspace\\DataDrivenFramework\\ScreenShots\\wwe.png";
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.FAIL,MarkupHelper.createLabel("This test case properly execute", ExtentColor.RED));
		createlog.fail("myscreenShot"+createlog.addScreenCaptureFromPath(path));
	}
	public void onTestSkipped(ITestResult Result)
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.SKIP,MarkupHelper.createLabel("Test case skip", ExtentColor.YELLOW));
	}

}
