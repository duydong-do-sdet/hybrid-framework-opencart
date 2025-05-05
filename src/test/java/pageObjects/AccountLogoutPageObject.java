package pageObjects;

import baseClasses.BasePage;
import baseClasses.GlobalConstants;
import baseClasses.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.AccountLogoutPageUI;

public class AccountLogoutPageObject extends BasePage {
    private WebDriver driver;

    public AccountLogoutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountLogoutContentText() {
        waitForElementToBeVisible(driver, AccountLogoutPageUI.ACCOUNT_LOGOUT_CONTENT_MESSAGE);
        return getElementText(driver, AccountLogoutPageUI.ACCOUNT_LOGOUT_CONTENT_MESSAGE);
    }

    public RegisterAccountPageObject selectRegisterInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, AccountLogoutPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        clickElement(driver, AccountLogoutPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
        clickElement(driver, AccountLogoutPageUI.REGISTER_OPTION);
        return PageGeneratorManager.getRegisterAccountPage(driver);
    }

}
