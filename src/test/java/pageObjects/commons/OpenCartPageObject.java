package pageObjects.commons;

import baseClasses.BasePage;
import baseClasses.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.commons.OpenCartPageUI;

public class OpenCartPageObject extends BasePage {
    private WebDriver driver;

    public OpenCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public OpenCartPageObject selectMyAccountHeaderDropdownWithOption(String optionValue) {
        waitForElementToBeClickable(driver, OpenCartPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, OpenCartPageUI.MY_ACCOUNT_HEADER_DROPDOWN, OpenCartPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, optionValue);
        switch (optionValue) {
            case "Register":
                return PageGeneratorManager.getRegisterAccountPage(driver);
            case "Logout":
                return PageGeneratorManager.getAccountLogoutPage(driver);
            default:
                throw new RuntimeException("Invalid header option: '" + optionValue + "'");
        }
    }

}
