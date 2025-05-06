package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.commons.OpenCartPageObject;
import pageUIs.AccountLogoutPageUI;

public class AccountLogoutPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public AccountLogoutPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getAccountLogoutContentText() {
        waitForElementToBeVisible(driver, AccountLogoutPageUI.ACCOUNT_LOGOUT_CONTENT_MESSAGE);
        return getElementText(driver, AccountLogoutPageUI.ACCOUNT_LOGOUT_CONTENT_MESSAGE);
    }

}
