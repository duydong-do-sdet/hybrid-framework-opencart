package baseClasses;

import org.openqa.selenium.WebDriver;
import pageObjects.AccountLogoutPageObject;
import pageObjects.RegisterAccountPageObject;
import pageObjects.YourStorePageObject;

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

}
