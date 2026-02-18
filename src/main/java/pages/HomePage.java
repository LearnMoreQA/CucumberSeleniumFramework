package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    /* Locators */
    @FindBy(xpath = "//h4[text()='Login Disclaimer']")
    private WebElement disclaimerPopup;
    @FindBy(id = "disclaimer_accept")
    private WebElement acceptDisclaimerButton;
    @FindBy(css = ".o_menu_apps")
    private WebElement discussMenu;
    @FindBy(partialLinkText = "CRM")
    private WebElement crmMenu;

    /* Methods */
    public void acceptDisclaimerIfPresent() {
        try {
            if (disclaimerPopup.isDisplayed()) {
                click(acceptDisclaimerButton);
                waitForVisibilityOfElement(discussMenu);
            }
        } catch (NoSuchElementException e) {
                logger.info("Disclaimer popup not present, proceeding without accepting.");
        }
    }
    public void selectDiscuss() {
        waitForVisibilityOfElement(discussMenu);
        click(discussMenu);
    }

    public void clickCrm() {
        waitForVisibilityOfElement(crmMenu);
        click(crmMenu);
    }
}
