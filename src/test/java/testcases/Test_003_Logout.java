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
import pageobjects.account.AccountLoginPageObject;
import pageobjects.account.AccountLogoutPageObject;
import pageobjects.account.MyAccountPageObject;
import pageobjects.account.RegisterAccountPageObject;

public class Test_003_Logout extends BaseTest {
    private WebDriver driver;
    private YourStorePageObject yourStorePage;
    private RegisterAccountPageObject registerAccountPage;
    private AccountLogoutPageObject accountLogoutPage;
    private AccountLoginPageObject accountLoginPage;
    private MyAccountPageObject myAccountPage;
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
    public void Logout_001_Register_Logout_Column_Right() {
        registerAccountPage = (RegisterAccountPageObject) yourStorePage.selectMyAccountHeaderDropdownWithOption("Register");

        registerAccountPage.registerNewUserAccount(firstName, lastName, emailAddress, telephone, password);

        accountLogoutPage = (AccountLogoutPageObject) registerAccountPage.clickAccountColumnRightLinkByText("Logout");

        Assert.assertEquals(accountLogoutPage.getAccountLogoutContentText(), "Account Logout");
    }

    @Test
    public void Logout_002_Login_Logout_Column_Right() {
        accountLoginPage = (AccountLoginPageObject) accountLogoutPage.selectMyAccountHeaderDropdownWithOption("Login");

        myAccountPage = accountLoginPage.loginToSystem(emailAddress, password);

        accountLogoutPage = (AccountLogoutPageObject) myAccountPage.clickAccountColumnRightLinkByText("Logout");

        Assert.assertEquals(accountLogoutPage.getAccountLogoutContentText(), "Account Logout");
    }

    @AfterClass
    public void afterClass() {
        quitDriver();
    }

}
