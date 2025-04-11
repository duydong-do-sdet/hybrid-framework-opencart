package page.objects.common;

import org.openqa.selenium.WebDriver;

public class AdminPage extends OpenCartPage {
    private WebDriver driver;

    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
