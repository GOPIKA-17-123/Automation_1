package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed : " + result.getName());
        ScreenshotUtil.captureScreenshot(BaseTest.driver, result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed : " + result.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println(
                "Execution Completed");
    }
}