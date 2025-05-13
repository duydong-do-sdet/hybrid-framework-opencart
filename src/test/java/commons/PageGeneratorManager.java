package commons;

import org.openqa.selenium.WebDriver;
import pageobjects.*;
import pageobjects.account.*;

public class PageGeneratorManager {

    public static YourStorePageObject getYourStorePage(WebDriver driver) {
        return new YourStorePageObject(driver);
    }

    public static RegisterAccountPageObject getRegisterAccountPage(WebDriver driver) {
        return new RegisterAccountPageObject(driver);
    }

    public static AccountLogoutPageObject getAccountLogoutPage(WebDriver driver) {
        return new AccountLogoutPageObject(driver);
    }

    public static AccountLoginPageObject getAccountLoginPage(WebDriver driver) {
        return new AccountLoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }

    public static ForgotYourPasswordPageObject getForgotYourPasswordPageObject(WebDriver driver) {
        return new ForgotYourPasswordPageObject(driver);
    }

}
