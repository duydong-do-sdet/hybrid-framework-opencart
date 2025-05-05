package pageObjects;

import baseClasses.BasePage;
import baseClasses.GlobalConstants;
import baseClasses.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterAccountPageUI;

public class RegisterAccountPageObject extends BasePage {
    private WebDriver driver;

    public RegisterAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToTelephoneTextbox(String telephoneNumber) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX, telephoneNumber);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.PASSWORD_TEXTBOX, password);
    }

    public void sendKeysToConfirmPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void checkPrivacyPolicyCheckbox() {
        waitForElementToBeClickable(driver, RegisterAccountPageUI.PRIVACY_POLICY_CHECKBOX);
        checkDefaultCheckboxOrRadioButton(driver, RegisterAccountPageUI.PRIVACY_POLICY_CHECKBOX);
    }

    public void clickContinueButton() {
        waitForElementToBeClickable(driver, RegisterAccountPageUI.CONTINUE_BUTTON);
        clickElement(driver, RegisterAccountPageUI.CONTINUE_BUTTON);
    }

    public String getFirstNameErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.FIRSTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.LASTNAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
    }

    public String getTelephoneErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.TELEPHONE_TEXTBOX_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public String getRegisterWarningMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.REGISTER_WARNING_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.REGISTER_WARNING_MESSAGE);
    }

    public String getEmailValidationMessage() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.EMAIL_TEXTBOX);
        return getElementValidationMessageByJS(driver, RegisterAccountPageUI.EMAIL_TEXTBOX);
    }

    public String getRegisterSuccessContentText() {
        waitForElementToBeVisible(driver, RegisterAccountPageUI.REGISTER_SUCCESS_CONTENT_MESSAGE);
        return getElementText(driver, RegisterAccountPageUI.REGISTER_SUCCESS_CONTENT_MESSAGE);
    }

    public AccountLogoutPageObject selectLogoutInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, RegisterAccountPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        clickElement(driver, RegisterAccountPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
        clickElement(driver, RegisterAccountPageUI.LOGOUT_OPTION);
        return PageGeneratorManager.getAccountLogoutPage(driver);
    }

}
