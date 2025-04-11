package page.objects.common;

import org.openqa.selenium.WebDriver;

public class PortalPage extends OpenCartPage {
    private WebDriver driver;

    public PortalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
