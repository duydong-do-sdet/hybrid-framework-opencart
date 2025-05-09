package pageobjects.account;

import interfaces.account.MyAccountPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.AccountPageObject;

public class MyAccountPageObject extends AccountPageObject {
    private WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify 'My Account' content is displayed")
    public boolean isMyAccountContentDisplayed() {
        waitForElementToBeVisible(driver, MyAccountPageUI.MY_ACCOUNT_CONTENT);
        return isElementDisplayed(driver, MyAccountPageUI.MY_ACCOUNT_CONTENT);
    }

}
