package pageobjects.account;

import commons.PageGeneratorManager;
import interfaces.account.ForgotYourPasswordPageUI;
import interfaces.account.MyAccountPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.AccountPageObject;

public class ForgotYourPasswordPageObject extends AccountPageObject {
    private WebDriver driver;

    public ForgotYourPasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify 'My Account' content is displayed")
    public boolean isMyAccountContentDisplayed() {
        waitForElementToBeVisible(driver, MyAccountPageUI.MY_ACCOUNT_CONTENT);
        return isElementDisplayed(driver, MyAccountPageUI.MY_ACCOUNT_CONTENT);
    }

    public boolean isForgotYourPasswordPageContentDisplayed() {
        waitForElementToBeVisible(driver, ForgotYourPasswordPageUI.FORGOT_YOUR_PASSWORD_PAGE_CONTENT);
        return isElementDisplayed(driver, ForgotYourPasswordPageUI.FORGOT_YOUR_PASSWORD_PAGE_CONTENT);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, ForgotYourPasswordPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, ForgotYourPasswordPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public AccountLoginPageObject clickContinueButton() {
        waitForElementToBeClickable(driver, ForgotYourPasswordPageUI.CONTINUE_BUTTON);
        clickElement(driver, ForgotYourPasswordPageUI.CONTINUE_BUTTON);
        return PageGeneratorManager.getAccountLoginPage(driver);
    }

    public String getWarningMessage() {
        waitForElementToBeVisible(driver, ForgotYourPasswordPageUI.ALERT_DANGER_MESSAGE);
        return getElementText(driver, ForgotYourPasswordPageUI.ALERT_DANGER_MESSAGE);
    }

}
