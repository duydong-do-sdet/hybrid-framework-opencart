package pageobjects;

import commons.PageGeneratorManager;
import interfaces.AccountPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.commons.OpenCartPageObject;

public class AccountPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public AccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click '{0}' link in account column right")
    public AccountPageObject clickAccountColumnRightLinkByText(String linkText) {
        waitForElementToBeClickable(driver, AccountPageUI.ACCOUNT_COLUMN_RIGHT_LINK_BY_TEXT, linkText);
        clickElement(driver, AccountPageUI.ACCOUNT_COLUMN_RIGHT_LINK_BY_TEXT, linkText);
        switch (linkText) {
            case "Logout":
                return PageGeneratorManager.getAccountLogoutPage(driver);
            case "Login":
                return PageGeneratorManager.getAccountLoginPage(driver);
            case "Forgotten Password":
                return PageGeneratorManager.getForgotYourPasswordPageObject(driver);
            default:
                throw new RuntimeException("Invalid column right link text: '" + linkText + "'");
        }
    }

}
