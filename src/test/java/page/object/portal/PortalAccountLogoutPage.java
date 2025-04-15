package page.object.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.object.common.PortalPage;
import page.ui.portal.PortalAccountLogoutUI;

public class PortalAccountLogoutPage extends PortalPage {
    private WebDriver driver;

    public PortalAccountLogoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify logout success message")
    public String getLogoutSuccessMessage() {
        waitForElementToBeVisible(driver, PortalAccountLogoutUI.LOGOUT_SUCCESS_MESSAGE);
        return getElementText(driver, PortalAccountLogoutUI.LOGOUT_SUCCESS_MESSAGE);
    }

}
