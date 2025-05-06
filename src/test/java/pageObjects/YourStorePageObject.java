package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.commons.OpenCartPageObject;

public class YourStorePageObject extends OpenCartPageObject {
    private WebDriver driver;

    public YourStorePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
