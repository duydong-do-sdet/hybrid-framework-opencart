package pageobjects;

import interfaces.SearchPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.commons.OpenCartPageObject;

public class SearchPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify search content '{0}' is displayed")
    public boolean isSearchContentDisplayedByText(String searchContent) {
        waitForElementToBeVisible(driver, SearchPageUI.SEARCH_CONTENT, searchContent);
        return isElementDisplayed(driver, SearchPageUI.SEARCH_CONTENT, searchContent);
    }

    @Step("Verify search title result is displayed")
    public boolean isSearchTitleResultDisplayed() {
        waitForElementToBeVisible(driver, SearchPageUI.SEARCH_TITLE_RESULT);
        return isElementDisplayed(driver, SearchPageUI.SEARCH_TITLE_RESULT);
    }

    @Step("Verify no product matched message is displayed")
    public boolean isNoProductMatchesMessageDisplayed() {
        waitForElementToBeVisible(driver, SearchPageUI.NO_PRODUCT_MATCHES_MESSAGE);
        return isElementDisplayed(driver, SearchPageUI.NO_PRODUCT_MATCHES_MESSAGE);
    }

}
