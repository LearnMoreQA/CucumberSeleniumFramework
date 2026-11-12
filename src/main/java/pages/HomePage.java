package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    /* Locators */
    @FindBy(xpath = ".//button[@aria-label='Home Menu']")
    private WebElement discussMenu;
    @FindBy(xpath = "//span[text()='CRM']")
    private WebElement crmMenu;

    /* Methods */

    public void selectDiscuss() {
        waitForVisibilityOfElement(discussMenu);
        click(discussMenu);
    }

    public void clickCrm() {
        waitForVisibilityOfElement(crmMenu);
        click(crmMenu);
    }
}
