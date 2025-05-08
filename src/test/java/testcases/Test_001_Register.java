package testcases;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.AccountLogoutPageObject;
import pageobjects.RegisterAccountPageObject;
import pageobjects.YourStorePageObject;

public class Test_001_Register extends BaseTest {
    private WebDriver driver;
    private YourStorePageObject yourStorePage;
    private RegisterAccountPageObject registerAccountPage;
    private AccountLogoutPageObject accountLogoutPage;
    private String firstName, lastName, emailAddress, telephone, password;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        yourStorePage = PageGeneratorManager.getYourStorePage(driver);

        firstName = "Dong";
        lastName = "Do";
        emailAddress = "dongsdet" + getRandomNumber() + "@gmail.com";
        telephone = "0123456789";
        password = "SeJava4@";
    }

    @Test
    public void Register_001_Empty_Data() {
        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.sendKeysToFirstNameTextbox("");

        registerAccountPage.sendKeysToLastNameTextbox("");

        registerAccountPage.sendKeysToEmailTextbox("");

        registerAccountPage.sendKeysToTelephoneTextbox("");

        registerAccountPage.sendKeysToPasswordTextbox("");

        registerAccountPage.sendKeysToConfirmPasswordTextbox("");

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getFirstNameErrorMessage(), "First Name must be between 1 and 32 characters!");

        Assert.assertEquals(registerAccountPage.getLastNameErrorMessage(), "Last Name must be between 1 and 32 characters!");

        Assert.assertEquals(registerAccountPage.getEmailErrorMessage(), "E-Mail Address does not appear to be valid!");

        Assert.assertEquals(registerAccountPage.getTelephoneErrorMessage(), "Telephone must be between 3 and 32 characters!");

        Assert.assertEquals(registerAccountPage.getPasswordErrorMessage(), "Password must be between 4 and 20 characters!");

        Assert.assertEquals(registerAccountPage.getRegisterWarningMessage(), "Warning: You must agree to the Privacy Policy!");
    }

    @Test
    public void Register_002_Invalid_Email() {
        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox("dongsdet@gmail@com");

        registerAccountPage.sendKeysToTelephoneTextbox(telephone);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox(password);

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getEmailValidationMessage(), "Invalid Email!");
    }

    @Test
    public void Register_003_Invalid_Password() {
        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephone);

        registerAccountPage.sendKeysToPasswordTextbox("SeJ");

        registerAccountPage.sendKeysToConfirmPasswordTextbox("SeJ");

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getPasswordErrorMessage(), "Password must be between 4 and 20 characters!");
    }

    @Test
    public void Register_004_Incorrect_Confirm_Password() {
        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephone);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox("Selenium4@");

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getConfirmPasswordErrorMessage(), "Password confirmation does not match password!");
    }

    @Test
    public void Register_005_Valid_Data() {
        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephone);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox(password);

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getRegisterSuccessContentText(), "Your Account Has Been Created!");

        accountLogoutPage = (AccountLogoutPageObject) registerAccountPage.selectMyAccountHeaderDropdownWithOption("Logout");

        Assert.assertEquals(accountLogoutPage.getAccountLogoutContentText(), "Account Logout");
    }

    @Test
    public void Register_006_Existing_Email() {
        registerAccountPage = (RegisterAccountPageObject) accountLogoutPage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephone);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox(password);

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getRegisterWarningMessage(), "Warning: E-Mail Address is already registered!");
    }

    @AfterClass
    public void afterClass() {
        quitDriver();
    }

}
