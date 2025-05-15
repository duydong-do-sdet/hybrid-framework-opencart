package testcases;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.SearchPageObject;
import pageobjects.YourStorePageObject;

public class Test_005_Search extends BaseTest {
    private WebDriver driver;
    private YourStorePageObject yourStorePage;
    private SearchPageObject searchPage;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        yourStorePage = PageGeneratorManager.getYourStorePage(driver);
    }

    @Test
    public void Search_01_Empty_Data() {
        yourStorePage.sendKeysToSearchTextbox("");

        searchPage = yourStorePage.clickSearchButton();

        Assert.assertTrue(searchPage.isSearchContentDisplayedByText("Search"));

        Assert.assertTrue(searchPage.isSearchTitleResultDisplayed());

        Assert.assertTrue(searchPage.isNoProductMatchesMessageDisplayed());
    }

    @AfterClass
    public void afterClass() {
        quitDriver();
    }

}
