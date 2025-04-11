package page.object;

import org.openqa.selenium.WebDriver;
import page.object.portal.PortalYourStorePage;

public class PageGeneratorManager {

    public static PortalYourStorePage getHomePage(WebDriver driver) {
        return new PortalYourStorePage(driver);
    }

}
