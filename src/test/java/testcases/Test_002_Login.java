package testcases;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.*;
import pageobjects.account.AccountLoginPageObject;
import pageobjects.account.AccountLogoutPageObject;
import pageobjects.account.MyAccountPageObject;
import pageobjects.account.RegisterAccountPageObject;

public class Test_002_Login extends BaseTest {
    private WebDriver driver;
    private YourStorePageObject yourStorePage;
    private RegisterAccountPageObject registerAccountPage;
    private AccountLogoutPageObject accountLogoutPage;
    private AccountLoginPageObject accountLoginPage;
    private MyAccountPageObject myAccountPage;
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
    }

    @Test
    public void Login_001_Empty_Data() {
        accountLoginPage = (AccountLoginPageObject) accountLogoutPage.selectMyAccountHeaderDropdownWithOption("Login");

        accountLoginPage.sendKeysToEmailTextbox("");

        accountLoginPage.sendKeysToPasswordTextbox("");

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: Please enter your email address!");
    }

    @Test
    public void Login_002_Invalid_Email() {
        accountLoginPage.selectMyAccountHeaderDropdownWithOption("Login");

        accountLoginPage.sendKeysToEmailTextbox("dongsdet@gmail@com");

        accountLoginPage.sendKeysToPasswordTextbox(password);

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: Please enter a valid email address!");
    }

    @Test
    public void Login_003_Not_Found_Email() {
        accountLoginPage.selectMyAccountHeaderDropdownWithOption("Login");

        accountLoginPage.sendKeysToEmailTextbox(notFoundEmail);

        accountLoginPage.sendKeysToPasswordTextbox(password);

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: The E-Mail Address was not found in our records, please try again!");
    }

    @Test
    public void Login_004_Empty_Password() {
        accountLoginPage.selectMyAccountHeaderDropdownWithOption("Login");

        accountLoginPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage.sendKeysToPasswordTextbox("");

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: Please enter your password!");
    }

    @Test
    public void Login_005_Incorrect_Password() {
        accountLoginPage.selectMyAccountHeaderDropdownWithOption("Login");

        accountLoginPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage.sendKeysToPasswordTextbox("JavaSe4@");

        accountLoginPage.clickLoginButton();

        Assert.assertEquals(accountLoginPage.getLoginWarningMessage(), "Warning: The password provided is incorrect!");
    }

    @Test
    public void Login_006_Valid_Data() {
        accountLoginPage.selectMyAccountHeaderDropdownWithOption("Login");

        accountLoginPage.sendKeysToEmailTextbox(emailAddress);

        accountLoginPage.sendKeysToPasswordTextbox(password);

        myAccountPage = accountLoginPage.clickLoginButton();

        Assert.assertTrue(myAccountPage.isMyAccountContentDisplayed());

        accountLogoutPage = (AccountLogoutPageObject) myAccountPage.selectMyAccountHeaderDropdownWithOption("Logout");

        Assert.assertEquals(accountLogoutPage.getAccountLogoutContentText(), "Account Logout");
    }

    @AfterClass
    public void afterClass() {
        quitDriver();
    }

}
