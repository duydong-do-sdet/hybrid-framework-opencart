package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.commons.OpenCartPageObject;
import pageUIs.RegisterAccountPageUI;

public class RegisterAccountPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public RegisterAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter '{0}' into the 'First Name' textbox")
    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter '{0}' into the 'Last Name' textbox")
    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter '{0}' into the 'Email' textbox")
    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter '{0}' into the 'Telephone' textbox")
    public void sendKeysToTelephoneTextbox(String telephoneNumber) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX, telephoneNumber);
    }

    @Step("Enter '{0}' into the 'Password' textbox")
    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter '{0}' into the 'Confirm Password' textbox")
    public void sendKeysToConfirmPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    @Step("Check 'Privacy Policy' checkbox")
    public void checkPrivacyPolicyCheckbox() {
        waitForElementToBeClickable(driver, RegisterAccountPageUI.PRIVACY_POLICY_CHECKBOX);
        checkDefaultCheckboxOrRadioButton(driver, RegisterAccountPageUI.PRIVACY_POLICY_CHECKBOX);
    }

    @Step("Click 'Continue' button")
    public void clickContinueButton() {
        waitForElementToBeClickable(driver, RegisterAccountPageUI.CONTINUE_BUTTON);
        clickElement(driver, RegisterAccountPageUI.CONTINUE_BUTTON);
    }

    @Step("Verify 'First Name' error message")
    public String getFirstNameErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Last Name' error message")
    public String getLastNameErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Email' error message")
    public String getEmailErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Telephone' error message")
    public String getTelephoneErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Verify 'Password' error message")
    public String getPasswordErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.PASSWORD_ERROR_MESSAGE);
    }

    @Step("Verify 'Confirm Password' error message")
    public String getConfirmPasswordErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Verify register warning message")
    public String getRegisterWarningMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.REGISTER_WARNING_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.REGISTER_WARNING_MESSAGE);
    }

    @Step("Verify 'Email' validate message")
    public String getEmailValidationMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.EMAIL_TEXTBOX);
        return getElementValidationMessageByJS(driver, RegisterAccountPageUI.EMAIL_TEXTBOX);
    }

    @Step("Verify register content text")
    public String getRegisterSuccessContentText() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.REGISTER_SUCCESS_CONTENT_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.REGISTER_SUCCESS_CONTENT_MESSAGE);
    }

}
