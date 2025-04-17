package page.object.portal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.object.common.PortalPage;
import page.ui.portal.PortalMyAccountUI;

public class PortalMyAccountPage extends PortalPage {
    private WebDriver driver;

    public PortalMyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify My Account content is displayed")
    public boolean isMyAccountContentDisplayed() {
        waitForElementToBeVisible(driver, PortalMyAccountUI.MY_ACCOUNT_CONTENT);
        return isElementDisplayed(driver, PortalMyAccountUI.MY_ACCOUNT_CONTENT);
    }

}
