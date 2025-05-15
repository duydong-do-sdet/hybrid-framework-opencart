package interfaces.commons;

public class OpenCartPageUI {

    public static final String MY_ACCOUNT_HEADER_DROPDOWN = "//nav[@id='top']//li[@class='dropdown']//span[text()='My Account']";
    public static final String MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS = "//nav[@id='top']//a[@title='My Account']/parent::li/ul//a";

    public static final String SEARCH_TEXTBOX = "//header//input[@name='search']";
    public static final String SEARCH_BUTTON = "//header//i[contains(@class,'search')]/parent::button";

}
