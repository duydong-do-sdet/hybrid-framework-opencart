package page.objects.portal;

import org.openqa.selenium.WebDriver;
import page.objects.common.PortalPage;

public class PortalYourStorePage extends PortalPage {
    private WebDriver driver;

    public PortalYourStorePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
