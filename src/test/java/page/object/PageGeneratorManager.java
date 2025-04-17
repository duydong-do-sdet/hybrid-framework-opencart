package page.object;

import org.openqa.selenium.WebDriver;
import page.object.portal.*;

public class PageGeneratorManager {

    public static PortalYourStorePage getPortalYourStorePage(WebDriver driver) {
        return new PortalYourStorePage(driver);
    }

    public static PortalRegisterAccountPage getPortalRegisterAccountPage(WebDriver driver) {
        return new PortalRegisterAccountPage(driver);
    }

    public static PortalAccountLogoutPage getPortalAccountLogoutPage(WebDriver driver) {
        return new PortalAccountLogoutPage(driver);
    }

    public static PortalAccountLoginPage getPortalAccountLoginPage(WebDriver driver) {
        return new PortalAccountLoginPage(driver);
    }
    public static PortalMyAccountPage getPortalMyAccountPage(WebDriver driver) {
        return new PortalMyAccountPage(driver);
    }

}
