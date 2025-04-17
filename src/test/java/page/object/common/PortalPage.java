package page.object.common;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.object.PageGeneratorManager;
import page.ui.common.PortalUI;

public class PortalPage extends OpenCartPage {
    private WebDriver driver;

    public PortalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Select '{0}' in 'My Account' header dropdown")
    public PortalPage selectOptionInMyAccountHeaderDropdown(String optionValue) {
        waitForElementToBeClickable(driver, PortalUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, optionValue);
        switch (optionValue) {
            case "Register":
                return PageGeneratorManager.getPortalRegisterAccountPage(driver);
            case "Logout":
                return PageGeneratorManager.getPortalAccountLogoutPage(driver);
            case "Login":
                return PageGeneratorManager.getPortalAccountLoginPage(driver);
            default:
                throw new RuntimeException("Invalid header option: '" + optionValue + "'");
        }
    }

}
