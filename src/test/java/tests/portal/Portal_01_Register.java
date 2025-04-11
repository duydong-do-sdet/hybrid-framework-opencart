package tests.portal;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.PageGeneratorManager;
import page.objects.portal.PortalYourStorePage;

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
    public void Register_01() {
    }

    @Test
    public void Register_02() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
