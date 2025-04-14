package page.object.portal;

import org.openqa.selenium.WebDriver;
import page.object.common.PortalPage;
import page.ui.portal.PortalRegisterAccountUI;

public class PortalRegisterAccountPage extends PortalPage {
    private WebDriver driver;

    public PortalRegisterAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX, lastName);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToTelephoneTextbox(String telephoneNumber) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX, telephoneNumber);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.PASSWORD_TEXTBOX, password);
    }

    public void sendKeysToConfirmPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void checkPrivacyPolicyCheckbox() {
        waitForElementToBeClickable(driver, PortalRegisterAccountUI.PRIVACY_POLICY_CHECKBOX);
        checkDefaultCheckboxOrRadioButton(driver, PortalRegisterAccountUI.PRIVACY_POLICY_CHECKBOX);
    }

    public void clickContinueButton() {
        waitForElementToBeClickable(driver, PortalRegisterAccountUI.CONTINUE_BUTTON);
        clickElement(driver, PortalRegisterAccountUI.CONTINUE_BUTTON);
    }

    public String getFirstNameErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
    }

    public String getTelephoneErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public String getRegisterWarningMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.REGISTER_WARNING_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.REGISTER_WARNING_MESSAGE);
    }

    public String getRegisterSuccessMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.REGISTER_SUCCESS_MESSAGE);
    }

}
