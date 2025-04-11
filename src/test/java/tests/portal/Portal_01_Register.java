package tests.portal;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.PageGeneratorManager;
import page.object.portal.PortalYourStorePage;

public class Portal_01_Register extends BaseTest {
    private WebDriver driver;
    private PortalYourStorePage homePage;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Register_01_Empty_Data() {
    }

    @Test
    public void Register_02_Invalid_Email() {
    }

    @Test
    public void Register_03_Valid_Data() {
    }

    @Test
    public void Register_04_Existing_Email() {
    }

    @Test
    public void Register_05_Invalid_Password() {
    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
