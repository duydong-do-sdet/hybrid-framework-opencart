package page.object;

import org.openqa.selenium.WebDriver;
import page.object.portal.PortalAccountLogoutPage;
import page.object.portal.PortalRegisterAccountPage;
import page.object.portal.PortalYourStorePage;

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

}
