package testcases;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.YourStorePageObject;
import pageobjects.account.*;

public class Test_004_Forgotten_Password extends BaseTest {
    private WebDriver driver;
    private YourStorePageObject yourStorePage;
    private RegisterAccountPageObject registerAccountPage;
    private AccountLogoutPageObject accountLogoutPage;
    private AccountLoginPageObject accountLoginPage;
    private MyAccountPageObject myAccountPage;
    private ForgotYourPasswordPageObject forgotYourPasswordPage;
    private String firstName, lastName, emailAddress, telephone, password;
    private String notFoundEmail;

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

        notFoundEmail = "dongoc" + getRandomNumber() + "@gmail.com";

        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");
        registerAccountPage.registerNewUserAccount(firstName, lastName, emailAddress, telephone, password);
        accountLogoutPage = (AccountLogoutPageObject) registerAccountPage.selectMyAccountHeaderDropdownWithOption("Logout");
        accountLoginPage = (AccountLoginPageObject) accountLogoutPage.clickAccountColumnRightLinkByText("Login");
    }

    @Test
    public void Forgotten_Password_01_Empty_Email() {
        forgotYourPasswordPage = accountLoginPage.clickForgottenPasswordLink();

        Assert.assertTrue(forgotYourPasswordPage.isForgotYourPasswordPageContentDisplayed());

        forgotYourPasswordPage.sendKeysToEmailTextbox("");

        forgotYourPasswordPage.clickContinueButton();

        Assert.assertEquals(forgotYourPasswordPage.getWarningMessage(), "Warning: Please enter your email address!");
    }

    @Test
    public void Forgotten_Password_02_Invalid_Email() {
        forgotYourPasswordPage.clickAccountColumnRightLinkByText("Forgotten Password");

        Assert.assertTrue(forgotYourPasswordPage.isForgotYourPasswordPageContentDisplayed());

        forgotYourPasswordPage.sendKeysToEmailTextbox("dongsdet@gmail@com");

        forgotYourPasswordPage.clickContinueButton();

        Assert.assertEquals(forgotYourPasswordPage.getWarningMessage(), "Warning: Please enter a valid email address!");
    }

    @Test
    public void Forgotten_Password_03_Not_Found_Email() {
        forgotYourPasswordPage.clickAccountColumnRightLinkByText("Forgotten Password");

        Assert.assertTrue(forgotYourPasswordPage.isForgotYourPasswordPageContentDisplayed());

        forgotYourPasswordPage.sendKeysToEmailTextbox(notFoundEmail);

        forgotYourPasswordPage.clickContinueButton();

        Assert.assertEquals(forgotYourPasswordPage.getWarningMessage(), "Warning: The E-Mail Address was not found in our records, please try again!");
    }

    @Test
    public void Forgotten_Password_04_Valid_Email() {
        forgotYourPasswordPage.clickAccountColumnRightLinkByText("Forgotten Password");

        Assert.assertTrue(forgotYourPasswordPage.isForgotYourPasswordPageContentDisplayed());

        forgotYourPasswordPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage = forgotYourPasswordPage.clickContinueButton();

        Assert.assertEquals(accountLoginPage.getAlertSuccessMessage(), "An email with a confirmation link has been sent your email address.");
    }

    @AfterClass
    public void afterClass() {
        quitDriver();
    }

}
