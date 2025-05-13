package pageobjects.account;

import commons.PageGeneratorManager;
import interfaces.account.AccountLoginPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.AccountPageObject;

public class AccountLoginPageObject extends AccountPageObject {
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
        waitForElementToBeVisible(driver, AccountLoginPageUI.ALERT_DANGER_MESSAGE);
        return getElementText(driver, AccountLoginPageUI.ALERT_DANGER_MESSAGE);
    }

    @Step("Login by 'Email: {0}' 'Password: {1}'")
    public MyAccountPageObject loginToSystem(String emailAddress, String password) {
        sendKeysToEmailTextbox(emailAddress);
        sendKeysToPasswordTextbox(password);
        return clickLoginButton();
    }

    public ForgotYourPasswordPageObject clickForgottenPasswordLink() {
        waitForElementToBeClickable(driver, AccountLoginPageUI.FORGOTTEN_PASSWORD_LINK);
        clickElement(driver, AccountLoginPageUI.FORGOTTEN_PASSWORD_LINK);
        return PageGeneratorManager.getForgotYourPasswordPageObject(driver);
    }

    public String getAlertSuccessMessage() {
        waitForElementToBeVisible(driver, AccountLoginPageUI.ALERT_SUCCESS_MESSAGE);
        return getElementText(driver, AccountLoginPageUI.ALERT_SUCCESS_MESSAGE);
    }

}
