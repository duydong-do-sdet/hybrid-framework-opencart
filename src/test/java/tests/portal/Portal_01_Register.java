package tests.portal;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.PageGeneratorManager;
import page.object.portal.PortalAccountLogoutPage;
import page.object.portal.PortalRegisterAccountPage;
import page.object.portal.PortalYourStorePage;

public class Portal_01_Register extends BaseTest {
    private WebDriver driver;
    private PortalYourStorePage yourStorePage;
    private PortalRegisterAccountPage registerAccountPage;
    private PortalAccountLogoutPage accountLogoutPage;
    private String firstName, lastName, emailAddress, telephoneNumber, password;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        yourStorePage = PageGeneratorManager.getPortalYourStorePage(driver);

        firstName = "Dong";
        lastName = "Do";
        emailAddress = "dong.sdet" + getRandomNumber() + "@gmail.com";
        telephoneNumber = "0789123456";
        password = "SeJava4@";
    }

    @Test
    public void Register_01_Empty_Data() {
        registerAccountPage = (PortalRegisterAccountPage) yourStorePage.selectOptionInMyAccountHeaderDropdown("Register");

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getFirstNameErrorMessage(), "First Name must be between 1 and 32 characters!");

        Assert.assertEquals(registerAccountPage.getLastNameErrorMessage(), "Last Name must be between 1 and 32 characters!");

        Assert.assertEquals(registerAccountPage.getEmailErrorMessage(), "E-Mail Address does not appear to be valid!");

        Assert.assertEquals(registerAccountPage.getTelephoneErrorMessage(), "Telephone must be between 3 and 32 characters!");

        Assert.assertEquals(registerAccountPage.getPasswordErrorMessage(), "Password must be between 4 and 20 characters!");
    }

    @Test
    public void Register_02_Invalid_Email() {
        registerAccountPage.selectOptionInMyAccountHeaderDropdown("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox("dong.sdet@gmail@com");

        registerAccountPage.sendKeysToTelephoneTextbox(telephoneNumber);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox(password);

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();
    }

    @Test
    public void Register_03_Valid_Data() {
        registerAccountPage.selectOptionInMyAccountHeaderDropdown("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephoneNumber);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox(password);

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getRegisterSuccessMessage(), "Your Account Has Been Created!");

        accountLogoutPage = (PortalAccountLogoutPage) registerAccountPage.selectOptionInMyAccountHeaderDropdown("Logout");

        Assert.assertEquals(accountLogoutPage.getLogoutSuccessMessage(), "Account Logout");
    }

    @Test
    public void Register_04_Existing_Email() {
        registerAccountPage = (PortalRegisterAccountPage) accountLogoutPage.selectOptionInMyAccountHeaderDropdown("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephoneNumber);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox(password);

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getRegisterWarningMessage(), "Warning: E-Mail Address is already registered!");
    }

    @Test
    public void Register_05_Invalid_Password() {
        registerAccountPage.selectOptionInMyAccountHeaderDropdown("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephoneNumber);

        registerAccountPage.sendKeysToPasswordTextbox("Se4");

        registerAccountPage.sendKeysToConfirmPasswordTextbox("Se4");

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getPasswordErrorMessage(), "Password must be between 4 and 20 characters!");
    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        registerAccountPage.selectOptionInMyAccountHeaderDropdown("Register");

        registerAccountPage.sendKeysToFirstNameTextbox(firstName);

        registerAccountPage.sendKeysToLastNameTextbox(lastName);

        registerAccountPage.sendKeysToEmailTextbox(emailAddress);

        registerAccountPage.sendKeysToTelephoneTextbox(telephoneNumber);

        registerAccountPage.sendKeysToPasswordTextbox(password);

        registerAccountPage.sendKeysToConfirmPasswordTextbox("SeJava@4");

        registerAccountPage.checkPrivacyPolicyCheckbox();

        registerAccountPage.clickContinueButton();

        Assert.assertEquals(registerAccountPage.getConfirmPasswordErrorMessage(), "Password confirmation does not match password!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
