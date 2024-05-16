package testlisteners;

import base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends Base implements ITestListener {

    ExtentReports reports;
    ExtentTest test;

    // needed for parallel test execution
    ThreadLocal<ExtentTest> testLocal = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test Start");
        reports = ExtentManager.getReporterInstance();
        test = reports.createTest(result.getMethod().getMethodName());

        // Uncomment line below is if we need parallel execution
        testLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test Success");
        test.log(Status.PASS, " Test case " + result.getMethod().getMethodName() + " is PASS");
        test.log(Status.INFO, "Test passed");

        // Uncomment lines below only if you have parallel execution and  then comment lines 32,33
//        testLocal.get().log(Status.PASS, " Test case " + result.getMethod().getMethodName() + " is PASS");
//        testLocal.get().log(Status.INFO, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test Failure");

        String testName = result.getName();

        test.log(Status.FAIL, " Test case " + result.getMethod().getMethodName() + " is FAIL");
        test.log(Status.INFO, result.getThrowable().fillInStackTrace());


        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


        test.addScreenCaptureFromPath(takeScreenShot(testName,driver),testName);

        // Uncomment lines below only if you have parallel execution and  comment lines 42, 43)
//        testLocal.get().log(Status.FAIL, " Test case " + result.getMethod().getMethodName() + " is FAIL");
//        testLocal.get().log(Status.INFO, result.getThrowable().fillInStackTrace());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On START");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On FINISH");
        if (reports != null) {
            reports.flush();
        }
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
