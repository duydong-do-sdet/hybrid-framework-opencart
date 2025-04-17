package page.object.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.object.PageGeneratorManager;
import page.object.common.PortalPage;
import page.ui.portal.PortalAccountLoginUI;

public class PortalAccountLoginPage extends PortalPage {
    private WebDriver driver;

    public PortalAccountLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter '{0}' into the 'Email' textbox")
    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, PortalAccountLoginUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, PortalAccountLoginUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter '{0}' into the 'Password' textbox")
    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalAccountLoginUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalAccountLoginUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click 'Login' button")
    public PortalMyAccountPage clickLoginButton() {
        waitForElementToBeClickable(driver, PortalAccountLoginUI.LOGIN_BUTTON);
        clickElement(driver, PortalAccountLoginUI.LOGIN_BUTTON);
        return PageGeneratorManager.getPortalMyAccountPage(driver);
    }

    @Step("Verify login warning message")
    public String getLoginWarningMessage() {
        waitForElementToBeVisible(driver, PortalAccountLoginUI.LOGIN_WARNING_MESSAGE);
        return getElementText(driver, PortalAccountLoginUI.LOGIN_WARNING_MESSAGE);
    }

}
