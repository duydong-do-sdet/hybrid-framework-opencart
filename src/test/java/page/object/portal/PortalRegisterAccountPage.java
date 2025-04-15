package page.object.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.object.common.PortalPage;
import page.ui.portal.PortalRegisterAccountUI;

public class PortalRegisterAccountPage extends PortalPage {
    private WebDriver driver;

    public PortalRegisterAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter '{0}' into the 'First Name' textbox")
    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter '{0}' into the 'Last Name' textbox")
    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter '{0}' into the 'Email' textbox")
    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter '{0}' into the 'Telephone' textbox")
    public void sendKeysToTelephoneTextbox(String telephoneNumber) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX, telephoneNumber);
    }

    @Step("Enter '{0}' into the 'Password' textbox")
    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter '{0}' into the 'Confirm Password' textbox")
    public void sendKeysToConfirmPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    @Step("Check 'Privacy Policy' checkbox")
    public void checkPrivacyPolicyCheckbox() {
        waitForElementToBeClickable(driver, PortalRegisterAccountUI.PRIVACY_POLICY_CHECKBOX);
        checkDefaultCheckboxOrRadioButton(driver, PortalRegisterAccountUI.PRIVACY_POLICY_CHECKBOX);
    }

    @Step("Click 'Continue' button")
    public void clickContinueButton() {
        waitForElementToBeClickable(driver, PortalRegisterAccountUI.CONTINUE_BUTTON);
        clickElement(driver, PortalRegisterAccountUI.CONTINUE_BUTTON);
    }

    @Step("Verify 'First Name' error message")
    public String getFirstNameErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Last Name' error message")
    public String getLastNameErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Email' error message")
    public String getEmailErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Telephone' error message")
    public String getTelephoneErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Password' error message")
    public String getPasswordErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.PASSWORD_ERROR_MESSAGE);
    }

    @Step("Verify 'Confirm Password' error message")
    public String getConfirmPasswordErrorMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Verify register warning message")
    public String getRegisterWarningMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.REGISTER_WARNING_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.REGISTER_WARNING_MESSAGE);
    }

    @Step("Verify register success message")
    public String getRegisterSuccessMessage() {
        waitForElementToBeVisible(driver, PortalRegisterAccountUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, PortalRegisterAccountUI.REGISTER_SUCCESS_MESSAGE);
    }

}
