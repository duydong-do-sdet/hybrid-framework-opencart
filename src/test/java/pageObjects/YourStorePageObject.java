package pageObjects;

import baseClasses.BasePage;
import baseClasses.GlobalConstants;
import baseClasses.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.YourStorePageUI;

public class YourStorePageObject extends BasePage {
    private WebDriver driver;

    public YourStorePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterAccountPageObject selectRegisterInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, YourStorePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        clickElement(driver, YourStorePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
        clickElement(driver, YourStorePageUI.REGISTER_OPTION);
        return PageGeneratorManager.getRegisterAccountPage(driver);
    }

}
