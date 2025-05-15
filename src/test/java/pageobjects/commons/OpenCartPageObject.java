package pageobjects.commons;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import interfaces.commons.OpenCartPageUI;
import pageobjects.SearchPageObject;

public class OpenCartPageObject extends BasePage {
    private WebDriver driver;

    public OpenCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select '{0}' in 'My Account' header dropdown")
    public OpenCartPageObject selectMyAccountHeaderDropdownWithOption(String optionValue) {
        waitForElementToBeClickable(driver, OpenCartPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, OpenCartPageUI.MY_ACCOUNT_HEADER_DROPDOWN, OpenCartPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, optionValue);
        switch (optionValue) {
            case "Register":
                return PageGeneratorManager.getRegisterAccountPage(driver);
            case "Logout":
                return PageGeneratorManager.getAccountLogoutPage(driver);
            case "Login":
                return PageGeneratorManager.getAccountLoginPage(driver);
            default:
                throw new RuntimeException("Invalid header option: '" + optionValue + "'");
        }
    }

    @Step("Enter '{0}' into the 'Search' textbox")
    public void sendKeysToSearchTextbox(String value) {
        waitForElementToBeVisible(driver, OpenCartPageUI.SEARCH_TEXTBOX);
        sendKeysToElement(driver, OpenCartPageUI.SEARCH_TEXTBOX, value);
    }

    @Step("Click the 'Search' button")
    public SearchPageObject clickSearchButton() {
        waitForElementToBeVisible(driver, OpenCartPageUI.SEARCH_BUTTON);
        clickElement(driver, OpenCartPageUI.SEARCH_BUTTON);
        return PageGeneratorManager.getSearchPage(driver);
    }

}
