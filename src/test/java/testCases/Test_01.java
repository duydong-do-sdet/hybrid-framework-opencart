package testCases;

import baseClasses.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_01 extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
    }

    @Test
    public void TC_01() {
    }

    @Test
    public void TC_02() {
    }

    @AfterClass
    public void afterClass() {
        quitDriver();
    }

}
