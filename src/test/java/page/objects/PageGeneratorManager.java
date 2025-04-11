package page.objects;

import org.openqa.selenium.WebDriver;
import page.objects.portal.PortalYourStorePage;

public class PageGeneratorManager {

    public static PortalYourStorePage getHomePage(WebDriver driver) {
        return new PortalYourStorePage(driver);
    }

}
