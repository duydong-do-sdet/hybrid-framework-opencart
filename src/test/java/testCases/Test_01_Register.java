package testCases;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;

public class Test_01_Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Register_01() {
        Assert.assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void Register_02() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='logo']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
