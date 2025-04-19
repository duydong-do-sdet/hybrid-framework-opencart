package tests.portal;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.PageGeneratorManager;
import page.object.portal.*;

public class Portal_02_Login extends BaseTest {
    private WebDriver driver;
    private PortalYourStorePage yourStorePage;
    private PortalRegisterAccountPage registerAccountPage;
    private PortalAccountLogoutPage accountLogoutPage;
    private PortalAccountLoginPage accountLoginPage;
    private PortalMyAccountPage myAccountPage;
    private String firstName, lastName, emailAddress, telephoneNumber, password;
    private String invalidEmail, notFoundEmail, incorrectPass;

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

        invalidEmail = "dong.sdet" + getRandomNumber() + "@gmail@com";
        notFoundEmail = "dong.demo" + getRandomNumber() + "@gmail@com";
        incorrectPass = "JavaSe4@";

        registerAccountPage = (PortalRegisterAccountPage) yourStorePage.selectOptionInMyAccountHeaderDropdown("Register");
        registerAccountPage.registerNewUserAccount(firstName, lastName, emailAddress, telephoneNumber, password);
        accountLogoutPage = (PortalAccountLogoutPage) registerAccountPage.selectOptionInMyAccountHeaderDropdown("Logout");
    }

    @Test
    public void Register_01_Empty_Data() {
        accountLoginPage = (PortalAccountLoginPage) accountLogoutPage.selectOptionInMyAccountHeaderDropdown("Login");

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: Please enter your email address!");
    }

    @Test
    public void Register_02_Invalid_Email() {
        accountLoginPage.selectOptionInMyAccountHeaderDropdown("Login");

        accountLoginPage.sendKeysToEmailTextbox(invalidEmail);

        accountLoginPage.sendKeysToPasswordTextbox(password);

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: Please enter a valid email address!");
    }

    @Test
    public void Register_03_Not_Found_Email() {
        accountLoginPage.selectOptionInMyAccountHeaderDropdown("Login");

        accountLoginPage.sendKeysToEmailTextbox(notFoundEmail);

        accountLoginPage.sendKeysToPasswordTextbox(password);

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: No customer account found!");
    }

    @Test
    public void Register_04_Empty_Password() {
        accountLoginPage.selectOptionInMyAccountHeaderDropdown("Login");

        accountLoginPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage.sendKeysToPasswordTextbox("");

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: Please enter your password!");
    }

    @Test
    public void Register_05_Incorrect_Password() {
        accountLoginPage.selectOptionInMyAccountHeaderDropdown("Login");

        accountLoginPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage.sendKeysToPasswordTextbox(incorrectPass);

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: The password provided is incorrect!");
    }

    @Test
    public void Register_06_Valid_Data() {
        accountLoginPage.selectOptionInMyAccountHeaderDropdown("Login");

        accountLoginPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage.sendKeysToPasswordTextbox(password);

        myAccountPage = accountLoginPage.clickLoginButton();

        Assert.assertTrue(myAccountPage.isMyAccountContentDisplayed());

        accountLogoutPage = (PortalAccountLogoutPage) myAccountPage.selectOptionInMyAccountHeaderDropdown("Logout");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitDriver();
    }

}
