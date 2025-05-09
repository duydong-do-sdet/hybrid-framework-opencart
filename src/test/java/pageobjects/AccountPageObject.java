package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.commons.OpenCartPageObject;

public class AccountPageObject extends OpenCartPageObject {
    private WebDriver driver;

    public AccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
