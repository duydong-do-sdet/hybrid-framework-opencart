package page.object.portal;

import org.openqa.selenium.WebDriver;
import page.object.common.PortalPage;
import page.ui.portal.PortalAccountLogoutUI;

public class PortalAccountLogoutPage extends PortalPage {
    private WebDriver driver;

    public PortalAccountLogoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getLogoutSuccessMessage() {
        waitForElementToBeVisible(driver, PortalAccountLogoutUI.LOGOUT_SUCCESS_MESSAGE);
        return getElementText(driver, PortalAccountLogoutUI.LOGOUT_SUCCESS_MESSAGE);
    }

}
