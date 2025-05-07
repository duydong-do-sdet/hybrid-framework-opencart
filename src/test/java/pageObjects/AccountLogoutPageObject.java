package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.commons.OpenCartPageObject;
import pageUIs.AccountLogoutPageUI;

public class AccountLogoutPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public AccountLogoutPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify logout content text")
    public String getAccountLogoutContentText() {
        waitForElementToBeVisible(driver, AccountLogoutPageUI.ACCOUNT_LOGOUT_CONTENT_MESSAGE);
        return getElementText(driver, AccountLogoutPageUI.ACCOUNT_LOGOUT_CONTENT_MESSAGE);
    }

}
