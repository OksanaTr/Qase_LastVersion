package tests.bases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utils.PropertyReader;

public class TestListener extends TestListenerAdapter {

    public void onTestStart(ITestResult result) {

        System.out.printf("Test started: %s%n", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        PropertyReader.getProperties(String.valueOf(driver));
                System.out.printf("Test failed: %s%n", result.getName());
    }
}