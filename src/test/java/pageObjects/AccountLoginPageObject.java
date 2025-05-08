package pageObjects;

import baseClasses.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.commons.OpenCartPageObject;
import pageUIs.AccountLoginPageUI;

public class AccountLoginPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public AccountLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter '{0}' into the 'Email' textbox")
    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, AccountLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, AccountLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter '{0}' into the 'Password' textbox")
    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, AccountLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AccountLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click 'Login' button")
    public MyAccountPageObject clickLoginButton() {
        waitForElementToBeClickable(driver, AccountLoginPageUI.LOGIN_BUTTON);
        clickElement(driver, AccountLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getMyAccountPage(driver);
    }

    @Step("Verify login warning message")
    public String getLoginWarningMessage() {
        waitForElementToBeVisible(driver, AccountLoginPageUI.LOGIN_WARNING_MESSAGE);
        return getElementText(driver, AccountLoginPageUI.LOGIN_WARNING_MESSAGE);
    }

}
