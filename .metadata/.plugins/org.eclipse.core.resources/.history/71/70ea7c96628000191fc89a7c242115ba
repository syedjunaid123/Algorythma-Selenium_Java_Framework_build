package com.saal.challenge;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListeners implements ITestListener {


	public void onTestStart(ITestResult result) {
		System.out.println("*********** Test Started : "+result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*********** Test Successful : "+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*********** Test Failure : "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*********** Test Skipped : "+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("*********** Test Skipped : "+context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("*********** Tests Completed : "+context.getName());

	}

}
